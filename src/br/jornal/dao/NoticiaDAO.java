package br.jornal.dao;

import java.util.Collection;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import br.jornal.model.Noticia;


@Repository
public class NoticiaDAO implements INoticiaDAO{
	
	public NoticiaDAO() {
	
	}
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void adicionar(Noticia noticia){
		this.manager.persist(noticia);
	}
	
	@Override
	public Collection<Noticia> listar(){
		String hql = "Select n from Noticia n";
		return this.manager.createQuery(hql, Noticia.class).getResultList();
	}
	
	@Override
	public void remover(Noticia noticia){
		Noticia noticiaRef = this.manager.find(Noticia.class, noticia.getId());
		this.manager.remove(noticiaRef);
	}
	
	@Override
	public void alterar(Noticia noticia){
		this.manager.merge(noticia);
	}

	@Override
	public Noticia buscarPorId(Noticia noticia) {
		String hql = "Select n from Noticia n where n.id = :id_noticia";
		Query query = this.manager.createQuery(hql, Noticia.class);
		query.setParameter("id_noticia", noticia.getId());		
		noticia = (Noticia) query.getResultList().get(0);
		return noticia;
	}
	
	
}
