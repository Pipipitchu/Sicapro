package mapping;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import security.HashMD5;

@Entity
public class Funcionarios extends HashMD5{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_funcionario")
	@SequenceGenerator(name="seq_funcionario", sequenceName="seq_funcionario")
	private Integer idfuncionario;
	private String nome;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String cep;
	private String uf;
	private String telefone;
	private String celular;
	private String email;
	private Date datacadastro;
	
	@Column(unique=true)
	private String usuario;
	private String senha;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idcargo")
	private Cargos cargo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="funcionario")
	private List<Lancamentos> lancamento;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="funcionario")
	private List<Orcamentos> orcamento;

	public Integer getIdfuncionario() {
		return idfuncionario;
	}
	public void setIdfuncionario(Integer idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	public Cargos getCargo() {
		return cargo;
	}
	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}	
	public List<Lancamentos> getLancamento() {
		return lancamento;
	}
	public void setLancamento(List<Lancamentos> lancamento) {
		this.lancamento = lancamento;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha.length() > 8){
			this.senha = senha;
		}else{
			this.senha = convertStringToMd5(senha);
		}
	}
	
	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Funcionarios other = (Funcionarios) object;
        if (nome == null ? other.nome != null : !nome.equals(other.nome)) return false;
        
        return true;
    }

}
