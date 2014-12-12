package mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Cargos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_cliente")
	@SequenceGenerator(name="seq_cliente", sequenceName="seq_cliente")
	private Integer idcargo;
	private String cargo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="cargo")
	private List<Funcionarios> funcionarios;
	
	public Integer getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(Integer idcargo) {
		this.idcargo = idcargo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public List<Funcionarios> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Cargos other = (Cargos) object;
        if (cargo == null ? other.cargo != null : !cargo.equals(other.cargo)) return false;
        
        return true;
    }

}
