<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
		
	<ul class="list-group w-50 mx-auto mt-5">
		<c:forEach items="${produtos}" var="produtos">
			<li class="list-group-item d-flex justify-content-between align-items-center">
				<div class="d-flex gap-3">
					<span class="badge bg-success rounded-pill"><c:out value="${produtos.id}"/></span>
					<c:out value=" ${produtos.nome}"/>
				</div>

				<span class="badge bg-primary rounded-pill">R$ <c:out value="${produtos.valor}"/></span>
				
				<div class="d-flex gap-3">
					<a type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#editaProduto${produtos.id}">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
							<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
							<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>
						</svg>
					</a>
					<a type="button" class="btn btn-outline-danger" href="/fiado/produtos/altera?id=${produtos.id}">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-circle-fill" viewBox="0 0 16 16">
							<path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h7a.5.5 0 0 0 0-1h-7z"/>
						</svg>
					</a>
				</div>
			</li>

			<!-- Modal editar produto -->
			<div class="modal fade" id="editaProduto${produtos.id}" tabindex="-1" aria-labelledby="modal de novo produto" aria-hidden="true">
				<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
					<h5 class="modal-title">Editar Produto</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>

					<div class="modal-body">
						<form action="/fiado/produtos/altera" method="post">
							<div class="mb-3">
								<label for="nome" class="form-label">Nome</label>
								<input type="text" class="form-control" id="nome" name="nome" value="${produtos.nome}">
							</div>
							<div class="mb-3">
								<label for="valor" class="form-label">valor</label>
								<input type="number" step="0.01" class="form-control" id="valor" name="valor" min="1" value="${produtos.valor}">
							</div>
							
							<input type="number" class="form-control" id="id" name="id" value="${produtos.id}" hidden>
							<button type="submit" class="btn btn-success">Submit</button>
						</form>
					</div>

					<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					</div>
				</div>
				</div>
			</div>
		</c:forEach>
	</ul>
  
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