package br.jornal.dao;

import java.util.Collection;

import br.jornal.model.Classificado;


public interface IClassificadoDAO {
	public void adicionar(Classificado classificado); 
	public Collection<Classificado> listar(); 
	public void remover(Classificado classificado);
	public void alterar(Classificado classificado);
	public Classificado buscarPorId(Classificado classificado);
}
