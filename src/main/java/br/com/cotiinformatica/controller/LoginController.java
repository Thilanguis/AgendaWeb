package br.com.cotiinformatica.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

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

	public ModelAndView autenticarUsuario(LoginModel model, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("login");

		try {

			// consultar o usuário no banco de dados através do email e da senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(model.getEmail(), model.getSenha());

			if (usuario != null) {

				// Armazenar os dados do usuário em sessão
				request.getSession().setAttribute("usuario_auth", usuario);

				// redirecionamento
				modelAndView.setViewName("redirect:tarefas-consulta");

			} else {

				modelAndView.addObject("mensagem", "Acesso negado, e-mail ou senha inválidos.");

			}

		} catch (Exception e) {

			modelAndView.addObject("mensagem", "Ocorreu um erro" + e.getMessage());

		}

		// Se o usuário estiver retornando para a página de login
		// Criamos uma nova instância da classe LoginModel
		if (modelAndView.getViewName().equals("login")) {

			modelAndView.addObject("model", new LoginModel()); // retorna página em branco e apaga tudo
			// modelAndView.addObject("model", model); // Não apaga a senha e id no login

		}

		return modelAndView;

	}

	@RequestMapping(value = "/logout")

	public ModelAndView logout(HttpServletRequest request) {

		// apagar uma variável de uma sessão
		request.getSession().removeAttribute("usuario_auth");

		// apagar todas as variáveis gravados na sessão
		request.getSession().invalidate();

		ModelAndView modelAndView = new ModelAndView("redirect:/");

		return modelAndView;

	}

}
