package br.jornal.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.jornal.model.Classificado;
import br.jornal.model.Noticia;


@Repository
public class ClassificadoDAO implements IClassificadoDAO{
	
	public ClassificadoDAO() {
	
	}
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void adicionar(Classificado classificado){
		this.manager.persist(classificado);
	}
	
	@Override
	public Collection<Classificado> listar() {
		String hql = "Select c from Classificado c";
		return this.manager.createQuery(hql, Classificado.class).getResultList();
	}
	
	@Override
	public void remover(Classificado classificado){
		Classificado classificadoRef = this.manager.find(Classificado.class, classificado.getId());
		this.manager.remove(classificadoRef);
	}
	
	@Override
	public void alterar(Classificado classificado){
		this.manager.merge(classificado);
	}

	@Override
	public Classificado buscarPorId(Classificado classificado) {
		String hql = "Select c from Classificado c where c.id = :id_classificado";
		Query query = this.manager.createQuery(hql, Classificado.class);
		query.setParameter("id_classificado", classificado.getId());		
		classificado = (Classificado) query.getResultList().get(0);
		return classificado;
	}
}
