<%-- 
    Document   : edit
    Created on : 01/11/2015, 03:27:05
    Author     : Windows
--%>

<%@page import="br.com.spout.model.Filme"%>

<% 
Filme filme = new Filme();

filme = (Filme) request.getAttribute("filme");
    
%>

<div class="conteudo">
    <h3>Editar filme</h3>
    <form role="form" action="admin?action=editar&id=<%= filme.getId() %>" method="POST">

        <div class="form-group">					
            <label>Título filme</label>
            <input type="text" name="titulo" value="<%=filme.getTitulo()%>"  class="form-control" placeholder="titulo filme...">
        </div>	

        <div class="form-group">
            <label>Sinopse</label>
            <textarea onkeyup="limitaTextarea(this.value)" id="texto" name="sinopse" class="form-control" rows="3"><%=filme.getSinopse()%></textarea>
            Campo (caracteres restantes: <span id="contador">169</span>)
        </div>

        <div class="form-group">
            <label>Gênero</label>
            <select class="form-control selecao" name="genero">				  
                <option value="Ação">Ação</option>
                <option value="Drama">Drama</option>
                <option value="Suspense">Suspense</option>
                <option value="Comédia">Comédia</option>
                <option value="Terror">Terror</option>
                <option value="Aventura">Aventura</option>
                <option value="Sci-fi">Sci-fi</option>
                <option value="Romance">Romance</option>
                <option value="Animação">Animação</option>
                <option selected="selected"><%=filme.getGenero()%></option>
            </select>
        </div>

        <div class="form-group">
            <label>Capa filme</label>					
            <input name="capa" class="form-control" value="<%=filme.getCapa()%>" type="text" id="capa-filme">
            <p class="help-block"></p>
        </div>

        <div class="form-group">
            <label>Path filme</label>					
            <input name="path" class="form-control" value="<%=filme.getPath()%>" type="url" id="path-filme">            
        </div>

        <div class="form-group">
            <label>Thumbnail</label>					
            <input name="thumbnail" class="form-control" value="<%=filme.getThumbnail()%>" type="text" id="thumbnail-filme">
            <p class="alert-info">salvar thumbnail em: assets/img/thumbnails/</p>
        </div>


        <div class=" form-group">
            <label>Classificação</label>
            <select class="form-control selecao" name="classificacao">
                <option value="Livre">Livre </option>
                <option value="12">12</option>
                <option value="14">14</option>
                <option value="16">16</option>
                <option value="18">18</option>
                <option selected="selected"><%=filme.getClassificação()%></option>
            </select>
        </div>      

        <button type="submit" class="btn btn-default">Salvar</button>     
        
    </form>
        
</div>

<script>
    function limitaTextarea(valor) {
        quantidade = 169;
        total = valor.length;

        if(total <= quantidade) {
            resto = quantidade- total;
            document.getElementById('contador').innerHTML = resto;
        } else {
            document.getElementById('texto').value = valor.substr(0, quantidade);
        }
    }
</script>
