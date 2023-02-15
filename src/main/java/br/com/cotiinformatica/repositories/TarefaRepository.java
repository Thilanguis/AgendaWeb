package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.factories.ConnectionFactory;
import br.com.cotiinformatica.helpers.DataHelper;
import br.com.cotiinformatica.interfaces.ITarefaRepository;

public class TarefaRepository implements ITarefaRepository {

	@Override
	public void create(Tarefa tarefa) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(
				"insert into tarefa(nome, data, hora, descricao, prioridade, idusuario) values(?,?,?,?,?,?)");
		
		statement.setString(1, tarefa.getNome());
		statement.setString(2, DataHelper.formatData(tarefa.getData())); 
		statement.setString(3, tarefa.getHora());
		statement.setString(4, tarefa.getDescricao());
		statement.setInt(5, tarefa.getPrioridade());
		statement.setInt(6, tarefa.getUsuario().getIdUsuario());
		
		statement.execute();
		connection.close();

	}

}