<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição de tarefas</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<!-- Menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"/>

	<div class="container mt-4">
		<div class="row mb-3">
			<div class="col-md-6">
				<h4>
					<strong>AgendaWeb</strong> Cadastro de tarefas
				</h4>
				Preencha o formulário para editar uma tarefa:
			</div>
		</div>

		<form action="" >
			<div class="row mb-3">
				<div class="col-md-6">
					<label>Nome da tarefa</label>
					<input type="text" class="form-control" placeholder="Digite o nome aqui"/>
				</div>
				<div class="col-md-2">
					<label>Data da tarefa</label>
					<input type="date" class="form-control" placeholder="Digite o nome aqui"/>
				</div>
				<div class="col-md-2">
					<label>Hora da tarefa</label>
					<input type="time" class="form-control" placeholder="Digite o nome aqui"/>
				</div>
				<div class="col-md-2">
					<label>Prioridade</label>
					<select class="form-select">
						<option>Selecione</option>
					</select>
				</div>
			</div>
			
			<div class="mb-3">
				<label>Descrição da tarefa</label>
				<textarea class="form-control" rows="4" cols="" placeholder="Digite a descrição aqui."></textarea>
			</div>
			<div class="mb-3">
				
				<input type="submit" value=" Salvar Alterações" class="btn btn-primary"/>
				
				<a href="/agendaweb/tarefas-consulta" class="btn btn-secondary">Voltar para a consulta</a>
				
			</div>
			
		</form>

	</div>
	
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>