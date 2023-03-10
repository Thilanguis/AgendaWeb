<nav
	class="navbar navbar-expand-lg navbar-dark bg-dark bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="/agendaweb/tarefas-consulta">AgendaWeb</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link" href="/agendaweb/minha-conta" >Minha Conta</a>
				</li>
					<li class="nav-item dropdown">
						<a	class="nav-link dropdown-toggle" href="#" role="button"	data-bs-toggle="dropdown" aria-expanded="false"> Gerenciar Tarefas </a>
					<ul class="dropdown-menu">
						<li>
							<a class="dropdown-item" href="/agendaweb/tarefas-cadastro">Cadastrar Tarefas</a>
						</li>
						<li>
							<a class="dropdown-item" href="/agendaweb/tarefas-consulta">Consultar Tarefas</a>
						</li>
					</ul>
				</li>
			</ul>
			<form class="d-flex" role="search">
				<div class="text-white">
					<small> 
						<strong>${ usuario_auth.nome } </strong> ( ${ usuario_auth.email } )
					</small> &nbsp;&nbsp;&nbsp; 
					<a href="/agendaweb/logout"	class="btn btn-danger btn-sm" onclick=" return confirm('Deseja realmente sair da agenda?');"> Sair da agenda </a>

				</div>
			</form>
		</div>
	</div>
</nav>
