<%-- 
    Document   : create
    Created on : 20/10/2015, 02:01:56
    Author     : Windows
--%>

<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html;">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/spout-theme-criar-conta.css">
        <link rel="icon" href="assets/img/favicon/favicon.ico" type="image/ico" sizes="32x32"> 
        <title>Cadastro</title>
    </head>
    
    <body>        

        <img class="logo" src="assets/img/logo-menor-8.png">
        
        <h1>Comece já a assitir!</h1>
        <h3>Crie sua conta:</h3>

        
        <form action="UsuarioController?action=create" method="POST"> 

            <div class="form-group">
                <label for="nome">Nome de usuário</label>
                <input type="text" name="nome" id="nome" class="form-control" value="" required autofocus>
            </div>

            <div class="form-group">
                <label for="email:">Email</label>
                <input type="email" name="email" id="email"  class="form-control" value="" required>
            </div>

            <div class="form-group">
                <label for="senha">Senha</label>
                <input type="password" name="senha" required="required" id="senha" value="" class="form-control" required>
            </div>
            
            <div class="form-group">
                <label>Gênero Favorito 1</label>
                <select class="form-control selecao" name="generofavorito1">				  
                    <option value="Ação">Ação</option>
                    <option value="Drama">Drama</option>               
                    <option value="Suspense">Suspense</option>
                    <option value="Comédia">Comédia</option>
                    <option value="Terror">Terror</option>
                    <option value="Aventura">Aventura</option>
                    <option value="Sci-fi">Sci-fi</option>
                    <option value="Romance">Romance</option>
                    <option value="Animação">Animação</option>			  
                </select>
            </div>
            
            <div class="form-group">
                <label>Gênero Favorito 2</label>
                <select class="form-control selecao" name="generofavorito2">				  
                    <option value="Ação">Ação</option>
                    <option value="Drama">Drama</option>               
                    <option value="Suspense">Suspense</option>
                    <option value="Comédia">Comédia</option>
                    <option value="Terror">Terror</option>
                    <option value="Aventura">Aventura</option>
                    <option value="Sci-fi">Sci-fi</option>
                    <option value="Romance">Romance</option>
                    <option value="Animação">Animação</option>			  
                </select>
            </div>
            
            <div class="form-group">
                <label>Gênero Favorito 3</label>
                <select class="form-control selecao" name="generofavorito3">				  
                    <option value="Ação">Ação</option>
                    <option value="Drama">Drama</option>               
                    <option value="Suspense">Suspense</option>
                    <option value="Comédia">Comédia</option>
                    <option value="Terror">Terror</option>
                    <option value="Aventura">Aventura</option>
                    <option value="Sci-fi">Sci-fi</option>
                    <option value="Romance">Romance</option>
                    <option value="Animação">Animação</option>			  
                </select>
            </div>

            <button class="btn-criar-conta" type="submit" class="btn btn-default">Criar conta</button>
        </form>     

    </body>
</html>
