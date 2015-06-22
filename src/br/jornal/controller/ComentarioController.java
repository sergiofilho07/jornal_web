package br.jornal.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.jornal.dao.IComentarioDAO;
import br.jornal.dao.INoticiaDAO;
import br.jornal.dao.ISecaoDAO;
import br.jornal.dao.IUsuarioDAO;
import br.jornal.model.Comentario;
import br.jornal.model.Noticia;
import br.jornal.model.Usuario;

@Transactional
@Controller
public class ComentarioController {	
	@Autowired
	INoticiaDAO noticiaDAO;
	@Autowired
	IUsuarioDAO usuarioDAO;
	@Autowired
	IComentarioDAO comentarioDAO;
	
	@RequestMapping("adicionarComentario")
	public String adicionarComentario(Long id_noticia, HttpSession session, Comentario comentario){
		Usuario userSecao = (Usuario) session.getAttribute("usuarioLogado");
		if (userSecao == null)
			return "redirect: formularioLogin";
		Usuario userLogado = usuarioDAO.buscaPorLogin(userSecao);		
		comentario.setAutor(userLogado);
		Noticia noticia = new Noticia();
		noticia.setId(id_noticia);
		noticia = noticiaDAO.buscarPorId(noticia);
		comentario.setNoticia(noticia);
		comentarioDAO.adicionar(comentario);
		return "redirect:visualizarNoticia?id="+id_noticia;		
	}
	
}
