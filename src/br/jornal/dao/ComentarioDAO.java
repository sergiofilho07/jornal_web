package br.jornal.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.jornal.model.Comentario;

@Repository
public class ComentarioDAO implements IComentarioDAO{
	
	public ComentarioDAO() {
	
	}
	
	@PersistenceContext
	private EntityManager manager;
	
	public void adicionar(Comentario comentario){
		this.manager.persist(comentario);
	}
	
	public Collection<Comentario> listar(){
		String hql = "Select c from Comentario c";
		return this.manager.createQuery(hql, Comentario.class).getResultList();
	}
	
	public void remover(Comentario comentario){
		Comentario comentarioRef = this.manager.find(Comentario.class, comentario.getId());
		this.manager.remove(comentarioRef);
	}
	
	public void alterar(Comentario comentario){
		this.manager.merge(comentario);
	}
}



