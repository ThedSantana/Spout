/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.controller;

import br.com.spout.dao.UsuarioDAO;
import br.com.spout.dao.FilmesDAO;
import br.com.spout.model.Filme;
import br.com.spout.model.Usuario;
import br.com.spout.util.Message;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows
 */
public class UsuarioController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FilmesDAO filmeDAO = new FilmesDAO();
        Filme fm = new Filme();
        Usuario usu = new Usuario();
        RequestDispatcher dispatcher;

        switch (action) {
            case "home":

                dispatcher = request.getRequestDispatcher("view/home/home.jsp");        
                
                usu = usuarioDAO.buscarPorId(Integer.parseInt(id));
                
                String generofavorito1= usu.getGenerofavorito1();
                String generofavorito2= usu.getGenerofavorito2();
                String generofavorito3= usu.getGenerofavorito3();

                request.setAttribute("filme", filmeDAO.AdicionadosRecentemente());
                request.setAttribute("recomendados", filmeDAO.FilmesRecomendados(generofavorito1,generofavorito2,generofavorito3));
                request.setAttribute("page", "home/home.jsp");

                dispatcher.forward(request, response);

                break; 
                
             case "voltar":

                dispatcher = request.getRequestDispatcher("view/user/perfil.jsp");
                request.setAttribute("home", "home/home.jsp");
                dispatcher.forward(request, response);

                break; 

            case "create":

                dispatcher = request.getRequestDispatcher("view/user/create.jsp");
                request.setAttribute("page", "user/create.jsp");
                dispatcher.forward(request, response);

                break;

            case "excluir":

                if (id != null) {
                    usu.setId(Integer.parseInt(id));
                }

                usuarioDAO.excluir(usu);

                //Responde direto para o Browser, sem passar por um JSP do lado do servidor.
                response.sendRedirect("index.jsp");

                break;

            case "editar":

                usu = usuarioDAO.buscarPorId(Integer.parseInt(id));
                request.setAttribute("usu", usu);
                dispatcher = request.getRequestDispatcher("view/user/perfil.jsp");

                request.setAttribute("page", "user/update.jsp");
                dispatcher.forward(request, response);

                break;

            case "alterar-senha":

                usu = usuarioDAO.buscarPorId(Integer.parseInt(id));
                request.setAttribute("usu", usu);
                dispatcher = request.getRequestDispatcher("view/user/perfil.jsp");

                request.setAttribute("page", "user/update-password.jsp");
                dispatcher.forward(request, response);

                break;

            case "buscarPorGenero":

                dispatcher = request.getRequestDispatcher("view/home/grid-filmes.jsp");

                String genero = request.getParameter("genero");
                request.setAttribute("filme", filmeDAO.buscarPorGenero(genero));
                request.setAttribute("page", "home/grid-filmes.jsp");

                dispatcher.forward(request, response);

                break;         
         }        
           
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");      

        switch (action) {

            case "create":

                String id = request.getParameter("id");
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                String generofavorito1 = request.getParameter("generofavorito1");
                String generofavorito2 = request.getParameter("generofavorito2");
                String generofavorito3 = request.getParameter("generofavorito3");
                
                Usuario usu = new Usuario();

                if (id != null) {
                    usu.setId(Integer.parseInt(id));
                }

                usu.setNome(nome);
                usu.setEmail(email);
                usu.setSenha(senha);
                usu.setGenerofavorito1(generofavorito1);
                usu.setGenerofavorito2(generofavorito2);
                usu.setGenerofavorito3(generofavorito3);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.salvar(usu);

                response.sendRedirect("index.jsp");

                break;

            case "buscarPorTitulo":

                RequestDispatcher dispatcher = request.getRequestDispatcher("view/home/grid-filmes.jsp");
                
                FilmesDAO filmeDAO = new FilmesDAO();
                
                String titulo = request.getParameter("titulo");
                request.setAttribute("filme", filmeDAO.buscarPorTitulo(titulo));
                request.setAttribute("page", "home/grid-filmes.jsp");

                dispatcher.forward(request, response);

                break;
                
            case "alterar-senha":
                
                dispatcher = request.getRequestDispatcher("view/user/update-password.jsp");
                
                UsuarioDAO usuDAO = new UsuarioDAO();                
                
                id = request.getParameter("id");
                String novaSenha = request.getParameter("nova-senha");
                String confirmarSenha = request.getParameter("confirmar-senha");                
                
                usu = usuDAO.buscarPorId(Integer.parseInt(id));               
                
                if (novaSenha.equals(confirmarSenha)) {
                    
                    usu.setSenha(novaSenha);
                    usuDAO.salvar(usu);              
                    
                    response.getWriter().print("<script> window.alert('Senha alterada com sucesso!');location.href='';</script>");
                    
                } else {
                    response.getWriter().print("<script> window.alert('As senhas digitadas não conferem!');location.href='';</script>");
                    break;
                }      
                
                break;
        }
         
    }    

}
