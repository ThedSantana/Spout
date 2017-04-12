<%-- 
    Document   : dashboard
    Created on : Oct 30, 2015, 9:50:25 PM
    Author     : debian
--%>

<%@page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
  <head>    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <link rel="icon" href="assets/img/favicon.ico">
    <title>Spout Dashboard</title>   
    <link rel="icon" href="assets/img/favicon/favicon.ico" type="image/ico" sizes="32x32">   
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">    
    <link href="assets/css/spout-theme-dashboard.css" rel="stylesheet">	
    <script type="text/javascript" src="assets/jquery/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>   
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Spout</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">	
		
          <ul class="nav navbar-nav navbar-right">            
            <li><a href="AdministratorAuthenticate">Sair</a></li>
          </ul>
            
          <form action="admin?action=buscarPorTitulo" class="navbar-form navbar-right" method="POST">
            <input type="search" name="titulo" placeholder="Pesquisar..." class="form-control">
            <button type="submit" class="form-control">Ir</button>
          </form>
            
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
          
        <div class="col-sm-3 col-md-2 sidebar">
            
          <ul class="nav nav-sidebar">
            <li class="active"><a href="admin?action=listar">Geral<span class="sr-only">(current)</span></a></li>
            <li><a href="admin?action=create">Cadastrar</a></li>            
          </ul>
            <ul class="nav nav-sidebar">
            <li><a href="admin?action=buscarPorGenero&genero=Ação">Ação</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Drama">Drama</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Suspense">Suspense</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Comédia">Comédia</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Terror">Terror</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Aventura">Aventura</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Sci-fi">Sci-fi</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Romance">Romance</a></li>
            <li><a href="admin?action=buscarPorGenero&genero=Animação">Animação</a></li>
          </ul>
		  
        </div>
      </div>
    </div> 
      
    <div class="container">
        
        <c:if test="${page !=  NULL}">            
            <c:import url = "../${page}"/>
        </c:if>

    </div> <!-- /container -->
    
  </body>
</html>
