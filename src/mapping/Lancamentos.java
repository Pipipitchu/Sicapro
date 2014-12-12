package mapping;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Lancamentos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_lancamento")
	@SequenceGenerator(name="seq_lancamento", sequenceName="seq_lancamento")
	private Integer idlancamento;
	private String descricao;
	private Date data;
	private String tipo;
	private Integer quantidade;
	private double valor;
	private String comentario;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idcliente")
	private Clientes cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idfuncionario")
	private Funcionarios funcionario;
	
	public Integer getIdlancamento() {
		return idlancamento;
	}
	public void setIdlancamento(Integer idlancamento) {
		this.idlancamento = idlancamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Funcionarios getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}
	
	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Lancamentos other = (Lancamentos) object;
        if (descricao == null ? other.descricao != null : !descricao.equals(other.descricao)) return false;
        
        return true;
    }

}
