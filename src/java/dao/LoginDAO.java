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
import java.util.logging.Level;
import java.util.logging.Logger;

import model.User;


/**
 *
 * @author duyqu
 */
public class LoginDAO extends dao.DAO{
    /*private String jdbcURL = "jdbc:mysql://localhost:3306/create-user-table?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "2109";

*/	/*	
	private static final String CHECK_LOGIN = "select * from user where username =? and password=?";
	
	
        private boolean PreparedStatement;

*/
	public LoginDAO() {
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
        /*
public User checkLogin(String username,String password ) {
		User user = null;
		// Step 1: Establishing a Connection
		try (   
                        
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = con.prepareStatement(CHECK_LOGIN);) {
			preparedStatement.setString(1, username);
                        preparedStatement.setString(2, password);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				
				
                            user = new User(username,password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
        */
        public boolean checkUser(User user){
        String sql="SELECT * FROM user WHERE username=? and password=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
         
            
            
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user.setName(rs.getString("name"));
                user.setPosition(rs.getString("position"));
                return true;
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
        public User getUserByUserName(String key){
        User user=new User();
        String sql= "SELECT * FROM user WHERE username=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPosition(rs.getString("position"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhonenumber(rs.getString("phonenumber"));
                System.out.println(user.toString());
                return user;         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
