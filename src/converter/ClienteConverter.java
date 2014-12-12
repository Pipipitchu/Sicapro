package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Clientes;
import beans.ClienteBean;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {
	
	private ClienteBean cliente = new ClienteBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Clientes cliente = this.cliente.getById(id);
        return cliente;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Clientes)) {
	            throw new ConverterException("The value is not a valid Cliente: " + value);
	        }
	
	        Integer id = ((Clientes)value).getIdcliente();
	        return (id != null) ? String.valueOf(id) : null;
    }

}
