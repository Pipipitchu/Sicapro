package mapping;

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
public class Servicos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_servico")
	@SequenceGenerator(name="seq_servico", sequenceName="seq_servico")	
	private Integer idservico;
	private String nome;
	private String descricao;
	private Integer prazo;
	private double valor;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="servico")
	private List<Orcamentos> orcamento;

	public Integer getIdservico() {
		return idservico;
	}
	public void setIdservico(Integer idservico) {
		this.idservico = idservico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getPrazo() {
		return prazo;
	}
	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Servicos other = (Servicos) object;
        if (nome == null ? other.nome != null : !nome.equals(other.nome)) return false;
        
        return true;
    }

}
