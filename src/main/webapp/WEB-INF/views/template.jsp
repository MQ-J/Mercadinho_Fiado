<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String tituloPagina = "index"; 
    String pathview = "/";
    if(request.getAttribute("tituloPagina") != null) {
        tituloPagina = (String) request.getAttribute("tituloPagina");
    }
    if(request.getAttribute("pathview") != null) {
        pathview = (String) request.getAttribute("pathview");
    }
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<title><%= tituloPagina %></title>
	</head>
	<body>

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/fiado">Fiado</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item">
						<a class="nav-link" href="/fiado">Home</a>
						</li>
						<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="/fiado/produtos">Produtos</a>
						</li>
						<li class="nav-item">
						<a class="nav-link" href="/fiado/clientes">Clientes</a>
						</li>
						<li class="nav-item">
						<a class="nav-link" href="/fiado/compras">Compras</a>
						</li>
						<li class="nav-item">
						<a class="nav-link" href="/fiado/pagamentos">Pagamentos</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		
        <h1><%= tituloPagina %></h1>
        <jsp:include page="${pathview}"></jsp:include>

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
</html>