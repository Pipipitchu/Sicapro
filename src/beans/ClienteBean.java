package beans;

import genericBean.GenericBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Clientes;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class ClienteBean extends GenericBean<Clientes, Integer> {

	private EntityManager em = JPAUtil.getEntityManager();
	private Clientes cliente = new Clientes();
	private List<Clientes> clientes;
	private String nome_Cliente;
	
	public String novoCliente() throws IOException {
		super.novo(cliente, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarCliente() {
		Clientes new_cliente = em.merge(cliente);
		new_cliente = cliente;
		super.atualizar(new_cliente, em);
		em.close();
		return "";
	}
	
	public String deletarCliente(Clientes cliente) throws IOException {
		super.deletar(cliente, em);
		em.close();
		reloadPage();
		return "";
	}
	
	@PostConstruct
	public void getAll(){
		clientes = super.getAll(em);
	}
	
	public Clientes getById(Integer id){
		return super.getById(id, em);
	}
	
	public String setValor(Object id){
		return getById((Integer)((Clientes)id).getIdcliente()).getNome();
	}
	
	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}

	public String getNome_Cliente() {
		return nome_Cliente;
	}

	public void setNome_Cliente(String nome_Cliente) {
		this.nome_Cliente = nome_Cliente;
	}

}
