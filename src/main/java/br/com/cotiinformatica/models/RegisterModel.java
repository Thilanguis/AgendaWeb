package br.com.cotiinformatica.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class RegisterModel {

	private String nome;
	private String email;
	private String senha;
	private String senhaConfirmacao;
	
}
