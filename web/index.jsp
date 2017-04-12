<%-- 
    Document   : index
    Created on : 22/09/2015, 22:01:05
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Spout</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">       
        <link rel="stylesheet" type="text/css" href="assets/css/spout-theme-index.css">
        <link rel="icon" href="assets/img/favicon/favicon.ico" type="image/ico" sizes="32x32">
        <script type="text/javascript" src="assets/jquery/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>        
    </head>

    <body class="container-fluid row">
        
        <header>
            <div><img src="assets/img/spout-topo-web.jpg" class="img-responsive"></div>
            <div class="transparencia-fundo-topo col-xs-12"></div>
            <div class="logo col-xs-3"><img src="assets/img/logo-menor-7.png" class="img-responsive"></div>
            <div class="descricao-topo col-xs-12">                              
                <p>Filmes e Séries</p>
                <p>em um só lugar.</p>                 
            </div>         
            
        <!-- Botão Entrar -->
        <div class="container">          
          <!-- Trigger the modal with a button -->
          <button type="button" class="btn-entrar btn-style" data-toggle="modal" data-target="#myModal">Entrar</button>

          <!-- Modal -->
          <div class="modal fade" id="myModal" role="dialog">

            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                  
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Fazer login</h4>
                </div>

                <div class="modal-body">
                    
                    <form action="AuthenticateController" method="POST">
                        <div class="form-group">
                            <label for="Email1">Email</label>
                            <input type="email" name="email" class="form-control" id="email">
                        </div>
                        
                        <div class="form-group">
                            <label for="password">Senha</label>
                            <input type="password" name="senha" class="form-control" id="senha">
                        </div>

                        <button type="submit" class="btn-lg">Entrar</button>
                    </form>
                    
                    <div class="cadastro">
                        <p class="">Ainda não conhece o Spout? <a href="UsuarioController?action=create">Inscreva-se agora.</a></p>
                    </div> 
                    
                </div>
              </div>
            </div>
          </div>  
        </div>            
        </header>
        
        <div class="descricao-meio">
            <div class="col-xs-4"><img src="assets/img/icones/icone_descricao_meio.png" class="img-responsive"></div>
            <div class="texto-descricao-meio">
                <p>Assista onde quiser,</p>
                <p>quando quiser.</p>                
            </div>            
        </div>
        
        <footer>
            <p>O uso do serviço Spout constitui a aceitação dos nossos Termos de uso e da Privacidade/Cookies.</p>
            <p><a href="https://www.facebook.com/renan.montenegro.9" target="_blank">Renan</a>
               <a href="https://www.facebook.com/rodrigo.marquesferreira.35?fref=ts" target="_blank">| Rodrigo |</a>
               <a href="https://www.facebook.com/tarcisio.n.gomes?fref=ts" target="_blank">Tarcisio</a></p>
            <p>Programação Web I | Vitor Mesaque | UFMS - CPTL - Sistemas de Informação</p>
        </footer>
        
    </body>

</html>
