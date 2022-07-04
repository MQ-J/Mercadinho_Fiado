<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Cliente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<title>Lista de Clientes</title>
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
						<a class="nav-link" href="/fiado/produtos">Produtos</a>
						</li>
						<li class="nav-item">
						<a class="nav-link  active" aria-current="page" href="/fiado/clientes">Clientes</a>
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

		<ul class="list-group w-50 mx-auto mt-5">
			<c:forEach items="${clientes}" var="clientes">
				<li class="list-group-item d-flex justify-content-between align-items-center">
					<c:out value=" ${clientes.nome}"/>
					<span class="badge bg-success rounded-pill"><c:out value="${clientes.telefone}"/></span>
					<c:choose>
						<c:when test="${null eq clientes.compras}">
							<span class="badge bg-primary rounded-pill">Cliente ainda não fez compras</span>
						</c:when>
						<c:otherwise>
							<span class="badge bg-primary rounded-pill"><c:out value="${clientes.compras}"/></span>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
		</ul>

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
</html>