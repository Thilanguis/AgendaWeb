package br.com.cotiinformatica.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.DataHelper;
import br.com.cotiinformatica.models.TarefaConsultaModel;
import br.com.cotiinformatica.repositories.TarefaRepository;

@Controller
public class TarefasConsultasController {

	@RequestMapping(value = "/tarefas-consulta")

	public ModelAndView consulta() {

		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");

		modelAndView.addObject("model", new TarefaConsultaModel());

		return modelAndView;
	}

	@RequestMapping(value = "/consultar-tarefas", method = RequestMethod.GET)

	public ModelAndView consultarTarefas(TarefaConsultaModel model, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");

		try {

			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");

			Date dataMin = DataHelper.formatToDate(model.getDataMin());
			Date dataMax = DataHelper.formatToDate(model.getDataMax());

			TarefaRepository tarefaRepository = new TarefaRepository();

			// acessando o repositório e consultar as tarefas
			List<Tarefa> lista = tarefaRepository.findAll(dataMin, dataMax, usuario.getIdUsuario());

			// eviando a lista de tarefas para a página
			modelAndView.addObject("tarefas", lista);

			// gerando uma mensagem
			if (lista.size() > 0) {
				modelAndView.addObject("mensagem", lista.size() + " Tarefa(s) encontradas para o período especificado.");
			}
			
			else {			
				modelAndView.addObject("mensagem", "Nenhuma tarefa foi encontrada para o período especificado.");
				
			}
		} catch (Exception e) {

			modelAndView.addObject("mensagem", "Ocorreu um erro" + e.getMessage());

		}

		modelAndView.addObject("model", model);
		return modelAndView;

	}
	
	@RequestMapping(value = "/tarefas-exclusao", method = RequestMethod.GET)
	
	public ModelAndView excluirTarefa(Integer id, HttpServletRequest request) {
		
		 ModelAndView modelandview = new ModelAndView("tarefas-consulta");

		 try {
			 
			 Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");
			 
			 Tarefa tarefa = new Tarefa();
			 
			 tarefa.setIdTarefa(id);
			 tarefa.setUsuario(usuario);
			 
			 TarefaRepository tarefaRepository = new TarefaRepository();
			 tarefaRepository.delete(tarefa);
			 
			 modelandview.addObject("mensagem", "Tarefa excluida com sucesso!");
			
		} catch (Exception e) {
			
			modelandview.addObject("mensagem", "Ocorreu um erro: " + e.getMessage());
			
		}
		 
		modelandview.addObject("model", new TarefaConsultaModel());
		return modelandview;
	}
}
