<%-- 
    Document   : grid-filmes
    Created on : 03/11/2015, 20:14:05
    Author     : Windows
--%>

<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="br.com.spout.model.Usuario"%>

<%
    Usuario usu = (Usuario) session.getAttribute("usuAutenticado");
%>

<!DOCTYPE html>
<html>

    <head>	
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/spout-theme-grid-filmes.css"> 	
        <link rel="icon" href="assets/img/favicon/favicon.ico" type="image/ico" sizes="32x32">
        <link rel="stylesheet" type="text/css" href="assets/css/spout-theme-home.css">        
        <script type="text/javascript" src="assets/jquery/jquery-1.11.3.min.js"></script>       
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>  
        <script src="assets/jquery/jquery.tools.min.js"></script> 
        <script src="assets/js/scripts.js"></script>
    </head>

    <body>

        <div class="barra-menu"></div>
        <section>
            <div class="logo"><a href="UsuarioController?action=home&id=<%=usu.getId()%>"><img src="assets/img/logo-menor-6.png" class="img-responsive"></a></div>

            <div class="dropdown menu">
                <button class="btn-transparent" type="button" data-toggle="dropdown">Assitir
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Ação">Ação</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Drama">Drama</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Suspense">Suspense</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Comédia">Comédia</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Terror">Terror</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Aventura">Aventura</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Sci-fi">Sci-fi</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Romance">Romance</a></li>
                    <li><a href="UsuarioController?action=buscarPorGenero&genero=Animação">Animação</a></li>
                </ul>
            </div>            

            <form action="UsuarioController?action=buscarPorTitulo" class="navbar-form navbar-left search" role="search" method="POST">
                <div class="form-group">
                    <input type="search" name="titulo" class="form-control" placeholder="pesquisar...">
                </div>
                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </button>
            </form>

           <div class="dropdown menu-usuario">
                <span class="usuario glyphicon glyphicon-user" aria-hidden="true"></span>
                <button class="btn-transparent-usuario" type="button" data-toggle="dropdown"><%=usu.getNome()%>
                    <span class="caret"></span></button>
                                         
                <ul class="dropdown-menu">
                    <li><a href="UsuarioController?action=editar&id=<%=usu.getId()%>">Perfil</a></li>
                    <li><a href="AuthenticateController">Sair</a></li>
                </ul>
            </div>


        </section>  
        
        <c:forEach items="${filme}" var="filme">
            
            <div class="grid-filmes">                
                
                <a href="<c:out value="${filme.getPath()}" />"><div class="info-filme filme" >
                    <img class="thumbnail-filme" src=<c:out value="${filme.getThumbnail()}" />>
                    <div class="descricao-filme">

                        <div class="info">
                            <img class="btn-play" src="assets/img/botoes/play-hover.png"/>
                        </div>

                        <div class="info">
                            <span><c:out value="${filme.getTitulo()}" /></span>
                            <span class="genero"><c:out value="${filme.getGenero()}" /></span>
                        </div>

                        <div class="resumo">
                            <p><c:out value="${filme.getSinopse()}" /></p>
                        </div>
                    </div>
                    </div></a>	

            </div>
            
        </c:forEach>         

        <footer>
            <p>O uso do serviço Spout constitui a aceitação dos nossos Termos de uso e da Privacidade/Cookies.</p>
            <p><a href="https://www.facebook.com/renan.montenegro.9" target="_blank">Renan</a>
                <a href="https://www.facebook.com/rodrigo.marquesferreira.35?fref=ts" target="_blank">| Rodrigo |</a>
                <a href="https://www.facebook.com/tarcisio.n.gomes?fref=ts" target="_blank">Tarcisio</a></p>
            <p>Programação Web I | Vitor Mesaque | UFMS - CPTL - Sistemas de Informação</p>
        </footer>  

    </body>
</html>