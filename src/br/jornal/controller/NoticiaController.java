package br.jornal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.jornal.dao.INoticiaDAO;
import br.jornal.dao.ISecaoDAO;
import br.jornal.dao.IUsuarioDAO;
import br.jornal.dao.NoticiaDAO;
import br.jornal.model.Noticia;
import br.jornal.model.Secao;
import br.jornal.model.Usuario;

@Controller
@Transactional
public class NoticiaController {
	
	@Autowired
	INoticiaDAO noticiaDAO;
	@Autowired
	ISecaoDAO secaoDAO;
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	@RequestMapping("formularioNoticia")
	public String formularioNoticia(Model model, HttpSession session){
		Collection<Secao> secoes = secaoDAO.listar();		
		model.addAttribute("secoes", secoes);		
		return "noticia/formulario_noticia";
	}
	
	@RequestMapping("deletarNoticia")
	public String deletarNoticia(Noticia noticia, HttpSession session){
		Usuario userLogado = usuarioDAO.buscaPorLogin((Usuario) session.getAttribute("usuarioLogado"));
		noticia = noticiaDAO.buscarPorId(noticia);
		if (noticia.getAutor().getId() == userLogado.getId()){
			noticiaDAO.remover(noticia);
			return "redirect:../secao/secoes";
		}
		return "redirect:../secao/secoes";
	}
	
	@RequestMapping(value="adicionarNoticia", method=RequestMethod.POST)	
	public String adicionarNoticia(Noticia noticia, HttpSession session, Long id_secao, @RequestParam("file") MultipartFile file){
		Usuario userLogado = usuarioDAO.buscaPorLogin((Usuario) session.getAttribute("usuarioLogado"));
		noticia.setAutor(userLogado);		
		Secao secao = new Secao();
		secao.setId(id_secao);
		secao = secaoDAO.buscarPorId(secao);
		noticia.setSecao(secao);
		noticia.setDataNoticia(new Date());		
				
		if (!file.isEmpty()) {
			try {
				String nomeImg = new Date().getTime()+""+file.getOriginalFilename();
				String imagem = "/var/www/jornal/images/noticia/"+nomeImg;
				noticia.setImg(nomeImg);
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imagem)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		noticiaDAO.adicionar(noticia);		
		return "../../index";		
	}
	
	@RequestMapping("listarNoticias")	
	public String listarNoticias (Model model) {
		Collection<Noticia> noticias = noticiaDAO.listar();
		model.addAttribute("noticias", noticias);
		return "";
		
	}
	
	@RequestMapping("visualizarNoticia")
	public String listarNoticias (Model model, Noticia noticia) {
		noticia = noticiaDAO.buscarPorId(noticia);
		System.out.println(noticia.getTexto());
		model.addAttribute("noticia", noticia);
		return "noticia/visualizar_noticia";		
		
	}
	

}
