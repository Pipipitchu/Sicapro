package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mapping.Cargos;
import beans.CargoBean;

@FacesConverter("cargoConverter")
public class CargoConverter implements Converter{

	private CargoBean cargo = new CargoBean();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("The value is not a valid ID number: " + value);
        }

        int id = Integer.parseInt(value);
        Cargos cargo = this.cargo.getById(id);
        return cargo;
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
	        if (value == null || value.equals("")) {
	            return null;
	        }
	
	        if (!(value instanceof Cargos)) {
	            throw new ConverterException("The value is not a valid Cliente: " + value);
	        }
	
	        Integer id = ((Cargos)value).getIdcargo();
	        return (id != null) ? String.valueOf(id) : null;
    }
}
