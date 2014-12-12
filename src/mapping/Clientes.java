package mapping;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
 

@Entity
public class Clientes {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_cliente")
	@SequenceGenerator(name="seq_cliente", sequenceName="seq_cliente")
	private Integer idcliente;
	private String nome;
	private String tipocliente;
	private String numdocumento;
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
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="idcliente")
	private List<Compromissos> compromisso;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="cliente")
	private List<Lancamentos> lancamento;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="cliente")
	private List<Orcamentos> orcamento;
	
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipocliente() {
		return tipocliente;
	}
	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}
	public String getNumdocumento() {
		return numdocumento;
	}
	public void setNumdocumento(String numdocumento) {
		this.numdocumento = numdocumento;
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
	public List<Compromissos> getCompromisso() {
		return compromisso;
	}
	public void setCompromisso(List<Compromissos> compromisso) {
		this.compromisso = compromisso;
	}
	public List<Lancamentos> getLancamento() {
		return lancamento;
	}
	public void setLancamento(List<Lancamentos> lancamento) {
		this.lancamento = lancamento;
	}

	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Clientes other = (Clientes) object;
        if (nome == null ? other.nome != null : !nome.equals(other.nome)) return false;
        
        return true;
    }

}
