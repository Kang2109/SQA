/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ClientDAO;
import dao.WaterDAO;
import model.Client;
import model.Water;

/**
 *
 * @author duyqu
 */
@WebServlet(name = "addWServlet", urlPatterns = {"/addWServlet"})
public class addWServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
             String thangg = request.getParameter("thang");
             String nam = request.getParameter("nam");
             String thang=thangg+"-"+nam;
                int chiso=Integer.parseInt(request.getParameter("chiso"));
		String trangthai = "Chua dong";
                HttpSession session=request.getSession();
		try{
                    int idclient=Integer.parseInt(session.getAttribute("idclient").toString());
                    session.removeAttribute("idclient");
                 Client client= new Client(idclient);
		Water water = new Water(thang,chiso,trangthai,client);
	        WaterDAO b= new WaterDAO();
                b.insertWater(water);
                ClientDAO c= new ClientDAO();
                 Client byName =c.selectClient(idclient);
                 request.setAttribute("byName", byName);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                }catch(Exception e){
                    
                }
    }

    
}
