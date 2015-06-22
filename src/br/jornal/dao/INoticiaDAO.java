package br.jornal.dao;

import java.util.Collection;

import br.jornal.model.Noticia;


public interface INoticiaDAO {
		public void adicionar(Noticia noticia);
		public Collection<Noticia> listar();		
		public void remover(Noticia noticia);			
		public void alterar(Noticia noticia);
		public Noticia buscarPorId(Noticia noticia);
			
}
