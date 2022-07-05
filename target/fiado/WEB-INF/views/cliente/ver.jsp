<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Cliente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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

