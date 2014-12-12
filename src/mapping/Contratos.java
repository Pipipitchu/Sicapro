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
public class Contratos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_contrato")
	@SequenceGenerator(name="seq_contrato", sequenceName="seq_contrato")
	private Integer idcontrato;
	private Date data;
	private double valor;
	private String comentario;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idstatus")
	private Status status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idorcamento")
	private Orcamentos orcamento;
	
	public Integer getIdcontrato() {
		return idcontrato;
	}
	public void setIdcontrato(Integer idcontrato) {
		this.idcontrato = idcontrato;
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
	public Orcamentos getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamentos orcamento) {
		this.orcamento = orcamento;
	}
	
	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Contratos other = (Contratos) object;
        if (comentario == null ? other.comentario != null : !comentario.equals(other.comentario)) return false;
        
        return true;
    }


}
