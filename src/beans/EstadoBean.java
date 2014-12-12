package beans;

import genericBean.GenericBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Estados;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class EstadoBean extends GenericBean<Estados, Integer>{
	
	private EntityManager em = JPAUtil.getEntityManager();
	private List<Estados> estados = new ArrayList<Estados>();
	private Integer estado;
	
	@PostConstruct
	private void populateEstadosList(){
		estados = super.getAll(em);
	}
	
	/*
	public Integer getIdEstadoPorNome(String nome_estado){
		String ql = "select e.id from Estados e where e.nome = :nome_estado";
		TypedQuery<Integer> q = em.createQuery(ql, Integer.class);
		q.setParameter("nome_estado", nome_estado);
		List<Integer> list = q.getResultList();
		if(list.isEmpty()){
			return 0;
		}
		return list.get(0);
	}*/

	public List<Estados> getEstados() {
		return estados;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}