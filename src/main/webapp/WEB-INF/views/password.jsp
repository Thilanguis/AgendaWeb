<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

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
						<h5 class="mt-2">Esqueci minha senha</h5>
						<p>Informe o seu e-mail para cadastrar uma senha!</p>
						<hr>
					</div>

					<form action="recuperar-senha" method="post" id="recuperarSenha">

						<div class="mb-3">
							<label>Email de acesso:</label>
							<form:input path="model.email" name="email" id="email" action="" class="form-control" type="text" placeholder="Digite o seu email aqui" />
						</div>

						<div class="mb-3">
							<div class="d-grid">
								<input type="submit" value="Recuperar senha" class="btn btn-success" />
							</div>
						</div>

						<div class="mb-3">
							<div class="d-grid">
								<a href="/agendaweb/" class="btn btn-light"> <strong>Voltar</strong></a>
							</div>
						</div>

						<div class="text-center">
							<strong>${ mensagem }</strong> 
						</div>

					</form>

				</div>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	
	<script>
	//Quando a página carregar faça
		$(document).ready(function(){	
			
			$("#recuperarSenha").validate({
				
				rules: {
					'email': {
						required: true,
						email: true
					},
					
					
				},
				
				messages: {
					email: {
						required: 'Por favor informe o e-mail.',
						email: 'POr favor, entre com um e-mail válido.'
					}
						
				}
			})
			
		})
	</script>

</body>
</html>