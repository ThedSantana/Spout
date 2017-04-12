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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author debian
 */
public class AdministratorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id = request.getParameter("id");        
        FilmesDAO filmeDAO = new FilmesDAO();
        Filme fm = new Filme();
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/dashboard.jsp");
        
        try{
            
            switch (action) {
            
            case "create":
                
                request.setAttribute("page", "admin/create.jsp");

                break;

            case "excluir":                
                
                fm.setId(Integer.parseInt(id));                
                filmeDAO.excluir(fm);
                request.setAttribute("filme", filmeDAO.buscarTodos());
                request.setAttribute("page", "admin/list.jsp"); 
                
                break;              

            case "editar":
                
                request.setAttribute("filme", filmeDAO.buscarPorId(Integer.parseInt(id)));
                request.setAttribute("page", "admin/edit.jsp");
                 
                break;         

            case "listar":
                
                request.setAttribute("filme", filmeDAO.buscarTodos());
                request.setAttribute("page", "admin/list.jsp");

                break; 
            
            case "buscarPorGenero":
                
                String genero = request.getParameter("genero");
                request.setAttribute("filme", filmeDAO.buscarPorGenero(genero));
                request.setAttribute("page", "admin/list.jsp");

                break;             
        }
        
        dispatcher.forward(request, response);
            
        }catch (Exception ex) 
        {
            response.sendRedirect("view/admin/login.jsp");             
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        String action = request.getParameter("action");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/dashboard.jsp");
        
        try{
            
            String id = request.getParameter("id");
            String titulo = request.getParameter("titulo");
            String sinopse = request.getParameter("sinopse");
            String genero = request.getParameter("genero");
            String capa = request.getParameter("capa");
            String thumbnail = request.getParameter("thumbnail");
            String classificação = request.getParameter("classificacao");
            String path = request.getParameter("path");
            Filme fm = new Filme();
            FilmesDAO filmeDAO = new FilmesDAO();
            
            switch(action)
            {
                case "create":           

                if (id != null) 
                    fm.setId(Integer.parseInt(id));

                fm.setTitulo(titulo);
                fm.setSinopse(sinopse);
                fm.setGenero(genero);
                fm.setCapa(capa);
                fm.setThumbnail(thumbnail);
                fm.setClassificação(classificação);
                fm.setPath(path);
                
                filmeDAO.salvar(fm);              

                request.setAttribute("filme", filmeDAO.buscarTodos());
                request.setAttribute("page", "admin/list.jsp");

                dispatcher.forward(request, response);  
                
                break;
                
                case "editar":                    
                    
                    id = request.getParameter("id");
                    titulo = request.getParameter("titulo");
                    sinopse = request.getParameter("sinopse");
                    genero = request.getParameter("genero");
                    capa = request.getParameter("capa");
                    thumbnail = request.getParameter("thumbnail");
                    classificação = request.getParameter("classificacao");
                    path = request.getParameter("path");

                    fm = new Filme();

                    if (id != null) {
                        fm.setId(Integer.parseInt(id));
                    }

                    fm.setTitulo(titulo);
                    fm.setSinopse(sinopse);
                    fm.setGenero(genero);
                    fm.setCapa(capa);
                    fm.setThumbnail(thumbnail);
                    fm.setClassificação(classificação);
                    fm.setPath(path);

                    filmeDAO.salvar(fm);

                    request.setAttribute("filme", filmeDAO.buscarTodos());
                    request.setAttribute("page", "admin/list.jsp");

                    dispatcher.forward(request, response);
                
                break;
                    
                case "buscarPorTitulo":
                
                    titulo = request.getParameter("titulo");
                    request.setAttribute("filme", filmeDAO.buscarPorTitulo(titulo));
                    request.setAttribute("page", "admin/list.jsp"); 
                    
                    dispatcher.forward(request, response);

                break;  
            }
        }
        catch (Exception ex) 
        {
            //response.sendRedirect("view/admin/dashboard.jsp");
        }      
    }

}
