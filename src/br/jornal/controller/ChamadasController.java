package br.jornal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.jornal.dao.ISecaoDAO;

@Transactional
@Controller
public class ChamadasController {
	@Autowired
	private ISecaoDAO secaoDAO;
	
	@RequestMapping("adicionarTopo")
	public String adicionarTopo(Model model){
		model.addAttribute("secoes", secaoDAO.listar());		
		return "topo/topo";
	}
}
