package br.jornal.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.jornal.model.Secao;
import br.jornal.model.Usuario;

@Repository
public class SecaoDAO implements ISecaoDAO{
	
	public SecaoDAO() {
	
	}
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void adicionar(Secao secao) {
		this.manager.persist(secao);
	}
	
	@Override
	public Collection<Secao> listar() {
		String hql = "Select s from Secao s";
		return this.manager.createQuery(hql, Secao.class).getResultList();
	}
	
	@Override
	public void remover(Secao secao){
		Secao secaoRef = this.manager.find(Secao.class, secao.getId());
		this.manager.remove(secaoRef);
	}
	
	@Override
	public void alterar(Secao secao){
		this.manager.merge(secao);
	}

	@Override
	public Secao buscarPorId(Secao secao) {
		String hql = "Select s from Secao s where s.id = :id_secao";
		Query query = this.manager.createQuery(hql, Secao.class);
		query.setParameter("id_secao", secao.getId());		
		secao = (Secao) query.getResultList().get(0);
		return secao;
	}
}
