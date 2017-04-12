<%-- 
    Document   : list
    Created on : 01/11/2015, 02:14:22
    Author     : Windows
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">        

    <h2 class="sub-header">Filmes</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Titulo</th>
                    <th>Genero</th>
                    <th>Classificação</th>
                    <th>Actions</th>
                </tr>
            </thead>
            
            <tbody> 
                
                <c:forEach items="${filme}" var="filme">
                    <tr>
                           <td><c:out value="${filme.getId()}" /></td>
                           <td><c:out value="${filme.getTitulo()}" /></td>
                           <td><c:out value="${filme.getGenero()}" /></td>
                           <td><c:out value="${filme.getClassificação()}" /></td>
                           <td>
                               <a href="admin?action=editar&id=<c:out value="${filme.getId()}" />"><button type="button" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-pencil"></span></button></a>
                               <a href="javascript:confirmaExclusao(<c:out value="${filme.getId()}"/>)"><button type="button" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span></button></a>
                           </td>
                    </tr>
                </c:forEach>                        

            </tbody>
            
        </table>
    </div>
</div>

<script type="text/javascript">
    function confirmaExclusao(id){
        if (window.confirm('Tem certeza que deseja excluir?')){
            location.href="admin?action=excluir&id="+id;
        }
    }
</script>

