/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClientDAO;
import dao.SignUpDAO;
import dao.WaterDAO;
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
import model.Client;
import model.User;
import model.Water;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddWaterServlet", urlPatterns = {"/AddWaterServlet"})
public class AddWaterServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
 response.setContentType("text/html;charset=UTF-8");
          String thangg = request.getParameter("thang");
             String nam = request.getParameter("nam");
             String thang=thangg+"-"+nam;
                int chiso=Integer.parseInt(request.getParameter("chiso"));
                
		String trangthai = "Chua dong";
                HttpSession session=request.getSession();
        
        try(PrintWriter out = response.getWriter()){
            
            Water water= new Water(thang, chiso);
             WaterDAO add = new WaterDAO();
              List<Water> list = new ArrayList<Water>();
            boolean check = false;
            list = add.selectAllWater(chiso, thang);
          
              for (int i = 0; i < list.size(); i++) {
                if (water.getThang().equalsIgnoreCase(list.get(i).getThang()) || water.getChiso()==(list.get(i).getChiso()) ) {
                    request.setAttribute("wrong","Tháng nhập hoặc chỉ số đã tồn tại! Mời nhập lại.");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("addwater.jsp");
                    dispatcher.forward(request, response);
                } else {
                    check = true;
                }
            }
              if (check) {
                int idclient=Integer.parseInt(session.getAttribute("idclient").toString());
                    session.removeAttribute("idclient");
                 Client client= new Client(idclient);
		Water nc = new Water(thang,chiso,trangthai,client);
	        WaterDAO b= new WaterDAO();
                b.insertWater(water);
                ClientDAO c= new ClientDAO();
                 Client byName =c.selectClient(idclient);
                 request.setAttribute("byName", byName);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        }catch(Exception e){
              e.printStackTrace();
        }

}
}
