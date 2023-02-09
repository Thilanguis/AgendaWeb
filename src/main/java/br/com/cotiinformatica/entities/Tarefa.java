package br.com.cotiinformatica.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Usando o LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Tarefa {

	private Integer idTarefa;	
	private String nome;	
	private Date data;	
	private String hora;
	private String descricao;
	private Integer prioridade;
	private Usuario usuario; // Associação (TER-1)
	/*
	primary key(idtarefa),
	foreign key(idusuario) references usuario(idusuario),
	check(prioridade in(1, 2, 3))
	*/
}
