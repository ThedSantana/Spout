/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.dao;

import br.com.spout.model.Filme;
import br.com.spout.model.Usuario;
import br.com.spout.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class FilmesDAO {

    private Connection con = ConnectionFactory.getConnection();

    public void alterar(Filme filme) {

        String sql = "update filmes set titulo=?,sinopse=?,genero=?,capa=?,thumbnail=?,classificacao=?,path=? where id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) { //Autoclose do statment

            stmt.setString(1, filme.getTitulo());  //Substituindo o ? pelo dado do filme
            stmt.setString(2, filme.getSinopse());
            stmt.setString(3, filme.getGenero());
            stmt.setString(4, filme.getCapa());
            stmt.setString(5, filme.getThumbnail());
            stmt.setString(6, filme.getClassificação());
            stmt.setString(7, filme.getPath());
            stmt.setInt(8, filme.getId());
            //Executa o comando SQL no banco
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(Filme filme) {       
        
        //Pegar data
        java.util.Date date = new java.util.Date();  
        java.sql.Date data = new java.sql.Date(date.getTime()); 
        
        String sql = "insert into filmes (titulo,sinopse,genero,capa,thumbnail,classificacao,path,datafilme) values (?,?,?,?,?,?,?,'"+data+"')";    
        
        
        try {
            //Cria um statment
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, filme.getTitulo());  //Substituindo o ? pelo dado do filme
            stmt.setString(2, filme.getSinopse());
            stmt.setString(3, filme.getGenero());
            stmt.setString(4, filme.getCapa());
            stmt.setString(5, filme.getThumbnail());
            stmt.setString(6, filme.getClassificação());
            stmt.setString(7, filme.getPath());         

            //Executa o comando SQL no banco
            stmt.execute();
            //Encerra o objeto stmt
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluir(Filme filme) {

        String sql = "delete from filmes where id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) { //Autoclose do statment

            stmt.setInt(1, filme.getId());  //Substituindo o ? pelo dado do filme           

            //Executa o comando SQL no banco
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvar(Filme filme) {
        if (filme.getId() != null) {
            alterar(filme);
        } else {
            cadastrar(filme);
        }

    }

    /**
     * Busca de registro no banco de dados pelo ID do filme
     *
     * @param id É um inteiro que representa o numero do id do filme a ser
     * buscado
     * @return Um objeto filme quando encontra ou null quando nao encontra
     */
    public Filme buscarPorId(Integer id) {

        String sql = "Select * from filmes where id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery(); //Retorna resultset

            if (resultado.next()) { //Posiciona o cursor no registro
                Filme fm = new Filme();
                fm.setId(resultado.getInt("id"));
                fm.setTitulo(resultado.getString("titulo"));
                fm.setSinopse(resultado.getString("sinopse"));
                fm.setGenero(resultado.getString("genero"));
                fm.setCapa(resultado.getString("capa"));
                fm.setThumbnail(resultado.getString("thumbnail"));
                fm.setClassificação(resultado.getString("classificacao"));
                fm.setPath(resultado.getString("path"));
                return fm;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
    
     public List<Filme> buscarPorTitulo(String titulo) {

        String sql = "Select * from filmes where titulo ilike ?";
        
        
        //select * from filmes where titulo ilike '%star%' 
        
        
        
        List<Filme> lista = new ArrayList<Filme>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%"+titulo+"%");
            ResultSet resultado = stmt.executeQuery(); //Retorna resultset

             while (resultado.next()) { //Posiciona o cursor no registro 
                Filme fm = new Filme();
                fm.setId(resultado.getInt("id"));
                fm.setTitulo(resultado.getString("titulo"));
                fm.setSinopse(resultado.getString("sinopse"));
                fm.setGenero(resultado.getString("genero"));
                fm.setCapa(resultado.getString("capa"));
                fm.setThumbnail(resultado.getString("thumbnail"));
                fm.setClassificação(resultado.getString("classificacao"));
                fm.setPath(resultado.getString("path"));
                
                //Adiciona filme na lista
                lista.add(fm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }
    
    public List<Filme> buscarPorGenero(String genero) {

        String sql = "Select * from filmes where genero=? order by id";

        List<Filme> lista = new ArrayList<Filme>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, genero);

            ResultSet resultado = stmt.executeQuery(); //Retorna resultset

            while (resultado.next()) { //Posiciona o cursor no registro
                Filme fm = new Filme();
                fm.setId(resultado.getInt("id"));
                fm.setTitulo(resultado.getString("titulo"));
                fm.setSinopse(resultado.getString("sinopse"));
                fm.setGenero(resultado.getString("genero"));
                fm.setCapa(resultado.getString("capa"));
                fm.setThumbnail(resultado.getString("thumbnail"));
                fm.setClassificação(resultado.getString("classificacao"));
                fm.setPath(resultado.getString("path"));                

                //Adiciona filme na lista
                lista.add(fm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }
    
     public List<Filme> AdicionadosRecentemente() {

        String sql = "SELECT * FROM filmes ORDER BY datafilme DESC LIMIT 20";

        List<Filme> lista = new ArrayList<Filme>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {          

            ResultSet resultado = stmt.executeQuery(); //Retorna resultset

            while (resultado.next()) { //Posiciona o cursor no registro
                Filme fm = new Filme();
                fm.setId(resultado.getInt("id"));
                fm.setTitulo(resultado.getString("titulo"));
                fm.setSinopse(resultado.getString("sinopse"));
                fm.setGenero(resultado.getString("genero"));
                fm.setCapa(resultado.getString("capa"));
                fm.setThumbnail(resultado.getString("thumbnail"));
                fm.setClassificação(resultado.getString("classificacao"));
                fm.setPath(resultado.getString("path"));                

                //Adiciona filme na lista
                lista.add(fm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }
     
     public List<Filme> FilmesRecomendados(String generofavorito1, String generofavorito2, String generofavorito3) {

        String sql = "Select * from filmes where genero in(?,?,?) ORDER BY nota DESC LIMIT 20";

        List<Filme> lista = new ArrayList<Filme>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, generofavorito1);
            stmt.setString(2, generofavorito2);
            stmt.setString(3, generofavorito3);

            ResultSet resultado = stmt.executeQuery(); //Retorna resultset

            while (resultado.next()) { //Posiciona o cursor no registro
                Filme fm = new Filme();
                fm.setId(resultado.getInt("id"));
                fm.setTitulo(resultado.getString("titulo"));
                fm.setSinopse(resultado.getString("sinopse"));
                fm.setGenero(resultado.getString("genero"));
                fm.setCapa(resultado.getString("capa"));
                fm.setThumbnail(resultado.getString("thumbnail"));
                fm.setClassificação(resultado.getString("classificacao"));
                fm.setPath(resultado.getString("path"));                

                //Adiciona filme na lista
                lista.add(fm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    /**
     * Realiza a busca de todos os registros da tabela de filmes
     *
     * @return Uma lista de objetos Usuario contendo 0 elementos quanto nao
     * tiver registros ou n elementos quando houver resultado
     */
    public List<Filme> buscarTodos() {

        String sql = "Select * from filmes order by id";

        List<Filme> lista = new ArrayList<Filme>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet resultado = stmt.executeQuery(); //Retorna resultset

            while (resultado.next()) { //Posiciona o cursor no registro
                Filme fm = new Filme();
                fm.setId(resultado.getInt("id"));
                fm.setTitulo(resultado.getString("titulo"));
                fm.setSinopse(resultado.getString("sinopse"));
                fm.setGenero(resultado.getString("genero"));
                fm.setCapa(resultado.getString("capa"));
                fm.setThumbnail(resultado.getString("thumbnail"));
                fm.setClassificação(resultado.getString("classificacao"));
                fm.setPath(resultado.getString("path"));

                //Adiciona filme na lista
                lista.add(fm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

}
