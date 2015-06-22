<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Noticia</title>
</head>
<body>
	 <c:import url="/adicionarTopo" />
	 <center>
	 <div class="alert alert-info" role="alert">
	 	Seção: ${noticia.secao.descricao}<br>
	 	Data: ${noticia.dataNoticia}<br>
	 	Jornalista: ${noticia.autor.nome} 
	 	<c:if test = "${noticia.img != null}">	 	
	 		<center><img src="/images/usuario/${usuario.img }"></center>
	 	</c:if>
	 </div>	 
	 <div class="panel panel-primary">
	 	<center><h2>${noticia.titulo}</h2></center>
	 	<center><h3>${noticia.subtitulo}</h3></center>
	 	<c:if test = "${noticia.img != null}">	 	
	 		<center><img src="/images/noticia/${noticia.img }"></center>
	 	</c:if>
	 	<center><h3>${noticia.texto}</h3></center>
	 </div>
	 <c:forEach var="role" items="${usuarioLogado.roles}">
			<c:if test = "${role.role == 'leitor'}">
				<form action="adicionarComentario" method="post">		
					<input type="hidden" name="id_noticia" value="${noticia.id}"><br>
					Comentário:<textarea class="form-control" rows="3" name="texto"></textarea>			
					<input type="submit"><br>
	 			</form>
			</c:if>
	</c:forEach>
	 
	 <c:forEach var="comentario" items="${noticia.comentarios}">
		<div class="panel panel-default">
  		<div class="panel-heading">${comentario.autor.nome }</div>
  		<div class="panel-body">
    		${comentario.texto }
  		</div>
</div>	
	</c:forEach>

</body>
</html>