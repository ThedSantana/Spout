/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.controller;

import br.com.spout.dao.UsuarioDAO;
import br.com.spout.dao.FilmesDAO;
import br.com.spout.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author debian
 */
public class AuthenticateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if(session!=null){
            session.invalidate(); //Invalida sessão            
        }
        
        response.sendRedirect("index.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Captura dados da tela
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
       
        //Coloca dados em objeto usuario
        Usuario usu = new Usuario();
        usu.setEmail(email);
        usu.setSenha(senha);
        
        //Consulta se o usuario exite no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuAutenticado = usuarioDAO.autenticar(usu);
        
        //Verifica se o usuario foi encontrado
        if (usuAutenticado != null) {

            //Coloca usuario na sessao
            HttpSession session = request.getSession();
            session.setAttribute("usuAutenticado", usuAutenticado);
            
            String generofavorito1 = usuAutenticado.getGenerofavorito1();
            String generofavorito2 = usuAutenticado.getGenerofavorito2();
            String generofavorito3 = usuAutenticado.getGenerofavorito3();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/home/home.jsp");
            
            FilmesDAO filmeDAO = new FilmesDAO();
            request.setAttribute("filme", filmeDAO.AdicionadosRecentemente());
            request.setAttribute("recomendados", filmeDAO.FilmesRecomendados(generofavorito1,generofavorito2,generofavorito3));
            request.setAttribute("page", "home/home.jsp");            
            
            //Redireciona para a tela principal 
            request.getRequestDispatcher("view/home/home.jsp").forward(request, response);
            
        }else{
            response.getWriter().print("<script> window.alert('Usuário não encontrado!');location.href='index.jsp';</script>");            
        }   
        
    }
}
