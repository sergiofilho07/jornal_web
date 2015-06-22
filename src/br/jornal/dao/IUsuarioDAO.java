package br.jornal.dao;

import java.util.Collection;


import br.jornal.model.Usuario;

public interface IUsuarioDAO {
	public void adicionar(Usuario usuario);
	public void remover(Usuario usuario);
	public void alterar(Usuario usuario);
	public Collection<Usuario> listar();
	public Usuario buscaPorLogin(Usuario usuario);

}
