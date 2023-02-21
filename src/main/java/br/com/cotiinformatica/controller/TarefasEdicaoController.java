package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.enums.PrioridadeTarefa;
import br.com.cotiinformatica.helpers.DataHelper;
import br.com.cotiinformatica.models.TarefaEdicaoModel;
import br.com.cotiinformatica.repositories.TarefaRepository;

@Controller
public class TarefasEdicaoController {

	@RequestMapping(value = "/tarefas-edicao")

	public ModelAndView edicao(Integer id, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("tarefas-edicao");

		try {

			// Capturar o usuario autenticado no sistema
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");

			// consultar a tarefa no banco de dados através do id
			TarefaRepository tarefaRepository = new TarefaRepository();
			Tarefa tarefa = tarefaRepository.findById(id, usuario.getIdUsuario());

			if (tarefa != null) {

				TarefaEdicaoModel model = new TarefaEdicaoModel();

				model.setIdTarefa(tarefa.getIdTarefa());
				model.setNome(tarefa.getNome());
				model.setData(DataHelper.formatToString(tarefa.getData()));
				model.setHora(tarefa.getHora());
				model.setDescricao(tarefa.getDescricao());
				model.setPrioridade(tarefa.getPrioridade() == 1 ? "ALTA" : tarefa.getPrioridade() == 2 ? "MEDIA" : tarefa.getPrioridade() == 3 ? "BAIXA" : null);

				modelAndView.addObject("model", model);
				modelAndView.addObject("prioridades", PrioridadeTarefa.values());

			} else {

				modelAndView.setViewName("redirect:tarefas-consulta");

			}

		} catch (Exception e) {

			// Gerando uma mensagem de erro
			modelAndView.addObject("mensagem", "Ocorreu um erro " + e.getMessage());

		}

		return modelAndView;
	}
	
	@RequestMapping(value= "/editar-tarefa", method = RequestMethod.POST)
	
	public ModelAndView editarTarefa(TarefaEdicaoModel model, HttpServletRequest request , Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("tarefas-edicao");
		
		try {
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");
			
			Tarefa tarefa = new Tarefa();

			tarefa.setIdTarefa(model.getIdTarefa());
			tarefa.setNome(model.getNome());
			tarefa.setData(DataHelper.formatToDate(model.getData()));
			tarefa.setHora(model.getHora());
			tarefa.setDescricao(model.getDescricao());
			tarefa.setPrioridade(model.getPrioridade().equals("ALTA") ? 1 : model.getPrioridade().equals("MEDIA") ? 2 : 3);
			tarefa.setUsuario(usuario);

			
			TarefaRepository tarefaRepository = new TarefaRepository();
			tarefaRepository.update(tarefa);
			
			modelAndView.addObject("mensagem", "Tarefa atualizada com sucesso");
			
		} catch (Exception e) {

			modelAndView.addObject("mensagem", "Ocorreu um erro: " + e.getMessage());
			
		}
		
		modelAndView.addObject("model", model);
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());
		
		return modelAndView;
		
	}

}