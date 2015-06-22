package br.jornal.dao;

import java.util.Collection;

import br.jornal.model.Comentario;

public interface IComentarioDAO {
	public void adicionar(Comentario comentario); 
	public Collection<Comentario> listar(); 
	public void remover(Comentario comentario);
	public void alterar(Comentario comentario);

}
