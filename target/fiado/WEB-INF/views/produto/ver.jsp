<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Produto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	Produto p = (Produto) request.getAttribute("arroz");
%>
<%
	Produto c = (Produto) request.getAttribute("cocaCola");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<title>Lista de Produtos</title>
	</head>
	<body>
		<ul class="list-group w-50 mx-auto">
			<li class="list-group-item d-flex justify-content-between align-items-center">
				<%= p.getNome() %>
			  <span class="badge bg-success rounded-pill"><%= p.getid() %></span>
			  <span class="badge bg-primary rounded-pill">R$ <%= p.getValor() %></span>
			</li>
			<li class="list-group-item d-flex justify-content-between align-items-center">
				<%= c.getNome() %>
			  <span class="badge bg-success rounded-pill"><%= c.getid() %></span>
			  <span class="badge bg-primary rounded-pill">R$ <%= c.getValor() %></span>
			</li>
		</ul>

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
</html>