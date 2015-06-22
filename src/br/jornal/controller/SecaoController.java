package br.jornal.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.jornal.dao.ISecaoDAO;
import br.jornal.model.Noticia;
import br.jornal.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	private ISecaoDAO secaoDAO;
	
	@RequestMapping("adicionarSecao")
	public String adicionarSecao(Secao secao){
		this.secaoDAO.adicionar(secao);
		return "../../index";
	}
	
	@RequestMapping("formularioSecao")
	public String formularioSecao(Secao secao){
		return "secao/formulario_secao";
	}
	
	@RequestMapping("listarSecoes")
	public String listarSecoes(Model model){
		Collection<Secao> secoes = secaoDAO.listar();
		model.addAttribute("secoes", secoes);
		return "secao/secoes";
	}
	
	@RequestMapping("listarManchetes")
	public String listarManchetes(Model model, Secao secao){
		Secao s = secaoDAO.buscarPorId(secao);
		Collection<Noticia> noticias = s.getNoticias();
		model.addAttribute("noticias", noticias);
		return "manchete/manchetes";
	}
}
