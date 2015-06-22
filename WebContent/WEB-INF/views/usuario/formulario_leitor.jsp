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
	<form action="adicionarUsuario" method="post">
		Nome Completo: <input type="text" name="nome" /><br />
		<input type="hidden" name="id_role" value="1" /><br /> 
		email: <input type="text" name="email" /><br />
		Login: <input type="text" name="login" /><br />
		Senha: <input type="text" name="senha" /><br />
		<input type="submit" value="Inserir" />
	</form>
</body>
</html>