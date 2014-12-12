package beans;

import java.util.ArrayList;
import java.util.List;

import genericBean.GenericBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mapping.Cidades;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class CidadeBean extends GenericBean<Cidades, Integer>{

	private EntityManager em = JPAUtil.getEntityManager();
	List<Cidades> cidades = new ArrayList<Cidades>();
	
	public void populateCidade(Integer id_estado){
		getByIdEstado(id_estado);
	}
	
	public void getByIdEstado(Integer id_estado) {
		String ql = "from Cidades c where c.id_estados = (from Estados e where e.id = :id_estado)";
		TypedQuery<Cidades> q = em.createQuery(ql, Cidades.class);
		q.setParameter("id_estado", id_estado);
		cidades = q.getResultList();
	}

	public List<Cidades> getCidades() {
		return cidades;
	}
	
}
