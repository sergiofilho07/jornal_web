package br.jornal.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.jornal.model.Classificado;
import br.jornal.model.Role;

@Repository
public class RoleDAO implements IRoleDAO{
	
	public RoleDAO() {
	
	}
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void adicionar(Role role){
		this.manager.persist(role);
	}
	@Override
	public Collection<Role> listar(){
		String hql = "select r from Role r";
		return this.manager.createQuery(hql, Role.class).getResultList();
	}
	@Override
	public void remover(Role role){
		Role roleRef = this.manager.find(Role.class, role.getId());
		this.manager.remove(roleRef);
	}
	@Override
	public void alterar(Role role){
		this.manager.merge(role);
	}

	public EntityManager getManager() {
		return manager;
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Role buscarPorId(Role role) {
		String hql = "Select r from Role r where r.id = :id_role";
		Query query = this.manager.createQuery(hql, Role.class);
		query.setParameter("id_role", role.getId());		
		role = (Role) query.getResultList().get(0);
		return role;
	}
	
}
