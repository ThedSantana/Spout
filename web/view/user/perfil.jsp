<%-- 
    Document   : dashboard
    Created on : Oct 30, 2015, 9:50:25 PM
    Author     : debian
--%>

<%@page import="br.com.spout.model.Usuario"%>
<%@page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<% 
Usuario usu = (Usuario) request.getAttribute("usu");    
%>

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
            <li><a href="UsuarioController?action=home&id=<%=usu.getId()%>">Home</a></li>
          </ul>   
            
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
          
        <div class="col-sm-3 col-md-2 sidebar">
            
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Perfil<span class="sr-only">(current)</span></a></li>
            <li><a href="#">Filmes assistidos</a></li>            
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

