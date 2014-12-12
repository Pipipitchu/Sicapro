package beans;

import java.io.IOException;
import java.util.List;

import genericBean.GenericBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Compromissos;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class CompromissoBean extends GenericBean<Compromissos, Integer> {

	private EntityManager em = JPAUtil.getEntityManager();
	private Compromissos compromisso = new Compromissos();
	private List<Compromissos> compromissos;

	public String novoCompromisso() throws IOException {
		super.novo(compromisso, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarCompromisso() {
		Compromissos new_compromisso = em.merge(compromisso);
		new_compromisso = compromisso;
		super.atualizar(new_compromisso, em);
		em.close();
		return "";
	}
	
	public String deletarCompromisso(Compromissos compromisso) throws IOException {
		super.deletar(compromisso, em);
		em.close();
		reloadPage();
		return "";
	}
	
	@PostConstruct
	public void getAll(){
		compromissos = super.getAll(em);
	}
	
	public Compromissos getById(int id){
		return super.getById(id, em);
	}

	public Compromissos getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromissos compromisso) {
		this.compromisso = compromisso;
	}

	public List<Compromissos> getCompromissos() {
		return compromissos;
	}

	public void setCompromissos(List<Compromissos> compromissos) {
		this.compromissos = compromissos;
	}

}
