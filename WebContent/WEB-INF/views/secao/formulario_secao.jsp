<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<c:import url="/adicionarTopo" />
	
	<form action="adicionarSecao" method="post">
		<div class="form-group">
	    	<label for="exampleInputName2">Título:</label>
	    	<input type="text" class="form-control"  placeholder="Título" name="titulo">
  		</div>	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Descrição:</label>
	    <textarea class="form-control" rows="3" name="descricao"></textarea>
	  </div>	  	  
	  <button type="submit" class="btn btn-default">Cadastrar</button>	  
	</form>	
	
</body>
</html>