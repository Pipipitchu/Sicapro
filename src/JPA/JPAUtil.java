package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	    
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgre");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void salvar(EntityManager em, Object o){
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
}
