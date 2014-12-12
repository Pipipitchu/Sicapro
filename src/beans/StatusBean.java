package beans;

import genericBean.GenericBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Status;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class StatusBean extends GenericBean<Status, Integer>{

	private EntityManager em = JPAUtil.getEntityManager();
	private Status status = new Status();
	private List<Status> statusList = new ArrayList<Status>();
	
	public String novoStatus() throws IOException{
		super.novo(status, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarStatus(){
		super.atualizar(status, em);
		em.close();
		return "";
	}
	
	public String deletarStatus(Status status) throws IOException{
		super.deletar(status, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	@PostConstruct
	public void getAll(){
		statusList = super.getAll(em);
	}
	
	public Status getById(int id){
		return super.getById(id, em);		
	}
	
	public String setValor(Object id){
		return getById((Integer)((Status)id).getIdstatus()).getNome();
	}

	public List<Status> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

}
