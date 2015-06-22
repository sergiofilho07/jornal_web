<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jornal</title>
</head>
<body>
	
	<c:import url="/adicionarTopo" />	
	
	<form action="adicionarJornalista" enctype="multipart/form-data" method="post">
		<div class="form-group">
    	<label for="exampleInputName2">Nome Completo</label>
    	<input type="text" class="form-control"  placeholder="nome" name="nome">
  		</div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email</label>
	    <input type="email" class="form-control" placeholder="email@example.com" name="email">
	  </div>
	  <div class="form-group">
    	<label for="exampleInputName2">Login</label>
    	<input type="text" class="form-control" placeholder="login" name="login">
  	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" placeholder="senha" name="senha">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputFile">Imagem</label>
	    <input type="file" name="file"><br>	    
	  </div>	  
	  <button type="submit" class="btn btn-default">Cadastrar</button>
	  <br><input type="hidden" name="id_role" value="3" /><br /><br>
	</form>
	
</body>
</html>