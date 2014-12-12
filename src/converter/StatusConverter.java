package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Status;
import beans.StatusBean;

@FacesConverter("statusConverter")
public class StatusConverter implements Converter{
	
	private StatusBean statuss = new StatusBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Status status = this.statuss.getById(id);
        return status;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Status)) {
	            throw new ConverterException("The value is not a valid Status: " + value);
	        }
	
	        Integer id = ((Status)value).getIdstatus();
	        return (id != null) ? String.valueOf(id) : null;
    }

}
