<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


		
	<ul class="list-group w-50 mx-auto mt-5">
		<c:forEach items="${produtos}" var="produtos">
			<li class="list-group-item d-flex justify-content-between align-items-center">
				<c:out value=" ${produtos.nome}"/>
				<span class="badge bg-success rounded-pill"><c:out value="${produtos.id}"/></span>
				<span class="badge bg-primary rounded-pill">R$ <c:out value="${produtos.valor}"/></span>
			</li>
		</c:forEach>
	</ul>