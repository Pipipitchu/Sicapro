package mapping;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Orcamentos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_orcamento")
	@SequenceGenerator(name="seq_orcamento", sequenceName="seq_orcamento")
	private Integer idorcamento;
	private Date data;
	private double valor;
	private String comentario;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="orcamento")
	private List<Contratos> contrato;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idstatus")
	private Status status;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idcliente")
	private Clientes cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idfuncionario")
	private Funcionarios funcionario;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idservico")
	private Servicos servico;
	
	public Integer getIdorcamento() {
		return idorcamento;
	}
	public void setIdorcamento(Integer idorcamento) {
		this.idorcamento = idorcamento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	public Servicos getServico() {
		return servico;
	}
	public void setServico(Servicos servico) {
		this.servico = servico;
	}

	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Orcamentos other = (Orcamentos) object;
        if (comentario == null ? other.comentario != null : !comentario.equals(other.comentario)) return false;
        
        return true;
    }

}
