<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	
	<c:import url="/adicionarTopo" />
	
	<form action="adicionarNoticia" enctype="multipart/form-data" method="post">
		<div class="form-group">
	    	<label for="exampleInputName2">Título</label>
	    	<input type="text" class="form-control"  placeholder="Título" name="titulo">
  		</div>
  		<div class="form-group">
	    	<label for="exampleInputName2">Subtítulo</label>
	    	<input type="text" class="form-control"  placeholder="Subtítulo" name="subtitulo">
  		</div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Texto</label>
	    <textarea class="form-control" rows="3" name="texto"></textarea>
	  </div>	  
	  <div class="form-group">
	    <label for="exampleInputFile">Imagem</label>
	    <input type="file" name="file"><br>	    
	  </div>	  
	  <div class="form-group">
		  <select name="id_secao"><br>
			<c:forEach var="secao" items="${secoes}">
				<option value="${secao.id}">${secao.titulo}</option>
			</c:forEach>	
		  </select>
	  </div>	  	  
	  <button type="submit" class="btn btn-default">Cadastrar</button>	  
	</form>
	
	
	
</body>
</html>