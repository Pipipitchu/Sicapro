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
public class Compromissos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_compromisso")
	@SequenceGenerator(name="seq_compromisso", sequenceName="seq_compromisso")
	private Integer idcompromisso;
	private Date data;
	private String hora;
	private String comentario;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    public Clientes idcliente;
	
	public Integer getIdcompromisso() {
		return idcompromisso;
	}
	public void setIdcompromisso(Integer idcompromisso) {
		this.idcompromisso = idcompromisso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Clientes getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Clientes idcliente) {
		this.idcliente = idcliente;
	}
	
	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Compromissos other = (Compromissos) object;
        if (comentario == null ? other.comentario != null : !comentario.equals(other.comentario)) return false;
        
        return true;
    }

}
