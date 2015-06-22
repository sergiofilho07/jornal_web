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
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String role;
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.LAZY, cascade = CascadeType.ALL)	
	private Collection<Usuario> usuario;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public Collection<Usuario> getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Collection<Usuario> usuario) {
//		this.usuario = usuario;
//	}


}
