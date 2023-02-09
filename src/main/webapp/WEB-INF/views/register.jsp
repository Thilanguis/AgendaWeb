<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usu�rio</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
	label.error {color: red}
	input.error {border: 1px solid red}
</style>

</head>
<body class="bg-secondary">

	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card mt-5">
				<div class="card-body">

					<div class="text-center">
						<h5 class="mt-2">Crie sua Conta de Usu�rio</h5>
						<p>Preencha os campos para cadastrar sua conta!</p>
						<hr>
					</div>

					<form action="cadastrar-usuario" method="post" id="formCadastro">

						<div class="mb-3">
							<label>Nome de usu�rio:</label>
							<form:input path="model.nome" name="nome" id="nome" class="form-control" type="text"
								placeholder="Digite o seu nome aqui" />
						</div>

						<div class="mb-3">
							<label>Email de acesso:</label>
							<form:input path="model.email" name="email" id="email" action="" class="form-control" type="text" placeholder="Digite o seu email aqui" />
							<span class="text-danger">${erro_email}</span>
						</div>

						<div class="mb-3">
							<label>Senha de acesso:</label>
							<form:input path="model.senha" name="senha" id="senha" action="" class="form-control"
								type="password" placeholder="Digite sua senha aqui" />
						</div>

						<div class="mb-3">
							<label>Confirme sua senha:</label>
							<form:input path="model.senhaConfirmacao"  name="senhaConfirmacao" id="senhaConfirmacao" action="" class="form-control" type="password" placeholder="Confirme sua senha aqui" />
						</div>

						<div class="mb-3">
							<div class="d-grid">
								<input type="submit" value="Registrar"
									class="btn btn-success">
							</div>
						</div>

						<div class="mb-3">
							<div class="d-grid">
								<a href="/agendaweb/" class="btn btn-light">J� possui conta?
									<strong>Acesse aqui!</strong>
								</a>
							</div>
						</div>

						<div>
							<strong></strong>
						</div>

					</form>

				</div>
			</div>
		</div>
	</div>

	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>

	<script>
	//Quando a p�gina carregar fa�a
		$(document).ready(function(){	
			
			$("#formCadastro").validate({
				
				rules: {
					'nome': {
						required: true,
						minlength: 8
					},
					
					'email': {
						required: true,
						email: true
					},
					
					'senha': {
						required: true,
						minlength: 8,
						maxlength: 20
					},
					
					'senhaConfirmacao': {
						required: true,
						equalTo: '#senha'	
					},
				},
				
				messages: {
					nome: {
						required: 'Por favor informe o nome do usu�rio.',
						minlength: 'Entre com no m�nimo 8 caracteres.'
					},
					
					email: {
						required: 'Por favor, informe o email do usu�rio.',
						email: 'Entre com um endere�o de email v�lido.'
					},
					
					senha: {
						required: 'Por favor informe a senha do usu�rio.',
						minlength: 'Entre com no m�nimo 8 caracteres.',
						maxlength: 'Entre em no m�ximo 20 caracteres'
					},
						
					senhaConfirmacao: {
						required: 'Por favor, Confirme a senha do usuario',
						equalTo: 'Senhas n�o conferem, por favor verifique' 
					}
						
				}
			})
			
		})
	</script>

</body>
</html>

