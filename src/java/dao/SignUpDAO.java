/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
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
public class SignUpDAO extends dao.DAO{
    /* private String jdbcURL = "jdbc:mysql://localhost:3306/create-user-table?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "2109";
*/
		
private static final String INSERT_USER_SQL = "INSERT INTO user" + "  (name,email,address, phonenumber,username,password,position) VALUES "
			+ " (?,?,?, ?, ?, ?,?);";
private static final String SELECT_ALL_USER = "select * from user";

	
        private boolean PreparedStatement;
public SignUpDAO() {
	}
/*
protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		return connection;
	}
*/

public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USER_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_USER_SQL)) {
                    
			preparedStatement.setString(1, user.getName());
                        preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhonenumber());
                        preparedStatement.setString(5, user.getUsername());
                        preparedStatement.setString(6, user.getPassword());
                        preparedStatement.setString(7, user.getPosition());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
public List<User> selectAllUser() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> user = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_USER);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
                                
                                
				String email = rs.getString("email");
                                 String address = rs.getString("address");
				String phonenumber = rs.getString("phonenumber");
                                String username = rs.getString("username");
                                String password = rs.getString("password");
                                String position = rs.getString("position");
                                
                                
				user.add(new User(name, email, address, phonenumber, username, password,position));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
/*
	public User selectUserbyName(String username) {
		User user = null;
	
		try (Connection connection = getConnection();
			
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);) {
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
                            int id=rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
                               
				user = new User(id, name, email, address,username);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
*/
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
