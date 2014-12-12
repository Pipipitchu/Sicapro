package beans;

import genericBean.GenericBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Servicos;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class ServicoBean extends GenericBean<Servicos, Integer>{

	private EntityManager em = JPAUtil.getEntityManager();
	private Servicos servico = new Servicos();
	private List<Servicos> servicos;
	
	
	public String novoServico() throws IOException{
		super.novo(servico, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarServico(){
		super.atualizar(servico, em);
		em.close();
		return"";
	}
	
	public String deletarServico(Servicos servico) throws IOException{
		super.deletar(servico, em);
		em.close();
		reloadPage();
		return "";
	}
	
	@PostConstruct
	public void getAll(){
		servicos = super.getAll(em);
	}
	
	public Servicos getById(int id){
		return super.getById(id, em);
	}
	
	public String setValor(Object id){
		return getById((Integer)((Servicos)id).getIdservico()).getNome();
	}

	public Servicos getServico() {
		return servico;
	}

	public void setServico(Servicos servico) {
		this.servico = servico;
	}

	public List<Servicos> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}

}
