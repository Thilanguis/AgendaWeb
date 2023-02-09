package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.models.LoginModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class LoginController {

	// método para mapear a página inicial do projeto
	// WEB-INF/views/login.jsp
	@RequestMapping(value = "/")
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView("login");

		modelAndView.addObject("model", new LoginModel());

		return modelAndView;

	}

	@RequestMapping(value = "/autenticar-usuario", method = RequestMethod.POST)

	public ModelAndView autenticarUsuario(LoginModel model) {

		ModelAndView modelAndView = new ModelAndView("login");
		
		try {
			
			//consultar o usuário no banco de dados através do email e da senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(model.getEmail(), model.getSenha());
			
			if (usuario != null) {
				
				modelAndView.addObject("mensagem", "Olá " + usuario.getNome() + ", seja bem-vindo a AgendaWeb!");
				modelAndView.setViewName("tarefas-consulta");
				
			}
			else {
				
				modelAndView.addObject("mensagem", "Acesso negado, e-mail ou senha inválidos.");
				
			}

		} 
		catch (Exception e) {

			modelAndView.addObject("mensagem", "Ocorreu um erro" + e.getMessage());
			
		}
		
		//Se o usuário estiver retornando para a página de login
		//Criamos uma nova instância da classe LoginModel
		if (modelAndView.getViewName().equals("login")) {
			
			modelAndView.addObject("model", new LoginModel());
			
		}

		return modelAndView;

	}

}
