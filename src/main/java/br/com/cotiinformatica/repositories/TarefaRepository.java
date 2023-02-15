package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		statement.setString(2, DataHelper.formatToString(tarefa.getData()));
		statement.setString(3, tarefa.getHora());
		statement.setString(4, tarefa.getDescricao());
		statement.setInt(5, tarefa.getPrioridade());
		statement.setInt(6, tarefa.getUsuario().getIdUsuario());

		statement.execute();
		connection.close();

	}

	@Override
	public List<Tarefa> findAll(Date dataMin, Date dataMax, Integer idUsuario) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(
				"select * from tarefa where data between ? and ? and idUsuario = ? order by data, hora desc");

		statement.setString(1, DataHelper.formatToString(dataMin));
		statement.setString(2, DataHelper.formatToString(dataMax));
		statement.setInt(3, idUsuario);

		ResultSet resultset = statement.executeQuery();

		// Criando uma lista de tarefas vazia

		List<Tarefa> lista = new ArrayList<Tarefa>();

		while (resultset.next()) {

			Tarefa tarefa = new Tarefa();

			tarefa.setIdTarefa(resultset.getInt("idtarefa"));
			tarefa.setNome(resultset.getString("nome"));
			tarefa.setData(DataHelper.formatToDate(resultset.getString("data")));
			tarefa.setHora(resultset.getString("hora"));
			tarefa.setPrioridade(resultset.getInt("prioridade"));
			tarefa.setDescricao(resultset.getString("descricao"));

			lista.add(tarefa);// adicionando na lista
		}

		connection.close();

		return lista;// retorna a lista

	}

	@Override
	public void update(Tarefa tarefa) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(
				"update tarefa(nome=?, data=?, hora=?, descricao=?, prioridade=? where idtarefa=? and idusuario=?) ");

		statement.setString(1, tarefa.getNome());
		statement.setString(2, DataHelper.formatToString(tarefa.getData()));
		statement.setString(3, tarefa.getHora());
		statement.setString(4, tarefa.getDescricao());
		statement.setInt(5, tarefa.getPrioridade());
		statement.setInt(6, tarefa.getIdTarefa());
		statement.setInt(7, tarefa.getUsuario().getIdUsuario());

		statement.execute();
		connection.close();
	}

	@Override
	public void delete(Tarefa tarefa) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(
				"delete from tarefa where idtarefa=? and idusuario=?) ");

		statement.setInt(1, tarefa.getIdTarefa());
		statement.setInt(2, tarefa.getUsuario().getIdUsuario());

		statement.execute();
		connection.close();
		
	}

	@Override
	public Tarefa findById(Integer idTarefa, Integer idUsuario) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(
				"select * from tarefa where idtarefa = ? and ? and idusuario = ? ");

		statement.setInt(1, idTarefa);
		statement.setInt(2, idUsuario);
		

		ResultSet resultset = statement.executeQuery();

		// Criando uma lista de tarefas vazia

		Tarefa tarefa = null;

		if (resultset.next()) {

			tarefa = new Tarefa();

			tarefa.setIdTarefa(resultset.getInt("idtarefa"));
			tarefa.setNome(resultset.getString("nome"));
			tarefa.setData(DataHelper.formatToDate(resultset.getString("data")));
			tarefa.setHora(resultset.getString("hora"));
			tarefa.setPrioridade(resultset.getInt("prioridade"));
			tarefa.setDescricao(resultset.getString("descricao"));

		}

		connection.close();

		return tarefa;// retorna a lista
	}
}