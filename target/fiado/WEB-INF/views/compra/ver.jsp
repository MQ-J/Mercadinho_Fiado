<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Compra" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.ZoneId" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Compra a = (Compra) request.getAttribute("a");
%>
<%
	Compra b = (Compra) request.getAttribute("b");
%>
<%
	Compra c = (Compra) request.getAttribute("c");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<ul class="list-group w-50 mx-auto">
		<li class="list-group-item d-flex flex-column">
			<h5 class="d-flex justify-content-between">
				<p><%= a.getCliente().getNome() %>
				<% 
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				Date dt = Date.from(a.getDataCompra().atZone(ZoneId.systemDefault()).toInstant());
				%>
				<p><%= df.format(dt) %></p>
			</h5>
			<p class="badge bg-primary rounded-pill">Valor pendente: <%= a.getValorPendente() %></p>
			<p><%= a.getProdutos().get(0).getNome() %> - R$ <%= a.getProdutos().get(0).getValor() %></p>
			<p><%= a.getProdutos().get(1).getNome() %> - R$ <%= a.getProdutos().get(1).getValor() %></p>
			<c:choose>
				<c:when test="${a.getPagamentos()==null}">
					<br><span class="bg-warning rounded-pill w-25">não há pagamentos</span>
				</c:when>    
				<c:otherwise>
					<br><span class="bg-success rounded-pill w-25">Valor pago: R$<%= a.getPagamentos().get(0).getValorPago() %></span>
				</c:otherwise>
			</c:choose>
		</li>

		<li class="list-group-item d-flex flex-column">
			<h5 class="d-flex justify-content-between">
				<p><%= b.getCliente().getNome() %>
				<p><%= b.getDataCompra() %></p>
			</h5>
			<p class="badge bg-primary rounded-pill">Valor pendente: <%= b.getValorPendente() %></p>
			<p><%= b.getProdutos().get(0).getNome() %> - R$ <%= b.getProdutos().get(0).getValor() %></p>
			<p><%= b.getProdutos().get(1).getNome() %> - R$ <%= b.getProdutos().get(1).getValor() %></p>
			<p><%= b.getProdutos().get(2).getNome() %> - R$ <%= b.getProdutos().get(2).getValor() %></p>
			<c:choose>
				<c:when test="${b.getPagamentos()==null}">
					<br><span class="bg-warning rounded-pill w-25">não há pagamentos</span>
				</c:when>    
				<c:otherwise>
					<br><span class="bg-success rounded-pill w-25">Valor pago: R$<%= b.getPagamentos().get(0).getValorPago() %></span>
				</c:otherwise>
			</c:choose>
		</li>

		<li class="list-group-item d-flex flex-column">
			<h5 class="d-flex justify-content-between">
				<p><%= c.getCliente().getNome() %>
				<p><%= c.getDataCompra() %></p>
			</h5>
			<p class="badge bg-primary rounded-pill">Valor pendente: <%= c.getValorPendente() %></p>
			<p><%= c.getProdutos().get(0).getNome() %> - R$ <%= c.getProdutos().get(0).getValor() %></p>
			<c:choose>
				<c:when test="${c.getPagamentos()==null}">
					<br><span class="bg-warning rounded-pill w-25">não há pagamentos</span>
				</c:when>    
				<c:otherwise>
					<br><span class="bg-success rounded-pill w-25">Valor pago: R$<%= c.getPagamentos().get(0).getValorPago() %></span>
				</c:otherwise>
			</c:choose>
		</li>
	</ul>
