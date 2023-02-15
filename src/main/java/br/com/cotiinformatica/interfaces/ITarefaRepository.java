package br.com.cotiinformatica.interfaces;

import br.com.cotiinformatica.entities.Tarefa;

public interface ITarefaRepository {

	//método para incluir uma tarefa
	void create (Tarefa tarefa) throws Exception;
	
}
