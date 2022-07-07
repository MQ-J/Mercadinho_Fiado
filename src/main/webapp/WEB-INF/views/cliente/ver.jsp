<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Cliente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<!-- lista de clientes -->
	<ul class="list-group w-50 mx-auto mt-5">
		<c:forEach items="${clientes}" var="clientes">
			<li class="list-group-item d-flex justify-content-between align-items-center">
				<c:out value=" ${clientes.nome}"/>
				<span class="badge bg-success rounded-pill"><c:out value="${clientes.telefone}"/></span>
				<!-- LIBERAR QUANDO TIVER COMPRA COM ID DE CLIENTE -->
				<!-- <c:choose>
					<c:when test="${null eq clientes.compras}">
						<span class="badge bg-primary rounded-pill">Cliente ainda não fez compras</span>
					</c:when>
					<c:otherwise>
						<span class="badge bg-primary rounded-pill"><c:out value="${clientes.compras}"/></span>
					</c:otherwise>
				</c:choose> -->
			</li>
		</c:forEach>
	</ul>

	<!-- botão que ativa modal novo cliente -->
	<div>
		<button 
			type="button" 
			class="btn btn-success rounded-circle" 
			data-bs-toggle="modal" 
			data-bs-target="#newClient">
			+
		</button>
	</div>
  
	<!-- Modal novo cliente -->
	<div class="modal fade" id="newClient" tabindex="-1" aria-labelledby="modal de novo usuário" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
			<h5 class="modal-title">Novo Cliente</h5>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>

			<div class="modal-body">
				<form action="/fiado/clientes" method="post">
					<div class="mb-3">
						<label for="nome" class="form-label">Nome</label>
						<input type="text" class="form-control" id="nome" name="nome">
					</div>
					<div class="mb-3">
						<label for="cpf" class="form-label">CPF</label>
						<input type="text" class="form-control" id="cpf" name="cpf" pattern="[0-9]{11}">
					</div>
					<div class="mb-3">
						<label for="phone" class="form-label">Telefone</label>
						<input type="tel" class="form-control" id="phone" name="phone" pattern="[0-9]{11}">
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
				</form>
			</div>

			<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			</div>
		</div>
		</div>
	</div>

