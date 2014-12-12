package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Compromissos;
import beans.CompromissoBean;


@FacesConverter("compromissoConverter")
public class CompromissoConverter implements Converter {

	private CompromissoBean compromisso = new CompromissoBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Compromissos compromisso = this.compromisso.getById(id);
        return compromisso;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Compromissos)) {
	            throw new ConverterException("The value is not a valid Compromisso: " + value);
	        }
	
	        Integer id = ((Compromissos)value).getIdcompromisso();
	        return (id != null) ? String.valueOf(id) : null;
    }

}
