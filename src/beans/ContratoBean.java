package beans;

import java.io.IOException;
import java.util.List;

import genericBean.GenericBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Contratos;
//import mapping.Status;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class ContratoBean extends GenericBean<Contratos, Integer>{

	private EntityManager em = JPAUtil.getEntityManager();
	private Contratos contrato = new Contratos();
	private List<Contratos> contratos;
		 
	
	public String novoContrato() throws IOException {
		super.novo(contrato, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarContrato() {
		Contratos new_contrato = em.merge(contrato);
		new_contrato = contrato;
		super.atualizar(new_contrato, em);
		em.close();
		return "";
	}
	
	public String deletarContrato(Contratos contrato) throws IOException {
		super.deletar(contrato, em);
		em.close();
		reloadPage();
		return "";
	}
	
	@PostConstruct
	public void getAll(){
		contratos = super.getAll(em);
	}
	
	public Contratos getById(int id){
		return super.getById(id, em);
	}

	public Contratos getContrato() {
		return contrato;
	}

	public void setContrato(Contratos contrato) {
		this.contrato = contrato;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}

}
