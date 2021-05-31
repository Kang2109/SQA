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
@WebServlet(name = "NVPaymentServlet", urlPatterns = {"/NVPaymentServlet"})
public class NVPaymentServlet extends HttpServlet {

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
            int idwater = Integer.parseInt(request.getParameter("idwater"));
            int idclient = Integer.parseInt(request.getParameter("idclient"));
            String thang=request.getParameter("thang");
            WaterDAO a= new WaterDAO();
            Water u= a.selectWater(idwater);
           
             Water cscu=a.selectChisocu(idclient, thang);
            
            int tieuthu= u.getChiso()-cscu.getChiso();
             HttpSession session=request.getSession();
	 double tiennuoc=a.tinhTien(tieuthu);
          double tienthue=tiennuoc*5/100;
          double phibvmt=tiennuoc*10/100;
          double tongtien=tiennuoc+tienthue+phibvmt;
           ClientDAO b= new ClientDAO();
          Client byName =b.selectClient(idclient);
          session.setAttribute("idwater",idwater);
          session.setAttribute("idclient",idclient);

          session.setAttribute("tieuthu", tieuthu);
          request.setAttribute("byName", byName);
          session.setAttribute("tieuthu", tieuthu);
          session.setAttribute("tiennuoc", tiennuoc);
          session.setAttribute("tienthue", tienthue);
          session.setAttribute("phibvmt", phibvmt);
          session.setAttribute("tongtien", tongtien);
          session.setAttribute("cscu",cscu.getChiso());
             request.setAttribute("cscu", cscu);
             request.setAttribute("u", u);
                RequestDispatcher dispatcher = request.getRequestDispatcher("NVpayment.jsp");
                dispatcher.forward(request, response);
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
/*
int idwater = Integer.parseInt(request.getParameter("idwater"));
            WaterDAO a= new WaterDAO();
            Water u= a.selectWater(idwater);
             request.setAttribute("u", u);
                RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
                dispatcher.forward(request, response);
*/