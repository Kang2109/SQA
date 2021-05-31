/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Client;
import model.User;

/**
 *
 * @author duyqu
 */
public class ClientDAO extends dao.DAO{
   /* private String jdbcURL = "jdbc:mysql://localhost:3306/create-user-table?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "2109";
*/
	private static final String INSERT_CLIENT_SQL = "INSERT INTO client" + "  (name,address, email, phonenumber) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_CLIENT_BY_ID = "select id,name,address,email,phonenumber from client where id =?";
	private static final String SELECT_ALL_CLIENT = "select * from client";
	private static final String DELETE_CLIENT_SQL = "delete from client where id = ?;";
	private static final String UPDATE_CLIENT_SQL = "update client set name = ?, address=?,email= ?, phonenumber =? where id = ?;";

	public ClientDAO() {
	}
/*
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
*/
	public void insertClient(Client client) throws SQLException {
		System.out.println(INSERT_CLIENT_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_CLIENT_SQL)) {
                    
			preparedStatement.setString(1, client.getName());
                        preparedStatement.setString(2, client.getAddress());
			preparedStatement.setString(3, client.getEmail());
			preparedStatement.setString(4, client.getPhonenumber());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Client selectClient(int id) {
		Client client= null;
		// Step 1: Establishing a Connection
		try (
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = con.prepareStatement(SELECT_CLIENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
                                
				String name = rs.getString("name");
                                String address = rs.getString("address");
				String email = rs.getString("email");
				String phonenumber = rs.getString("phonenumber");
				client = new Client(id, name,address, email, phonenumber);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return client;
	}
        

	public List<Client> selectAllClient() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Client> client = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_CLIENT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
                                String address = rs.getString("address");
				String email = rs.getString("email");
				String phonenumber = rs.getString("phonenumber");
				client.add(new Client(id, name,address, email, phonenumber));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return client;
	}

	public boolean deleteClient(int id) throws SQLException {
		boolean rowDeleted;
		try (
				PreparedStatement statement = con.prepareStatement(DELETE_CLIENT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateClient(Client client) throws SQLException {
		boolean rowUpdated;
		try (
				PreparedStatement statement = con.prepareStatement(UPDATE_CLIENT_SQL);) {
			statement.setString(1, client.getName());
                        statement.setString(2, client.getAddress());
			statement.setString(3, client.getEmail());
			statement.setString(4, client.getPhonenumber());
			statement.setInt(5, client.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
