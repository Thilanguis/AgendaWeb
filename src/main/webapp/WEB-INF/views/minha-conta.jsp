<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha Conta</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
	label.error {color: red}
	input.error, select.error, textarea.error {border: 1px solid red}
</style>

</head>
<body>

	<!-- Menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"/>

	<!-- Notificações do sistema -->
	<jsp:include page="/WEB-INF/views/components/notifications.jsp"/>

	<div class="container mt-4">
		<div class="row mb-3">
			<div class="col-md-6">
				<h4>
					<strong>AgendaWeb</strong> Minha Conta
				</h4>
				Informações do usuário autenticado na agenda:
			</div>
		</div>
		
		<div class="row mt-3">
			<div class="col-md-12">
			 	Nome do Usuário: <strong>${ usuario_auth.nome }</strong>
			</div>
			<div class="col-md-12">
			 	Email de Acesso: <strong>${ usuario_auth.email }</strong>
			</div>
		</div>
		
		<hr>
		
		<div class="mt-3 mb-3">
			<h5>Altere sua senha de acesso:</h5>
		</div>

		<form action="atualizar-senha" method="post" id="formEdicao" >
			<div class="row mb-3">
				<div class="col-md-3">
					<label>Nova senha:</label>
					<form:input path="model.senha" id="senha" name="senha" type="password" class="form-control" placeholder="Digite aqui"/>
					
				</div>
				<div class="col-md-3">
					<label>Confirme a nova senha:</label>
					<form:input path="model.novaSenha" id="novaSenha" name="novaSenha" type="password" class="form-control" placeholder="Digite o nome aqui"/> 
				</div>
			</div>
			
			<div class="row mb-3">
				<div class="col-md-3">
					<input type="submit" class="btn btn-success" value="Atualizar Senha" />
				</div>
			</div>
		</form>

	</div>
	
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	
	<script>
	//Quando a página carregar faça
		$(document).ready(function(){	
			
			$("#formEdicao").validate({
				
				rules: {
					'senha': {
						required: true,
						minlength: 8,
						maxlength: 20
					},
					'novaSenha': {
						required: true,
						equalTo: '#senha'	
					}
				},
				
				messages: {
					senha: {
						required: 'Por favor, informe a senha.',
						minlength: 'Entre com no mínimo 8 caracteres.',
						maxlength: 'Entre em no máximo 20 caracteres'
					},
					novaSenha: {
						required: 'Por favor, informe a nova senha.',
						equalTo: 'Senhas não conferem, por favor verifique' 
					}
						
				}
			})
			
		})
		
	</script>

</body>
</html>