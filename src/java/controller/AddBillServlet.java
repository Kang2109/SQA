/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.ClientDAO;
import dao.WaterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.Client;
import model.Water;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddBillServlet", urlPatterns = {"/AddBillServlet"})
public class AddBillServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
              HttpSession session=request.getSession();
        int idclient = Integer.parseInt(session.getAttribute("idclient").toString());
        int idwater = Integer.parseInt(session.getAttribute("idwater").toString());
        int cscu=Integer.parseInt(session.getAttribute("cscu").toString());
          int tieuthu=Integer.parseInt(session.getAttribute("tieuthu").toString());
        double tiennuoc=Double.parseDouble(session.getAttribute("tiennuoc").toString());
        double tienthue=Double.parseDouble(session.getAttribute("tienthue").toString());
        double phibvmt=Double.parseDouble(session.getAttribute("phibvmt").toString());
        double tongtien=Double.parseDouble(session.getAttribute("tongtien").toString());
        
        
        
        Date date= new Date();
             Client client= new Client();
        client.setId(idclient);
        Water water=new Water();
       water.setId(idwater);
       
           Bill b= new Bill( client, water,new Timestamp(new Date().getTime()), cscu, tieuthu, tiennuoc, tienthue, phibvmt, tongtien);
            BillDAO a= new BillDAO();
            a.insertBill(b);
            
            ClientDAO c= new ClientDAO();
            Client byName =c.selectClient(idclient);
             Water upwater=new Water();
             String tthai="Da dong";
       upwater.setId(idwater);
       upwater.setTrangthai(tthai);
       WaterDAO nc= new WaterDAO();
            nc.updateWater(upwater);
            request.setAttribute("byName", byName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                session.invalidate();
                
		dispatcher.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
