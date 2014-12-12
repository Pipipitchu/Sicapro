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
public class Status {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_status")
	@SequenceGenerator(name="seq_status", sequenceName="seq_status")	
	private Integer idstatus;
	private String nome;
	private String descricao;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="status")
	private List<Contratos> contratos;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="status")
	private List<Orcamentos> orcamento;
	
	
	public List<Contratos> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}
	public Integer getIdstatus() {
		return idstatus;
	}
	public void setIdstatus(Integer idstatus) {
		this.idstatus = idstatus;
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

	public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Status other = (Status) object;
        if (nome == null ? other.nome != null : !nome.equals(other.nome)) return false;
        
        return true;
    }

}
