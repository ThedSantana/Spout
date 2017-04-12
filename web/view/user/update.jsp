
<%@page import="br.com.spout.model.Usuario"%>

<% 
Usuario usu = (Usuario) request.getAttribute("usu");    
%>

<style>
    .conteudo{
        padding-left: 30%;
    }
    
    .usuario-dados{
        padding-top: 3%;       
    }
    
    .btn{
        margin-top: 3%;
        margin-right: 1%;
    }
</style>

<div class="conteudo">

<h1>Perfil</h1>

<h3 class="usuario-dados">Nome de usuário: <%= usu.getNome() %></h3>
<h3>E-mail: <%= usu.getEmail() %></h3>

<a href="UsuarioController?action=alterar-senha&id=<%=usu.getId()%>">
    <button type="submit" class="btn btn-success">Alterar Senha</button>
</a>

<a href="javascript:confirmaExclusao(<%=usu.getId()%>)">
    <button type="submit" class="btn btn-danger">Excluir Conta</button>
</a>

</div>

<script type="text/javascript">
    function confirmaExclusao(id){
        if (window.confirm('Tem certeza que deseja excluir sua conta?')){
            location.href="UsuarioController?action=excluir&id="+id;
        }
    }
</script>