<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>	
	<c:import url="/adicionarTopo" />
	<h2>	
	<center>
	Classificado<br>
	<c:forEach var="classificado" items="${classificados}">
		<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
			<tr>
				<td>Titulo</td>
				<td>${classificado.titulo }</td>
			</tr>
			<tr>	
				<td>Descrição</td>
				<td>${classificado.texto }</td>
			</tr>	
			<tr>
				<td>preço</td>
				<td>${classificado.preco }</td>
			</tr>
			<tr>
				<td>telefone</td>
				<td>${classificado.telefone}</td>
			</tr>	
			<tr>
				<td>Melhor oferta</td>
				<td>${classificado.melhorOferta }</td>
			</tr>
			<tr>	
				<td>Data da oferta</td>
				<c:if test="${classificado.dataOferta!=null }">
					<td>${classificado.dataOferta }</td>
				</c:if>
				<c:if test="${classificado.dataOferta==null }">
					<td>-</td>
				</c:if>
				
			</tr>
			<tr>
				<td>Autor da oferta</td>
				<td>${classificado.autor.nome }</td>
			</tr>
						
		<table><br>
		<form action="adicionarOferta?id_classificado=${classificado.id }" method="post">		
			Inserir Oferta:<input type="text" name="oferta"><br>		
			<input type="submit"><br>
		</form>
	</c:forEach>
	</center>
	</h2>			
		
</body>
</html>