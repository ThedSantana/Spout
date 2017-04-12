<%-- 
    Document   : create
    Created on : 01/11/2015, 02:14:22
    Author     : Windows
--%>   

<div class="conteudo">
    <h3>Cadastro de Filmes</h3>
    <form role="form" action="admin?action=create" method="POST">

        <div class="form-group">					
            <label>Título filme</label>
            <input type="text" name="titulo"  class="form-control" placeholder="titulo filme...">
        </div>	

        <div class="form-group">
            <label>Sinopse</label>
            <textarea onkeyup="limitaTextarea(this.value)" id="texto" name="sinopse" class="form-control" rows="3"></textarea>
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
            </select>
        </div>

        <div class="form-group">
            <label>Capa filme</label>					
            <input name="capa" type="text" class="form-control" id="capa-filme" required="none">
            <p class="help-block"></p>
        </div>

        <div class="form-group">
            <label>Path filme</label>					
            <input name="path" class="form-control" type="url" id="path-filme">            
        </div>

        <div class="form-group">
            <label>Thumbnail</label>					
            <input name="thumbnail" class="form-control" type="text" id="thumbnail-filme">  
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
            </select>
        </div> 
        
        <button type="submit" class="btn btn-default">Cadastrar</button> 
        <button type="reset" class="btn btn-default">Limpar</button>
        
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


