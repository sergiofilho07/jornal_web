package br.jornal.dao;

import java.util.Collection;

import br.jornal.model.Role;

public interface IRoleDAO {
	public void adicionar(Role role);
	public Collection<Role> listar();		
	public void remover(Role role);			
	public void alterar(Role role);
	public Role buscarPorId(Role role);
}
