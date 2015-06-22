package br.jornal.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

import br.jornal.model.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO{
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void adicionar(Usuario usuario) {
		this.manager.persist(usuario);		
	}

	@Override
	public void remover(Usuario usuario) {
		Usuario usuarioRef = this.manager.find(Usuario.class, usuario.getId());
		this.manager.remove(usuarioRef);		
	}

	@Override
	public void alterar(Usuario usuario) {
		this.manager.merge(usuario);		
	}

	@Override
	public Collection<Usuario> listar() {
		String hql = "Select u from Usuario u";
		return this.manager.createQuery(hql, Usuario.class).getResultList();
	}

	@Override
	public Usuario buscaPorLogin(Usuario usuario) {
		String hql = "Select u from Usuario u where u.login = :usuario_login";
		Query query = this.manager.createQuery(hql, Usuario.class);
		query.setParameter("usuario_login", usuario.getLogin());
		Usuario usuarioLogado = null;
		List<Usuario> lista = query.getResultList();
		if (lista.size() != 0)
			usuarioLogado = lista.get(0);
		return usuarioLogado;
	}
	
}
