package br.jornal.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "noticia")
public class Noticia {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false)
	private String subtitulo;
	@Column(nullable=false)
	private String texto;	
	@Column(nullable=false)
	private String img = null;	
		

	@Temporal(TemporalType.DATE)
	@Column(name="data_noticia", nullable = false)
	private Date dataNoticia;
	
	@OneToMany(mappedBy="noticia",targetEntity=Comentario.class,fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Comentario> comentarios;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "secao_id", referencedColumnName = "id")
	private Secao secao;
	
	@ManyToOne(optional=false, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Usuario autor;
		
	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
