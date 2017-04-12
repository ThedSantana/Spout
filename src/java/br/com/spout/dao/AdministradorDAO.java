/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.dao;

import br.com.spout.model.Administrador;
import br.com.spout.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author debian
 */
public class AdministradorDAO {
    
    private Connection con = ConnectionFactory.getConnection();  
    
    public void alterar(Administrador admin){ 
        
        String sql = "update administrador set username=?, password=? where id=?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)){ //Autoclose do statment
                        
            stmt.setString(1, admin.getUsername());  //Substituindo o ? pelo dado do administrador
            stmt.setString(2, admin.getPassword());             
            stmt.setInt(3, admin.getId());
            
            //Executa o comando SQL no banco
            stmt.execute(); 
                        
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    
    public void cadastrar(Administrador admin){ 
        
        String sql = "insert into administrador (username,password) values (?,md5(?))";
        
        try {
            //Cria um statment
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, admin.getUsername());  //Substituindo o ? pelo dado do administrador
            stmt.setString(2, admin.getPassword());
            
            //Executa o comando SQL no banco
            stmt.execute(); 
            //Encerra o objeto stmt
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        
    }
    
    public void excluir(Administrador admin){ 
        
        String sql = "delete from administrador where id=?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)){ //Autoclose do statment
                        
            stmt.setInt(1, admin.getId());  //Substituindo o ? pelo dado do administrador           
            
            //Executa o comando SQL no banco
            stmt.execute(); 
                        
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
     
    public void salvar(Administrador admin){
         if(admin.getId()!=null){
             alterar(admin);
         }else{
             cadastrar(admin);
         }         
     }
     
    /**
    * Busca de registro no banco de dados pelo ID do administrador
    * @param id É um inteiro que representa o numero do id do administrador a ser buscado
    * @return Um objeto administrador quando encontra ou null quando nao encontra 
    */
     
    public Administrador buscarPorId (Integer id){
         
         String sql = "Select * from administrador where id=?";
         
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setInt(1,id);
            ResultSet resultado = stmt.executeQuery(); //Retorna resultset
            
            if(resultado.next()){ //Posiciona o cursor no registro
                Administrador admin = new Administrador();
                admin.setId(resultado.getInt("id"));
                admin.setUsername(resultado.getString("username"));                
                admin.setPassword(resultado.getString("password"));
                
                return admin;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
         
     }
    
    /**
     * Realiza a busca de todos os registros da tabela de administradores
     * @return Uma lista de objetos Administrador contendo 0 elementos quanto nao tiver registros
     * ou n elementos quando houver resultado
     */
    public List<Administrador> buscarTodos (){
         
        String sql = "Select * from administrador";
        
        List<Administrador> lista = new ArrayList <Administrador>();
         
        try (PreparedStatement stmt = con.prepareStatement(sql)){           
            
            ResultSet resultado = stmt.executeQuery(); //Retorna resultset
            
            while(resultado.next()){ //Posiciona o cursor no registro
                Administrador admin = new Administrador();
                admin.setId(resultado.getInt("id"));
                admin.setUsername(resultado.getString("username"));                
                admin.setPassword(resultado.getString("password"));
                
                //Adiciona administrador na lista
                lista.add(admin);          
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
         
    } 
    
    public Administrador autenticar(Administrador adminConsulta){
        
        String sql = "Select * from administrador where username=? and password=md5(?)";
        
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, adminConsulta.getUsername());
            stmt.setString(2,adminConsulta.getPassword());
            ResultSet resultado = stmt.executeQuery();            
            
            if(resultado.next()){
                
                Administrador admin = new Administrador();
                admin.setId(resultado.getInt("id"));
                admin.setUsername(resultado.getString("username"));
                admin.setPassword(resultado.getString("password"));
                
                return admin;
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return null;               
    }    
    
}