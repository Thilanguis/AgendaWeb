<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de tarefas</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
	label.error {color: red}
	input.error, select.error, textarea.error {border: 1px solid red}
</style>

</head>
<body>
${msangem }

	<!-- Menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"/>

	<!-- Notificações do sistema -->
	<jsp:include page="/WEB-INF/views/components/notifications.jsp"/>

	<div class="container mt-4">
		<div class="row mb-3">
			<div class="col-md-6">
				<h4>
					<strong>AgendaWeb</strong> Cadastro de tarefas
				</h4>
				Preencha o formulário para cadastrar uma tarefa:
			</div>
		</div>

		<form action="cadastrar-tarefa" method="post" id="formTarefa" >
			<div class="row mb-3">
				<div class="col-md-6">
					<label>Nome da tarefa</label>
					<form:input path="model.nome" id="nome" name="nome" type="text" class="form-control" placeholder="Digite o nome aqui"/>
				</div>
				<div class="col-md-2">
					<label>Data da tarefa</label>
					<form:input path="model.data" id="data" name="data" type="date" class="form-control" placeholder="Digite o nome aqui"/>
				</div>
				<div class="col-md-2">
					<label>Hora da tarefa</label>
					<form:input path="model.hora" id="hora" name="hora" type="time" class="form-control" placeholder="Digite o nome aqui"/>
				</div>
				<div class="col-md-2">
					<label>Prioridade</label>
					<form:select path="model.prioridade" id="prioridade" name="prioridade" class="form-select">
						<option value="">Selecione</option>
						<!-- opções do campo -->
						<form:options items="${ prioridades }"/>
					</form:select>
				</div>
			</div>
			
			<div class="mb-3">
				<label>Descrição da tarefa</label>
				<form:textarea path="model.descricao" id="descricao" name="descricao" class="form-control" rows="4" cols="" placeholder="Digite a descrição aqui."></form:textarea>
			</div>
			<div class="mb-3">
				
				<input type="submit" value=" Realizar cadastro" class="btn btn-success"/>
				
				<a href="/agendaweb/tarefas-consulta" class="btn btn-secondary">Voltar para a consulta</a>
				
			</div>
			
		</form>
		
		<strong>${ mensagem }</strong>

	</div>
	
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	
	<script>
	//Quando a página carregar faça
		$(document).ready(function(){	
			
			$("#formTarefa").validate({
				
				rules: {
					'nome': {
						required: true,
					},
					'data': {
						required: true,
					},
					'hora': {
						required: true,
					},
					'prioridade': {
						required: true,
					},
					'descricao': {
						required: true,
					},
				},
				
				messages: {
					nome: {
						required: 'Por favor, informe o nome.',
					},
					data: {
						required: 'Por favor, informe a data.'
					},
					hora: {
						required: 'Por favor, informe a hora.'
					},
					prioridade: {
						required: 'Por favor, informe a prioridade.'
					},
					descricao: {
						required: 'Por favor, informe a descricao.'
					},
						
				}
			})
			
		})
	</script>

</body>
</html>