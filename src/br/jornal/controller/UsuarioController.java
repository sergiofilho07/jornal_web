package br.jornal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.jornal.dao.IRoleDAO;
import br.jornal.dao.IUsuarioDAO;
import br.jornal.model.Role;
import br.jornal.model.Usuario;

@Transactional
@Controller 
public class UsuarioController {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	@Autowired
	private IRoleDAO roleDAO;
	
	@RequestMapping("formularioUsuario")
	public String formularioUsuario(Long id_role){
		if(id_role==1L)
			return "usuario/formulario_leitor";
		else if(id_role==3L)
			return "usuario/formulario_jornalista";
		return null;
	}
	
	@RequestMapping("adicionarLeitor")
	public String AdicionarLeitor(Usuario usuario){
		Role role = new Role();
		role.setId(1L);
		role = roleDAO.buscarPorId(role);		
		Collection<Role> roles = new ArrayList<Role>(); 
		roles.add(role);		
		usuario.setRoles(roles);	
		this.usuarioDAO.adicionar(usuario);
		return "../../index";
	}
	
	@RequestMapping(value="adicionarJornalista", method=RequestMethod.POST)
	public String AdicionarJornalista(Usuario usuario, @RequestParam("file") MultipartFile file){
		Role role = new Role();
		role.setId(3L);
		role = roleDAO.buscarPorId(role);		
		Collection<Role> roles = new ArrayList<Role>(); 
		roles.add(role);		
		role = new Role();
		role.setId(1L);
		role = roleDAO.buscarPorId(role);
		roles.add(role);		
		usuario.setRoles(roles);
		if (!file.isEmpty()) {
			try {
				String nomeImg = new Date().getTime()+""+file.getOriginalFilename();
				String imagem = "/var/www/jornal/images/usuario/"+nomeImg;
				usuario.setImg(nomeImg);
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imagem)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	
		this.usuarioDAO.adicionar(usuario);
		return "../../index";
	}
	
	@RequestMapping("formularioLogin")
	public String formularioLogin(){		
		return "usuario/formulario_login";
	}
	
	@RequestMapping("logarUsuario")
	public String logarUsuario(Usuario usuario, HttpSession session){		
		Usuario usuarioLogado = usuarioDAO.buscaPorLogin(usuario);
		if(usuarioLogado == null){
			
		}
		else{			
			if(usuario.getSenha().equals(usuarioLogado.getSenha()) ){
				session.setAttribute("usuarioLogado", usuarioLogado);
				return "../../index";
			}
		}
		return "usuario/formulario_login";		
		
	}
	
	
}
