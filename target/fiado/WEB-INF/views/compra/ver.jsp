<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Compra" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.ZoneId" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<!-- botão que ativa modal nova compra -->
	<div class="position-relative w-50 mx-auto mt-5">
		<button 
			type="button" 
			class="btn btn-success rounded-circle  position-absolute bottom-0 end-0" 
			data-bs-toggle="modal" 
			data-bs-target="#newCompra">
			+
		</button>
	</div>

	<ul class="list-group w-50 mx-auto mt-5">
		<c:forEach items="${compras}" var="compras">
			<li class="list-group-item d-flex flex-column">
				<h5 class="d-flex justify-content-between">
					<p><c:out value=" ${compras.cliente.nome}"/></p>
					<p><c:out value=" ${compras.dataCompra}"/></p>
				</h5>

				<c:choose>
					<c:when test="${compras.valorPendente == 0 && compras.pagamentos!=null}">
						<p class="badge bg-success rounded-pill">OK</p>
					</c:when>
					<c:otherwise>
						<p class="badge bg-primary rounded-pill">Valor pendente: <c:out value=" ${compras.valorPendente}"/></p>
					</c:otherwise>
				</c:choose>
				
				<c:forEach items="${compras.produtos}" var="produtos">
					<p><c:out value=" ${produtos.nome}"/> - R$ <c:out value="${produtos.valor}"/></p>
				</c:forEach>
				
				<c:choose>
					<c:when test="${compras.pagamentos==null}">
						<p class="bg-warning rounded-pill w-25">não há pagamentos</p>
					</c:when>    
					<c:otherwise> 
						<!-- TROCAR PELO PAGAMENTO DEPOIS -->
						<c:forEach items="${compras.pagamentos}" var="pagamentos">
							<p class="bg-success rounded-pill w-25">Valor pago: R$<c:out value=" ${pagamentos.valorPago}"/></p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</li>
		</c:forEach>
	</ul>
  
	<!-- Modal nova compra -->
	<div class="modal fade" id="newCompra" tabindex="-1" aria-labelledby="modal de nova compra" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
			<h5 class="modal-title">Nova Compra</h5>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>

			<div class="modal-body">
				<form action="/fiado/compras" method="post">
					<div class="mb-3">
						<label for="idProd" class="form-label">ID Produto</label>
						<input type="number" class="form-control" id="idProd" name="idProd" min="1">
					</div>
					<div class="mb-3">
						<label for="cpf" class="form-label">CPF</label>
						<input type="text" class="form-control" id="cpf" name="cpf" pattern="[0-9]{11}">
					</div>
					<div class="mb-3">
						<label for="valor" class="form-label">valor pendente</label>
						<input type="number" step="0.01" class="form-control" id="valor" name="valor" min="0">
					</div>
					<div class="mb-3">
						<label for="idCompra" class="form-label">ID Compra</label>
						<input type="number" class="form-control" id="idCompra" name="idCompra" min="1">
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
