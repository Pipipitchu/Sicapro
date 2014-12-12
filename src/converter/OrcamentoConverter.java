package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Orcamentos;
import beans.OrcamentoBean;

@FacesConverter("orcamentoConverter")
public class OrcamentoConverter implements Converter{
	
	private OrcamentoBean orcamento = new OrcamentoBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Orcamentos orcamento = this.orcamento.getById(id);
        return orcamento;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Orcamentos)) {
	            throw new ConverterException("The value is not a valid Status: " + value);
	        }
	
	        Integer id = ((Orcamentos)value).getIdorcamento();
	        return (id != null) ? String.valueOf(id) : null;
    }

}
