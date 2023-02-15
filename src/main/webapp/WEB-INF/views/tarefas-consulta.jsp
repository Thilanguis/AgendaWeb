<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de tarefas</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>

	<!-- Menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"/>

	<div class="container mt-4">
		<div class="row mb-3">
			<div class="col-md-6">
				<h5>
					<strong>AgendaWeb </strong>Consulta de tarefas
				</h5>
				Pesquise as tarefas desejadas:
			</div>
			<div class="col-md-6 text-end">
				<div>
					<strong>${mensagem}</strong>
				</div>
			</div>
		</div>

		<form action="">
			<div class="row">
				<div class="col-md-3">
					<input type="date" class="form-control">
				</div>
				<div class="col-md-3">
					<input type="date" class="form-control">
				</div>
				<div class="col-md-6">
					<input type="submit" class="btn btn-primary"
						value="Pesquisar Tarefas">
				
					<a href="/agendaweb/tarefas-cadastro" class="btn btn-success"
						value="Pesquisar Tarefas">Cadastrar tarefas</a>
				</div>
			</div>
		</form>

		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>Nome da tarefa</th>
					<th>Data</th>
					<th>Hora</th>
					<th>Prioridade</th>
					<th>Descrição</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<a href="/agendaweb/tarefas-edicao"	class="btn btn-primary btn-sm">Editar</a> 
						<a href="#"	class="btn btn-danger btn-sm">Excluir</a>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<td colspan="6">Quantidade de tarefas: 0</td>
			</tfoot>
		</table>

	</div>
	
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>