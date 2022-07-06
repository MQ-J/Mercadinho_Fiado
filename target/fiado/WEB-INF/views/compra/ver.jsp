<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Compra" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.ZoneId" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<ul class="list-group w-50 mx-auto mt-5">
		<c:forEach items="${compras}" var="compras">
			<li class="list-group-item d-flex flex-column">
				<h5 class="d-flex justify-content-between">
					<p><c:out value=" ${compras.cliente}"/></p>
					<p><c:out value=" ${compras.dataCompra}"/></p>
				</h5>
				<p class="badge bg-primary rounded-pill">Valor pendente: <c:out value=" ${compras.valorPendente}"/></p>
				
				<c:forEach items="${compras.produtos}" var="produtos">
					<p><c:out value=" ${produtos.nome}"/> - R$ <c:out value="${produtos.valor}"/></p>
				</c:forEach>
				
				<c:choose>
					<c:when test="${compras.pagamentos==null}">
						<br><span class="bg-warning rounded-pill w-25">não há pagamentos</span>
					</c:when>    
					<c:otherwise> 
						<!-- TROCAR PELO PAGAMENTO DEPOIS -->
						<br><span class="bg-success rounded-pill w-25">Valor pago: R$<c:out value="${compras.pagamentos}"/></span>
					</c:otherwise>
				</c:choose>
			</li>
		</c:forEach>
	</ul>
