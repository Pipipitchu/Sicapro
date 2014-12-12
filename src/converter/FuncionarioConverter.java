package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Funcionarios;
import beans.FuncionarioBean;

@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter{

	private FuncionarioBean funcionario = new FuncionarioBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Funcionarios funcionario = this.funcionario.getById(id);
        return funcionario;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Funcionarios)) {
	            throw new ConverterException("The value is not a valid Funcionario: " + value);
	        }
	
	        Integer id = ((Funcionarios)value).getIdfuncionario();
	        return (id != null) ? String.valueOf(id) : null;
    }
}
