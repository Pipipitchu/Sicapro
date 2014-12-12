package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mapping.Funcionarios;
import JPA.JPAUtil;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	EntityManager em = JPAUtil.getEntityManager();
	Funcionarios usuario = new Funcionarios();
	Funcionarios atualUsuario;
	
	public String login() {
		String ql = "from Funcionarios f where f.usuario = :usuario)";
		Query q = em.createQuery(ql, Funcionarios.class);
		q.setParameter("usuario", usuario.getNome());
		if(q.getResultList().isEmpty()){
			return "/login.xhtml?faces-redirect=true";
		}else{
			Funcionarios temp_User = (Funcionarios)q.getResultList().get(0);
			if(temp_User.getSenha().equals(usuario.getSenha())){
				atualUsuario = temp_User;
				return "/index.xhtml?faces-redirect=true";
			}else{
				atualUsuario = null;
				return "/login.xhtml?faces-redirect=true";
			}
		}
	}
	
	public String logout(){
		atualUsuario = null;
		return "/login.xhtml?faces-redirect=true";
		
	}
	
	public void validaUsuario(){
		FacesContext context = FacesContext.getCurrentInstance();
		if(atualUsuario == null){
			System.out.println("Foi");
			context.getApplication().getNavigationHandler().handleNavigation(context, null, "/login.xhtml?faces-redirect=true");
		}
	}

	public Funcionarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Funcionarios usuario) {
		this.usuario = usuario;
	}
	
	
}
