<%@page import="br.com.spout.model.Usuario"%>

<%
    Usuario usu = (Usuario) request.getAttribute("usu");
%>


<style>
    .conteudo{
        padding-left: 30%;
    }    
</style>

<div class="conteudo">

    <h1>Alterar Senha</h1>

    <form role="form" action="UsuarioController?action=alterar-senha&id=<%= usu.getId()%>" method="POST">

        <div class="form-group">					
            <label>Nova senha</label>
            <input type="text" name="nova-senha" value=""  class="form-control">
        </div>
        
        <div class="form-group">					
            <label>Confirmar senha</label>
            <input type="text" name="confirmar-senha" value=""  class="form-control">
        </div>      

        <button type="submit" class="btn btn-default">Alterar</button>     

    </form>

</div>

<script type="text/javascript">
    function confirmaExclusao(id) {
        if (window.confirm('Tem certeza que deseja excluir sua conta?')) {
            location.href = "UsuarioController?action=excluir&id=" + id;
        }
    }
</script>
