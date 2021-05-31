/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SignUpDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author duyqu
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String name = request.getParameter("name");
                String address=request.getParameter("address");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
            String username=request.getParameter("username");
            String pass=request.getParameter("password");
            String position=request.getParameter("position");
          User user= new User(name, email, address, phonenumber, username, pass,position);
           HttpSession session = request.getSession();
        
        try(PrintWriter out = response.getWriter()){
            
            
             SignUpDAO sign = new SignUpDAO();
              List<User> list = new ArrayList<User>();
            boolean check = false;
            list = sign.selectAllUser();
          
              for (int i = 0; i < list.size(); i++) {
                if (user.getUsername().equalsIgnoreCase(list.get(i).getUsername()) || user.getEmail().equalsIgnoreCase(list.get(i).getEmail()) ) {
                    request.setAttribute("wrong","Tên tài khoản hoặc Email đã tồn tại");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
                    dispatcher.forward(request, response);
                } else {
                    check = true;
                }
            }
              if (check) {
                sign.insertUser(user);
                
                response.sendRedirect("adminview.jsp");
            }
        }catch(Exception e){
              e.printStackTrace();
        }
           
    }

    
   
}
