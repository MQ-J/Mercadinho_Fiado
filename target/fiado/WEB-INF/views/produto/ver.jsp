<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="fiado.src.main.java.modelo.Produto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	Produto p = (Produto) request.getAttribute("produto");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Detalhes de <%= p.getNome() %></title>
	</head>
	<body>
		<h1>Detalhes de <%= p.getNome() %></h1>
		
        
        <p>ID:  <%= p.getid() %></p>
		<p>Nome:  <%= p.getNome() %></p>
		<p>Preco:  <%= p.getValor() %></p>
	</body>
</html>