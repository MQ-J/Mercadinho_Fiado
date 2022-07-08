<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Pagamento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<!-- botão que ativa modal nova pagamento -->
	<div class="position-relative w-50 mx-auto mt-5 mb-3">
		<button 
			type="button" 
			class="btn btn-success rounded-circle  position-absolute bottom-0 end-0" 
			data-bs-toggle="modal" 
			data-bs-target="#newPagamento">
			+
		</button>
	</div>

	<ul class="list-group w-50 mx-auto mt-5">
		<c:forEach items="${pagamentos}" var="pagamentos">
			<li class="list-group-item d-flex justify-content-between align-items-center">
				<c:out value=" ${pagamentos.valorPago}"/><br>
				<c:out value=" ${pagamentos.dataPagto}"/>
			</li>
		</c:forEach>
	</ul>

	<!-- Modal nova pagamento -->
	<div class="modal fade" id="newPagamento" tabindex="-1" aria-labelledby="modal de novo pagamento" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
			<h5 class="modal-title">Nova pagamento</h5>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>

			<div class="modal-body">
				<form action="/fiado/pagamentos" method="post">
					<div class="mb-3">
						<label for="valor" class="form-label">valor pago</label>
						<input type="number" step="0.01" class="form-control" id="valor" name="valor" min="0.01">
					</div>
					<div class="mb-3">
						<label for="idcompra" class="form-label">ID da compra referente</label>
						<input type="number" class="form-control" id="idcompra" name="idcompra" min="1">
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
