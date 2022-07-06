<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="src.main.java.modelo.Pagamento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<ul class="list-group w-50 mx-auto mt-5">
		<c:forEach items="${pagamentos}" var="pagamentos">
			<li class="list-group-item d-flex justify-content-between align-items-center">
				<c:out value=" ${pagamentos.valorPago}"/><br>
				<c:out value=" ${pagamentos.dataPagto}"/>
			</li>
		</c:forEach>
	</ul>
