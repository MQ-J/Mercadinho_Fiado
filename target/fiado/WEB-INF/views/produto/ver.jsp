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

	<!-- botão que ativa modal novo produto -->
	<div class="position-relative w-50 mx-auto mt-5">
		<button 
			type="button" 
			class="btn btn-success rounded-circle  position-absolute bottom-0 end-0" 
			data-bs-toggle="modal" 
			data-bs-target="#newProduto">
			+
		</button>
	</div>
  
	<!-- Modal novo produto -->
	<div class="modal fade" id="newProduto" tabindex="-1" aria-labelledby="modal de novo produto" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
			<h5 class="modal-title">Novo produto</h5>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>

			<div class="modal-body">
				<form action="/fiado/produtos" method="post">
					<div class="mb-3">
						<label for="id" class="form-label">ID</label>
						<input type="number" class="form-control" id="id" name="id" min="1">
					</div>
					<div class="mb-3">
						<label for="nome" class="form-label">Nome</label>
						<input type="text" class="form-control" id="nome" name="nome">
					</div>
					<div class="mb-3">
						<label for="valor" class="form-label">valor</label>
						<input type="number" step="0.01" class="form-control" id="valor" name="valor" min="1">
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