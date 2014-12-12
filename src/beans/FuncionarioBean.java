package beans;

import genericBean.GenericBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import mapping.Funcionarios;
import JPA.JPAUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean extends GenericBean<Funcionarios, Integer>{

	private EntityManager em = JPAUtil.getEntityManager();
	private Funcionarios funcionario = new Funcionarios();
	private List<Funcionarios> funcionarios;
	private String nova_Senha;
	
	public String novoFuncionario() throws IOException {
		super.novo(funcionario, em);
		em.close();
		reloadPage();
		return "";
	}
	
	public String atualizarFuncionario() {
		Funcionarios new_funcionario = em.merge(funcionario);
		new_funcionario = funcionario;
		super.atualizar(new_funcionario, em);
		em.close();
		return "";
	}
	
	public String deletarFuncionario(Funcionarios funcionario) throws IOException {
		super.deletar(funcionario, em);
		em.close();
		reloadPage();
		return "";
	}
	
	@PostConstruct
	public void getAll(){
		funcionarios = super.getAll(em);
	}
	
	public Funcionarios getById(int id){
		return super.getById(id, em);
	}
	
	public String setValor(Object id){
		return getById((Integer)((Funcionarios)id).getIdfuncionario()).getNome();
	}

	public Funcionarios getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getNova_Senha() {
		nova_Senha = funcionario.getSenha();
		return nova_Senha;
	}

	public void setNova_Senha(String nova_Senha) {
		if(!nova_Senha.equals("") || nova_Senha != null){
			funcionario.setSenha(nova_Senha);
		}
		this.nova_Senha = nova_Senha;
	}

	
}
