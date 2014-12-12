package mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sub_servicos")
public class SubServicos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_sub_servico")
	@SequenceGenerator(name="seq_sub_servico", sequenceName="seq_sub_servico")	
	private Integer idsubservico;
	private String nome;
	private String descricao;
	private Integer prazo;
	private double valor;
	
	public Integer getIdsubservico() {
		return idsubservico;
	}
	public void setIdsubservico(Integer idsubservico) {
		this.idsubservico = idsubservico;
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

}
