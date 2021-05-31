/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClientDAO;

import model.Client;


/**
 *
 * @author duyqu
 */
@WebServlet("/")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO;
	
	public void init() {
		clientDAO = new ClientDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertClient(request, response);
				break;
			case "/delete":
				deleteClient(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateClient(request, response);
				break;
                         case "/more":
				showInfoForm(request, response);
				break; 
                          case "/NVmore":
				NVshowInfoForm(request, response);
				break;       
			default:
				listClient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Client> listClient = clientDAO.selectAllClient();
		request.setAttribute("listClient", listClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("client-form.jsp");
		dispatcher.forward(request, response);
	}
        private void showInfoForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client byName = clientDAO.selectClient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("byName", byName);
		dispatcher.forward(request, response);

	}
            private void NVshowInfoForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client byName = clientDAO.selectClient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NVindex.jsp");
		request.setAttribute("byName", byName);
		dispatcher.forward(request, response);

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client existingClient = clientDAO.selectClient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client-form.jsp");
		request.setAttribute("client", existingClient);
		dispatcher.forward(request, response);

	}

	private void insertClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
                String address=request.getParameter("address");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		Client newClient = new Client(name,address, email,phonenumber);
		clientDAO.insertClient(newClient);
		response.sendRedirect("list");
	}

	private void updateClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address=request.getParameter("address");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		Client upClient = new Client(id,name,address, email,phonenumber);
		clientDAO.updateClient(upClient);
		response.sendRedirect("list");
	}

	private void deleteClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clientDAO.deleteClient(id);
		response.sendRedirect("list");

	}

}
