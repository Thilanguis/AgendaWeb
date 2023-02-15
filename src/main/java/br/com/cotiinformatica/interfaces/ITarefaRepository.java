package br.com.cotiinformatica.interfaces;

import java.util.Date;
import java.util.List;

import br.com.cotiinformatica.entities.Tarefa;

public interface ITarefaRepository {

	//método para incluir uma tarefa
	void create (Tarefa tarefa) throws Exception;
	
	//método para atualizar uma tarefa no banco de dados
	void update(Tarefa tarefa) throws Exception;
	
	void delete(Tarefa tarefa) throws Exception;
	
	//método para poder realizar a consulta de tarefas por data e por usuário
	List<Tarefa> findAll(Date dataMin, Date dataMax, Integer idUsuario) throws Exception;
	
	//método para criar uma tarefa atravéz do id e id usuario
	Tarefa findById (Integer idTarefa, Integer idUsuario) throws Exception;
}
