package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Lancamentos;
import beans.LancamentoBean;

@FacesConverter("lancamentoConverter")
public class LancamentoConverter implements Converter{
	
	private LancamentoBean lancamento = new LancamentoBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Lancamentos lancamento = this.lancamento.getById(id);
        return lancamento;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Lancamentos)) {
	            throw new ConverterException("The value is not a valid Funcionario: " + value);
	        }
	
	        Integer id = ((Lancamentos)value).getIdlancamento();
	        return (id != null) ? String.valueOf(id) : null;
    }

}
