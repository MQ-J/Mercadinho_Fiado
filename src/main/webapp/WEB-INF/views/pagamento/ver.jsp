<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Pagamento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Pagamento p = (Pagamento) request.getAttribute("a");
%>
<%
	Pagamento c = (Pagamento) request.getAttribute("b");
%>


	<ul class="list-group w-50 mx-auto mt-5">
		<li class="list-group-item d-flex justify-content-between align-items-center">
			<%= p.getValorPago() %><br>
			Pago no dia: <%= p.getDataPagto() %>
		</li>

		<li class="list-group-item d-flex justify-content-between align-items-center">
			<%= c.getValorPago() %><br>
			Pago no dia: <%= c.getDataPagto() %>
		</li>
	</ul>
