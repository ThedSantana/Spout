<%-- 
    Document   : login
    Created on : Oct 30, 2015, 9:52:14 PM
    Author     : debian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <link rel="stylesheet" type="text/css" href="../../assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../../assets/css/spout-theme-signin.css">
        <link rel="icon" href="../../assets/img/favicon/favicon.ico" type="image/ico" sizes="32x32">                   
    </head>
	
    <body class="container-fluid">
		
        <div class="container">

        <img src="../../assets/img/logo-admin.png">

        <c:import url = "/helper/message.jsp"/>

        <form class="form-signin" action="../../AdministratorAuthenticate" method="POST">            
            <h2 class="form-signin-heading">Spout Admin</h2>
            <input type="name" name="username" class="form-control" placeholder="User name" required autofocus>
            <input type="password" name="password" class="form-control" placeholder="Password" required>                
            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>            
        </form>

        </div> 

    </body>
</html> 