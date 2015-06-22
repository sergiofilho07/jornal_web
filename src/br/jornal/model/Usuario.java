package br.jornal.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String email;
	
	@Column()
	private String img = null;
	
	public String getImg() {
		return img;
	}

	public void setImg(String caminho) {
		this.img = caminho;
	}

	public Collection<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Collection<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(Collection<Classificado> classificados) {
		this.classificados = classificados;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(mappedBy="autor",targetEntity=Noticia.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Noticia> noticias;
	
	@OneToMany(mappedBy="autor", targetEntity=Comentario.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Comentario> comentarios;
	
	@OneToMany(mappedBy = "autor", targetEntity = Classificado.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Classificado> classificados;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="usuario_role",
				joinColumns=@JoinColumn(name="usuario_id", referencedColumnName="id"),
				inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id"))
	private Collection<Role> roles;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isJornalista(){
		for (Role role : roles) {
			if (role.getId() == 3)
				return true;
		}
		return false;
	}
	
	public boolean isLeitor(){
		for (Role role : roles) {
			if (role.getId() == 1)
				return true;
		}
		return false;
	}
	
	public boolean isEditor(){
		for (Role role : roles) {
			if (role.getId() == 2)
				return true;
		}
		return false;
	}
	
	
	
	
}
