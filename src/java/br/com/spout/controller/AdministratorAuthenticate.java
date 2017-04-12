/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.controller;

import br.com.spout.dao.AdministradorDAO;
import br.com.spout.dao.UsuarioDAO;
import br.com.spout.model.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author debian
 */
public class AdministratorAuthenticate extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if(session!=null){
            session.invalidate(); //Invalida sessão            
        }
        
        response.sendRedirect("view/admin/login.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Captura dados da tela
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        //Coloca dados em objeto usuario
        Administrador admin = new Administrador();
        admin.setUsername(username);
        admin.setPassword(password);
        
        //Consulta se o usuario exite no banco de dados
        AdministradorDAO adminDAO = new AdministradorDAO();
        Administrador adminAutenticado = adminDAO.autenticar(admin);
        
        //Verifica se o usuario foi encontrado
        if (adminAutenticado!=null){
            
            //Coloca usuario na sessao
            HttpSession session = request.getSession();
            session.setAttribute("adminAutenticado",adminAutenticado);
            
            session.setMaxInactiveInterval(60*15); //Define tempo maximo de sessão
            
            //Redireciona para o dashboard 
            response.sendRedirect("admin?action=listar");
            
        }else{
            response.getWriter().print("<script> window.alert('Administrador não encontrado!');location.href='view/admin/login.jsp';</script>");            
        }
        
    }
    
}
