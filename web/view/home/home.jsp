<%-- 
    Document   : home
    Created on : 18/10/2015, 17:46:23
    Author     : Windows
--%>

<%@page import="br.com.spout.model.Usuario"%>

<%
    Usuario usu = (Usuario) session.getAttribute("usuAutenticado");    
%>

<%@page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Spout</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="icon" href="assets/img/favicon/favicon.ico" type="image/ico" sizes="32x32">
        <link rel="stylesheet" type="text/css" href="assets/css/spout-theme-home.css">        
        <script type="text/javascript" src="assets/jquery/jquery-1.11.3.min.js"></script>       
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>  
        <script src="assets/jquery/jquery.tools.min.js"></script> 
        <script src="assets/js/scripts.js"></script>       
    </head>

    <body class="container-fluid">

        <header> 

            <img src="assets/img/fanarts/jurassic2-croped.jpg" class="img-responsive imagem-bordas">

            <div class="transparencia-fundo-sinopse"></div>

            <div class="zoom-img"> 
                <a href="https://drive.google.com/file/d/0Bz3yTCQosQIdcUZFTFk2TzNKRWs/preview"><img class="capa-filme" src="assets/img/capas/jurassic-world.jpg"></a>             
            </div>             

            <div class="sinopse-filme">

                <a href="https://drive.google.com/file/d/0Bz3yTCQosQIdcUZFTFk2TzNKRWs/preview"><p class="titulo-filme">Jurassic World</p></a>

                <p class="sinopse">
                    O Jurassic Park, localizado na ilha Nublar, enfim está aberto ao público. Com isso, as pessoas podem conferir shows acrobáticos com dinossauros e até mesmo fazer passeios bem perto deles, já que agora estão domesticados. Entretanto, a equipe chefiada pela doutora Claire (Bryce Dallas Howard) passa a fazer experiências genéticas com estes seres, de forma a criar novas espécies. Uma delas logo adquire inteligência bem mais alta, logo se tornando uma grande ameaça para a existência humana.
                </p> 

                <span class="favorito glyphicon glyphicon-heart" aria-hidden="true"></span>
                <span class="comentario glyphicon glyphicon-comment" aria-hidden="true"></span> 
                <span class="assitir-mais-tarde glyphicon glyphicon-dashboard" aria-hidden="true"></span>            
            </div>

        </header>

        <div class="barra-menu"></div>
        <section>
            <div class="logo"><img src="assets/img/logo-menor-6.png" class="img-responsive"></div>

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
                    

        <div class="adicionados-recentemente">            
            <h2>Adicionados Recentemente</h2>             

            <!-- "página anterior" action -->
            <a class="prev browse left"></a> 

            <div class="scrollable" id="scrollable"> 

                <div class="items zoom-img-filmes">

                    <!-- 1-7 -->
                    <div>
                        
                        <%int contador=0;%> <!--Contador para controlar o laço-->
                        
                        <c:forEach items="${filme}" var="filme">                   
                            
                            <%if (contador<8){%>
                                <a href="<c:out value="${filme.getPath()}" />">
                                    <img src="<c:out value="${filme.getCapa()}"/>"/>
                                </a>
                            <%}%>
                            
                            <%contador++;%>
                        </c:forEach>    
                    </div>

                    <!-- 8-14 -->
                    <div>
                        <%contador=0;%> <!--Contador para controlar o laço-->
                        
                        <c:forEach items="${filme}" var="filme">                   
                            
                            <%if (contador>=8 && contador<15){%>
                                <a href="<c:out value="${filme.getPath()}" />">
                                    <img src="<c:out value="${filme.getCapa()}"/>"/>
                                </a>
                            <%}%>
                            
                            <%contador++;%>
                        </c:forEach>   
                    </div>

                    <!-- 15-20 -->
                    <div>
                        <%contador=0;%> <!--Contador para controlar o laço-->
                        
                        <c:forEach items="${filme}" var="filme">                   
                            
                            <%if (contador>=15 && contador<21){%>
                                <a href="<c:out value="${filme.getPath()}" />">
                                    <img src="<c:out value="${filme.getCapa()}"/>"/>
                                </a>
                            <%}%>
                            
                            <%contador++;%>
                        </c:forEach>                   	  
                    </div>

                </div>

            </div>

            <!-- "próxima página" action -->
            <a class="next browse right"></a>

        </div>                                          

        <section class="mais-assitidos">

            <h2>Filmes Recomendados</h2>
            <!-- "página anterior" action -->
            <a class="prev browse left"></a> 

            <div class="scrollable" id="scrollable"> 

                <div class="items zoom-img-filmes">

                    <!-- 1-7 -->
                    <div>

                        <%contador = 0;%> <!--Contador para controlar o laço-->

                        <c:forEach items="${recomendados}" var="recomendados">                   

                            <%if (contador < 8) {%>
                            <a href="<c:out value="${recomendados.getPath()}" />">
                                <img src="<c:out value="${recomendados.getCapa()}"/>"/>
                            </a>
                            <%}%>

                            <%contador++;%>
                        </c:forEach>  
                        
                    </div>

                    <!-- 8-14 -->
                    <div>
                        <%contador = 0;%> <!--Contador para controlar o laço-->

                        <c:forEach items="${recomendados}" var="recomendados">                   

                            <%if (contador >= 8 && contador <15) {%>
                            <a href="<c:out value="${recomendados.getPath()}" />">
                                <img src="<c:out value="${recomendados.getCapa()}"/>"/>
                            </a>
                            <%}%>

                            <%contador++;%>
                        </c:forEach>    
                    </div>

                    <!-- 15-20 -->
                    <div>
                        <%contador = 0;%> <!--Contador para controlar o laço-->

                        <c:forEach items="${recomendados}" var="recomendados">                   

                            <%if (contador>=15 && contador<21 ) {%>
                            <a href="<c:out value="${recomendados.getPath()}" />">
                                <img src="<c:out value="${recomendados.getCapa()}"/>"/>
                            </a>
                            <%}%>

                            <%contador++;%>
                        </c:forEach>                    	  
                    </div>

                </div>

            </div>

            <!-- "próxima página" action -->
            <a class="next browse right"></a>
        </section>      

        <footer>
            <p>O uso do serviço Spout constitui a aceitação dos nossos Termos de uso e da Privacidade/Cookies.</p>
            <p><a href="https://www.facebook.com/renan.montenegro.9" target="_blank">Renan</a>
                <a href="https://www.facebook.com/rodrigo.marquesferreira.35?fref=ts" target="_blank">| Rodrigo |</a>
                <a href="https://www.facebook.com/tarcisio.n.gomes?fref=ts" target="_blank">Tarcisio</a></p>
            <p>Programação Web I | Vitor Mesaque | UFMS - CPTL - Sistemas de Informação</p>
        </footer>    

    </body>

</html>