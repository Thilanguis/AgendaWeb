<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!-- biblioteca do Spring -->
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	<!-- biblioteca de tags JSTL -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de tarefas</title>

<!-- Folha de estilos do bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- folha de estilos CSS do jquery do datatables -->
<link href="//cdn.datatables.net/1.13.2/css/jquery.dataTables.min.css" rel="stylesheet">

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
				<h5>
					<strong>AgendaWeb </strong>Consulta de tarefas
				</h5>
				Pesquise as tarefas desejadas:
			</div>
		</div>

		<form id="formConsulta" action="consultar-tarefas" method="get">
			<div class="row">
				<div class="col-md-3">
					<form:input path="model.dataMin" id="dataMin" name="dataMin" type="date" class="form-control"/>
				</div>
				<div class="col-md-3">
					<form:input path="model.dataMax" id="dataMax" name="dataMax" type="date" class="form-control"/>
				</div>
				<div class="col-md-6">
					<input type="submit" class="btn btn-primary"
						value="Pesquisar Tarefas">
				
					<a href="/agendaweb/tarefas-cadastro" class="btn btn-success"
						value="Pesquisar Tarefas">Cadastrar tarefas</a>
				</div>
			</div>
		</form>

		<c:if test="${tarefas.size() > 0 }">

			<table id="tabela-tarefas" class="table table-hover table-striped">
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
				
				<c:forEach items="${ tarefas }" var="t">
				
					<tr>
						<td>${t.nome }</td>
						<td><fmt:formatDate value="${t.data }" pattern="dd/MM/yyyy"/></td>
						<td>${ t.hora}</td>
						<c:if test="${t.prioridade == 1 }">
							<td>
								<span class="badge bg-danger"> Alta</span> 
							</td>
							</c:if>
						<c:if test="${t.prioridade == 2 }">
							<td>
								<span class="badge bg-warning"> Média</span> 
							</td>
						</c:if>
						<c:if test="${t.prioridade == 3 }">
							<td>
								<span class="badge bg-primary"> Baixa</span> 
							</td>
						</c:if>
						<td>${t.descricao }</td>
						<td><a href="/agendaweb/tarefas-edicao"
							class="btn btn-primary btn-sm">Editar</a> <a href="#"
							class="btn btn-danger btn-sm">Excluir</a></td>
					</tr>
					
				</c:forEach>
				
				
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">Quantidade de tarefas: <strong> ${ tarefas.size() } </strong></td>
					</tr>
				</tfoot>
			</table>

		</c:if>

	</div>
	
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script src="//cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
	
	<script>
	//Quando a página carregar faça
		$(document).ready(function(){	
			
			$("#formConsulta").validate({
				
				rules: {
					'dataMin': {
						required: true,
					},
					'dataMax': {
						required: true,
					}
				},
				
				messages: {
					dataMin: {
						required: 'Por favor, informe a data de início do período.',
					},
					dataMax: {
						required: 'Por favor, informe a data de fim do período.'
					}		
				}
			})
			
   			 $('#tabela-tarefas').DataTable({
   				 language: {
   					 url: "//cdn.datatables.net/plug-ins/1.13.2/i18n/pt-BR.json"
   				 }
   			 });
			
		})
	</script>

</body>
</html>