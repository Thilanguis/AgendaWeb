package br.com.cotiinformatica.interfaces;

import br.com.cotiinformatica.entities.Usuario;

public interface IUsuarioRepository {

	// Método para gravar usuário da base de dados
	void create(Usuario usuario) throws Exception;

	// Método para consultar no banco de dados 1 usuário
	Usuario find(String email) throws Exception;
	
	//Método para consultar no banco de dados 1 usuário
	Usuario find(String email, String senha) throws Exception;

}
