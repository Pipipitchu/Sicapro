package beans;

import genericBean.GenericBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Orcamentos;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class OrcamentoBean extends GenericBean<Orcamentos, Integer> {

	private EntityManager em = JPAUtil.getEntityManager();
	private Orcamentos orcamento = new Orcamentos();
	private List<Orcamentos> orcamentos = new ArrayList<Orcamentos>();
	
	public String novoOrcamento() throws IOException {
		super.novo(orcamento, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarOrcamento() {
		Orcamentos new_orcamento = em.merge(orcamento);
		new_orcamento = orcamento;
		super.atualizar(new_orcamento, em);
		em.close();
		return "";
	}
	
	public String deletarOrcamento(Orcamentos orcamento) throws IOException {
		super.deletar(orcamento, em);
		em.close();
		reloadPage();
		return "";
	}
	
	@PostConstruct
	public void getAll(){
		orcamentos = super.getAll(em);
	}
	
	public Orcamentos getById(int id){
		return super.getById(id, em);
	}

	public Orcamentos getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamentos orcamento) {
		this.orcamento = orcamento;
	}

	public List<Orcamentos> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamentos> orcamentos) {
		this.orcamentos = orcamentos;
	}

}
