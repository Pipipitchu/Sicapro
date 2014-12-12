package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Contratos;
import beans.ContratoBean;


@FacesConverter("contratoConverter")
public class ContratoConverter implements Converter{
	
	private ContratoBean contrato = new ContratoBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Contratos contrato = this.contrato.getById(id);
        return contrato;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Contratos)) {
	            throw new ConverterException("The value is not a valid Contrato: " + value);
	        }
	
	        Integer id = ((Contratos)value).getIdcontrato();
	        return (id != null) ? String.valueOf(id) : null;
    }

}
