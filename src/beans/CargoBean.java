package beans;

import java.io.IOException;
import java.util.List;

import genericBean.GenericBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Cargos;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class CargoBean extends GenericBean<Cargos, Integer>{
	
	private EntityManager em = JPAUtil.getEntityManager();
	private Cargos cargo = new Cargos();
	private List<Cargos> cargos;

	public String novoCargo() throws IOException {
		super.novo(cargo, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarCargo() {
		Cargos new_cargo = em.merge(cargo);
		new_cargo = cargo;
		super.atualizar(new_cargo, em);
		em.close();
		return "";
	}
	
	public String deletarCargo(Cargos cargo) throws IOException {
		super.deletar(cargo, em);
		em.close();
		reloadPage();
		return "";
	}
	
	@PostConstruct
	public void getAll(){
		cargos = super.getAll(em);
	}
	
	public Cargos getById(int id){
		return super.getById(id, em);
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	public List<Cargos> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargos> cargos) {
		this.cargos = cargos;
	}

}
