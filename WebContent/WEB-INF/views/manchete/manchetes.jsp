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
	<c:forEach var="noticia" items="${noticias}">
		<div class="jumbotron">			
  			<center><h1>${noticia.titulo}</h1></center>
  			<center><h2>${noticia.subtitulo}</h2></center>
  			<center><p><a class="btn btn-primary btn-lg" href="visualizarNoticia?id=${noticia.id}" role="button">MAIS</a></p></center>
		</div>	
	</c:forEach>	
</body>
</html>