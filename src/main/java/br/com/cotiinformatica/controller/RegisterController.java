package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.models.RegisterModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register")

	public ModelAndView register() {

		ModelAndView modelAndView = new ModelAndView("register");

		modelAndView.addObject("model", new RegisterModel());

		return modelAndView;
	}

	// método para receber a requisição POST realizada no SUBMIT do formulário
	@RequestMapping(value = "/cadastrar-usuario", method = RequestMethod.POST)

	public ModelAndView cadastrarUsuario(RegisterModel model) {

		ModelAndView modelandview = new ModelAndView("register");

		try {
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			
			if(usuarioRepository.find(model.getEmail()) != null ) {
				
				modelandview.addObject("erro_email", "O e-mail informado já está cadastrado, tente outro!");
				modelandview.addObject("model", model);
				
			}

			Usuario usuario = new Usuario();

			usuario.setNome(model.getNome());
			usuario.setEmail(model.getEmail());
			usuario.setSenha(model.getSenha());

			
			usuarioRepository.create(usuario);

			modelandview.addObject("mensagem", "Parabéns " + usuario.getNome() + ", sua conta foi criada com sucesso!");
			modelandview.addObject("model", new RegisterModel());

		} catch (Exception e) {

			modelandview.addObject("mensagem", "Ocorreu um erro:" + e.getMessage());

		}

		return modelandview;

	}

}
