package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Servicos;
import beans.ServicoBean;

@FacesConverter("servicoConverter")
public class ServicoConverter implements Converter {
	
	private ServicoBean servico = new ServicoBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Servicos servico = this.servico.getById(id);
        return servico;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Servicos)) {
	            throw new ConverterException("The value is not a valid Servico: " + value);
	        }
	
	        Integer id = ((Servicos)value).getIdservico();
	        return (id != null) ? String.valueOf(id) : null;
    }

}
