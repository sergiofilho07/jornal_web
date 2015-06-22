package br.jornal.dao;

import java.util.Collection;
import br.jornal.model.Secao;

public interface ISecaoDAO {
	public void adicionar(Secao secao); 
	public Collection<Secao> listar(); 
	public void remover(Secao secao);
	public void alterar(Secao secao);
	public Secao buscarPorId(Secao secao);
	
	
	
}
