package mapping;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidades {
	
	@Id
	private int id;
	private String nome;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_estados")
    public Estados id_estados;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estados getId_estados() {
		return id_estados;
	}

	public void setId_estados(Estados id_estados) {
		this.id_estados = id_estados;
	}

}
