package beans;

import genericBean.GenericBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Lancamentos;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class LancamentoBean extends GenericBean<Lancamentos, Integer>{

	private EntityManager em = JPAUtil.getEntityManager();
	private Lancamentos lancamento = new Lancamentos();
	private List<Lancamentos> lancamentos;
	
	public String novoLancamento() throws IOException {
		super.novo(lancamento, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarLancamento() {
		Lancamentos new_lancamentos = em.merge(lancamento);
		new_lancamentos = lancamento;
		super.atualizar(new_lancamentos, em);
		em.close();
		return "";
	}
	
	public String deletarLancamento(Lancamentos lancamento) throws IOException {
		super.deletar(lancamento, em);
		em.close();
		reloadPage();
		return "";
	}	
	
	@PostConstruct
	public void getAll(){
		lancamentos = super.getAll(em);
	}
	
	public Lancamentos getById(int id){
		return super.getById(id, em);
	}

	public Lancamentos getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamentos lancamento) {
		this.lancamento = lancamento;
	}

	public List<Lancamentos> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamentos> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
