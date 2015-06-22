package br.jornal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comentario")
public class Comentario {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String texto;
			
	@ManyToOne(optional=false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Usuario autor;
	
	@ManyToOne(optional=false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "noticia_id", referencedColumnName = "id")
	private Noticia noticia;
	
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
