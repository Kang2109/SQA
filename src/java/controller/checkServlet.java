/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "checkServlet", urlPatterns = {"/checkServlet"})
public class checkServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String username = request.getParameter("username");
        String password = request.getParameter("password");

        User u = new User(username, password);
        LoginDAO dao = new LoginDAO();
       
        if (dao.checkUser(u)) {
            User newUser = new User();
            newUser = dao.getUserByUserName(username);
            if (newUser.getPosition().equalsIgnoreCase("admin")) {
                
                RequestDispatcher view = request.getRequestDispatcher("client-list");
                view.forward(request, response);
            } else {
                                RequestDispatcher view = request.getRequestDispatcher("bill.jsp");
                view.forward(request, response);
            }
        } else {
           request.setAttribute("wrong", "Username or Password wrong");
            RequestDispatcher dis = request.getRequestDispatcher("/view/admin/login.jsp");
            dis.forward(request, response);
        }

    }
    }

 


