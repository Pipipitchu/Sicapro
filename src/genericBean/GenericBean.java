package genericBean;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

public class GenericBean<Classe , Tipo_Id>{

	public void novo(Classe entity, EntityManager em){
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public void atualizar(Classe entity, EntityManager em){
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
	
	public void deletar(Classe entity, EntityManager em){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		entity = em.merge(entity);
		em.remove(entity);
		tx.commit();
	}
	
	public Classe getById(Tipo_Id id, EntityManager em) {
		Classe entity = (Classe) em.find(getTypeClass(), id);
		return entity;
	}
	
	@SuppressWarnings ("unchecked")	
	public List<Classe> getAll(EntityManager em){
		Query q = em.createQuery(" from " + getTypeClass().getName(), getTypeClass());
		return q.getResultList();
	}
		
	public Class<Classe> getTypeClass(){
		@SuppressWarnings ("unchecked")	
		Class<Classe> clazz = (Class<Classe>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];	
		return clazz;	
	}
	
	public void reloadPage() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

}	