package br.com.cotiinformatica.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.messages.MailMessage;
import br.com.cotiinformatica.models.PasswordModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class PasswordController {

	@RequestMapping(value = "/password")

	public ModelAndView password() {

		ModelAndView modelAndView = new ModelAndView("password");

		modelAndView.addObject("model", new PasswordModel());

		return modelAndView;

	}

	@RequestMapping(value = "/recuperar-senha", method = RequestMethod.POST)

	public ModelAndView recuperarSenha(PasswordModel model) {

		ModelAndView modelandview = new ModelAndView("password");

		try {

			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(model.getEmail());

			if (usuario != null) {

				usuario.setSenha(getRandom()); // gerando uma nova senha aleatória
				enviarEmailDeRecuperacaoDeSenha(usuario); // enviando email para o usuário
				usuarioRepository.update(usuario.getIdUsuario(), usuario.getSenha());

				modelandview.addObject("mensagem", "Recuperação de senha realizada com sucesso, por favor verifique sua conta de email");

			} else {

				modelandview.addObject("mensagem", "O email informado não foi encontrado");

			}

		} catch (Exception e) {

			modelandview.addObject("mensagem", "Ocorreu um erro: " + e.getMessage());

		}

		modelandview.addObject("model", new PasswordModel());
		return modelandview;
	}

	private void enviarEmailDeRecuperacaoDeSenha(Usuario usuario) throws Exception {

		String assunto = "Recuperação de senha de acesso";
		String mensagem = "Olá" + usuario.getNome();
		mensagem += "\n\n Sua senha foi atualizada para " + usuario.getSenha();
		mensagem += "\n Por favor, utilize esta senha para acessar a agenda.";
		mensagem += "\n Ao acessar você poderá atualizar sua senha para uma nova senha.";
		mensagem += "\n\n";
		mensagem += "Att, Equipe DeadByDaylight";

		MailMessage.send(usuario.getEmail(), assunto, mensagem);

	}

	// Método simples para gerar uma senha aleatória para o usuário
	private String getRandom() {

		return String.valueOf(new Random().nextInt(999999999));
	}

}
