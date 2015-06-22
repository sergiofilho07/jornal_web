package br.jornal.controller;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.jornal.dao.IClassificadoDAO;
import br.jornal.dao.IUsuarioDAO;
import br.jornal.dao.UsuarioDAO;
import br.jornal.model.Classificado;
import br.jornal.model.Usuario;

@Transactional
@Controller
public class ClassificadoController {
	
	@Autowired
	private IClassificadoDAO classificadoDAO;
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@RequestMapping("formularioClassificado")
	public String formularioClassificado(){
		return "classificado/formulario_classificado";
	}
	
	@RequestMapping("adicionarClassificado")
	public String adicionarClassificado(Classificado classificado, HttpSession session){
//		Usuario userLogado = usuarioDAO.buscaPorLogin((Usuario) session.getAttribute("usuarioLogado"));
//		classificado.setAutor(userLogado);
		this.classificadoDAO.adicionar(classificado);
		return "../../index";
	}	

	@RequestMapping("visualizarClassificados")
	public String visualizarClassificados(Model model){
		Collection<Classificado> classificados = classificadoDAO.listar();
		model.addAttribute("classificados", classificados);
		return "classificado/visualizar_classificados";
	}
	
	@RequestMapping("adicionarOferta")
	public String adicionarOferta(Long id_classificado, Double oferta, HttpSession session){
		Usuario userSecao = (Usuario) session.getAttribute("usuarioLogado");
		if (userSecao == null)
			return "redirect:formularioLogin";
		Usuario userLogado = usuarioDAO.buscaPorLogin(userSecao);
		if (!userLogado.isLeitor())
			return "redirect:formularioLogin";
		Classificado classificado = new Classificado();
		classificado.setId(id_classificado);
		classificado = classificadoDAO.buscarPorId(classificado);		
		if(oferta >= classificado.getPreco()){
			if( classificado.getMelhorOferta() == null || oferta > classificado.getMelhorOferta()){
				classificado.setMelhorOferta(oferta);
				classificado.setDataOferta(new Date());
				classificado.setAutor(userLogado);
				classificadoDAO.alterar(classificado);
			}
		}
		return "redirect:visualizarClassificados";
		
	}

}
