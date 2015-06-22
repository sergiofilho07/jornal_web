<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
 
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">INDEX</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        
        <c:forEach var="role" items="${usuarioLogado.roles}">
			<c:if test = "${role.role == 'jornalista'}">
				<li><a href = "formularioNoticia">Adicionar Noticia</a></li>	
			</c:if>
			<c:if test = "${role.role == 'editor'}">
				<li><a href = "formularioSecao">Adicionar Seção</a></li>
				<li><a href = "formularioClassificado">Adicionar Classificado</a></li>
				<li><a href = "formularioUsuario?id_role=3">Adicionar Jornalista</a></li>
			</c:if>
		</c:forEach>
        <li><a href = "visualizarClassificados">Classificados</a></li>
        <li><a href = "formularioLogin">Login</a></li>
        
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Seções <span class="caret"></span></a>
          <ul class="dropdown-menu">
          	<c:forEach var="secao" items="${secoes}">
          		<li><a href="listarManchetes?id=${secao.id}">${secao.titulo}</a></li>
          		<li role="separator" class="divider"></li>				
			</c:forEach>            
          </ul>
        </li>
        
        
        
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>