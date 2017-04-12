/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.dao;

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
public class UsuarioDAO {
    
    private Connection con = ConnectionFactory.getConnection();  
    
    public void alterar(Usuario usu){ 
        
        String sql = "update usuario set nome=?, email=?, senha=md5(?) where id=?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)){ //Autoclose do statment
                        
            stmt.setString(1, usu.getNome());  //Substituindo o ? pelo dado do usuário
            stmt.setString(2, usu.getEmail()); 
            stmt.setString(3,usu.getSenha()); 
            stmt.setInt(4, usu.getId());
            
            //Executa o comando SQL no banco
            stmt.execute(); 
                        
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    
    public void cadastrar(Usuario usu){ 
        
        String sql = "insert into usuario (nome,email,senha,generofavorito1,generofavorito2,generofavorito3) values (?,?,md5(?),?,?,?)";
        
        try {
            //Cria um statment
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usu.getNome());  //Substituindo o ? pelo dado do usuário
            stmt.setString(2, usu.getEmail()); 
            stmt.setString(3,usu.getSenha()); 
            stmt.setString(4,usu.getGenerofavorito1());
            stmt.setString(5,usu.getGenerofavorito2());
            stmt.setString(6,usu.getGenerofavorito3());
            
            //Executa o comando SQL no banco
            stmt.execute(); 
            //Encerra o objeto stmt
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        
    }
    
    public void excluir(Usuario usu){ 
        
        String sql = "delete from usuario where id=?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)){ //Autoclose do statment
                        
            stmt.setInt(1, usu.getId());  //Substituindo o ? pelo dado do usuário           
            
            //Executa o comando SQL no banco
            stmt.execute(); 
                        
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
     
    public void salvar(Usuario usu){
         if(usu.getId()!=null){
             alterar(usu);
         }else{
             cadastrar(usu);
         }
         
     }
     
    /**
    * Busca de registro no banco de dados pelo ID do usuario
    * @param id É um inteiro que representa o numero do id do usuario a ser buscado
    * @return Um objeto usuario quando encontra ou null quando nao encontra 
    */
     
    public Usuario buscarPorId (Integer id){
         
         String sql = "Select * from usuario where id=?";
         
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setInt(1,id);
            ResultSet resultado = stmt.executeQuery(); //Retorna resultset
            
            if(resultado.next()){ //Posiciona o cursor no registro
                Usuario usu = new Usuario();
                usu.setId(resultado.getInt("id"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setGenerofavorito1(resultado.getString("generofavorito1"));
                usu.setGenerofavorito2(resultado.getString("generofavorito2"));
                usu.setGenerofavorito3(resultado.getString("generofavorito3"));
                
                return usu;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
         
     }
    
    /**
     * Realiza a busca de todos os registros da tabela de usuarios
     * @return Uma lista de objetos Usuario contendo 0 elementos quanto nao tiver registros
     * ou n elementos quando houver resultado
     */
    public List<Usuario> buscarTodos (){
         
        String sql = "Select * from usuario";
        
        List<Usuario> lista = new ArrayList <Usuario>();
         
        try (PreparedStatement stmt = con.prepareStatement(sql)){           
            
            ResultSet resultado = stmt.executeQuery(); //Retorna resultset
            
            while(resultado.next()){ //Posiciona o cursor no registro
                Usuario usu = new Usuario();
                usu.setId(resultado.getInt("id"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                
                //Adiciona administrador na lista
                lista.add(usu);          
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
         
    } 
    
    public Usuario autenticar(Usuario usuConsulta){
        
        String sql = "Select * from usuario where email=? and senha=md5(?)";
        
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, usuConsulta.getEmail());
            stmt.setString(2,usuConsulta.getSenha());
            ResultSet resultado = stmt.executeQuery();            
            
            if(resultado.next()){
                
                Usuario usu = new Usuario ();
                usu.setId(resultado.getInt("id"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setGenerofavorito1(resultado.getString("generofavorito1"));
                usu.setGenerofavorito2(resultado.getString("generofavorito2"));
                usu.setGenerofavorito3(resultado.getString("generofavorito3"));
                
                return usu;
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return null;               
    }    
    
}
