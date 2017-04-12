/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;
import br.com.spout.dao.FilmesDAO;
import br.com.spout.model.Usuario;
import br.com.spout.dao.UsuarioDAO;
import br.com.spout.model.Filme;
import java.util.List;

/**
 *
 * @author Windows
 */
public class Testes {
    
    public static void main(String[] args){ 
        //testeCadastrar();
        //testeAlterar();
        //testeExcluir(); 
        //testeSalvar();
        //testeBuscarPorId();
        //testeBuscarTodos();
        //testeAutenticar();
        //testeCadastrarFilme();
        //testeBuscarTodosFilmes();
        //testeExcluirFilme();
        //testeBuscarPorIdFilme();
        //testeAlterarFilme();
        //testeBuscarPorGenero(); 
        //testeBuscarPorTituloFilme();
        //testeAdicionadosRecentemente();
        testeFilmesRecomendados();
    }
    
     public static void testeFilmesRecomendados(){
        
        FilmesDAO filmeDAO = new FilmesDAO();
        List<Filme> lista = filmeDAO.FilmesRecomendados("Ação", "Comédia", "Drama");
        
        for(Filme f: lista){
            System.out.println(f);
        }
        
    }
     
     public static void testeBuscarPorTituloFilme(){
        
        FilmesDAO filmeDAO = new FilmesDAO();
        List<Filme> lista = filmeDAO.buscarPorTitulo("Chappie");
        
        for(Filme f: lista){
            System.out.println(f);
        }
    } 
     
    public static void testeAdicionadosRecentemente(){
        
        FilmesDAO filmeDAO = new FilmesDAO();
        List<Filme> lista = filmeDAO.AdicionadosRecentemente();
        
        for(Filme f: lista){
            System.out.println(f);
        }
        
    }
    
    
    public static void testeBuscarPorGenero(){
        
        FilmesDAO filmeDAO = new FilmesDAO();
        List<Filme> lista = filmeDAO.buscarPorGenero("romance");
        
        for(Filme f: lista){
            System.out.println(f);
        }
        
    }
    
     public static void testeAlterarFilme(){
        //Alterando o Filme
        Filme filme = new Filme();
        filme.setId(45);
        filme.setTitulo("Outro teste");
        filme.setSinopse("Teste");
        filme.setGenero("Ação");
        filme.setCapa("http://localhost:8080/spout/view/admin/login.jsp");
        filme.setFanart("http://localhost:8080/spout/view/admin/login.jsp");
        filme.setClassificação("16");
        filme.setPath("http://localhost:8080/spout/view/admin/login.jsp");
        
        
        //Alterando o filme no banco de dados
        FilmesDAO filmeDAO = new FilmesDAO();
        filmeDAO.alterar(filme);
        
        System.out.println("Alterado com sucesso!");
    }
    
    public static void testeBuscarPorIdFilme(){
        
        FilmesDAO filmeDAO = new FilmesDAO();
        Filme filme = filmeDAO.buscarPorId(4);
        
        System.out.println(filme);
    } 
    
    public static void testeExcluirFilme(){
        //Excluindo o filme
        Filme filme = new Filme();
        filme.setId(20);
        
        //Excluindo o usuário no banco de dados
        FilmesDAO filmeDAO = new FilmesDAO();
        filmeDAO.excluir(filme);
        
        System.out.println("Excluido com sucesso!");
    }  
    
    public static void testeCadastrarFilme(){
        //Criando novo filme
        Filme filme = new Filme();
        filme.setTitulo("Teste");
        filme.setSinopse("Teste");
        filme.setGenero("Ação");
        filme.setCapa("http://localhost:8080/spout/view/admin/login.jsp");
        filme.setFanart("http://localhost:8080/spout/view/admin/login.jsp");
        filme.setClassificação("Livre");
        filme.setPath("http://localhost:8080/spout/view/admin/login.jsp");        
        
        //Cadastrando filme no banco de dados
        FilmesDAO filmeDAO = new FilmesDAO();
        filmeDAO.cadastrar(filme);
        
        System.out.println("Cadastrado com sucesso!");
    } 
    
    public static void testeBuscarTodosFilmes(){
        
        FilmesDAO filmeDAO = new FilmesDAO();
        List<Filme> lista = filmeDAO.buscarTodos();
        
        for(Filme f: lista){
            System.out.println(f);
        }
        
    }
    
    public static void testeAutenticar(){
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        Usuario usu = new Usuario();
        usu.setEmail("jo.gmail.com");
        usu.setSenha("123");
        
        Usuario usuRetorno = usuarioDAO.autenticar(usu);
        
        System.out.println(usuRetorno);        
    }
    
    public static void testeBuscarPorId(){
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usu = usuarioDAO.buscarPorId(1);
        
        System.out.println(usu);
    }    
    
    public static void testeBuscarTodos(){
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> lista = usuarioDAO.buscarTodos();
        
        for(Usuario u: lista){
            System.out.println(u);
        }
        
    }
    
    public static void testeAlterar(){
        //Alterando o Usuário
        Usuario usu = new Usuario();
        usu.setId(1);
        usu.setNome("Joao da Silva");
        usu.setEmail("jo.gmail.com");
        usu.setSenha("123456");
        
        //Alterando o usuário no banco de dados
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.alterar(usu);
        
        System.out.println("Alterado com sucesso!");
    }
    
    public static void testeCadastrar(){
        //Criando o Usuário
        Usuario usu = new Usuario();
        usu.setNome("Joao");
        usu.setEmail("jo.gmail.com");
        usu.setSenha("123");
        
        //Cadastrando usuário no banco de dados
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.cadastrar(usu);
        
        System.out.println("Cadastrado com sucesso!");
    }  
    
    public static void testeExcluir(){
        //Excluindo o Usuário
        Usuario usu = new Usuario();
        usu.setId(1);
        
        //Excluindo o usuário no banco de dados
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.excluir(usu);
        
        System.out.println("Excluido com sucesso!");
    }  
    
    public static void testeSalvar(){
       Usuario usu = new Usuario();
       usu.setId(3);
       usu.setNome("MariaLegalzona");
       
       UsuarioDAO usuDAO = new UsuarioDAO();
       usuDAO.salvar(usu);
       
        System.out.println("Salvo com sucesso!");
    }  
    
}
