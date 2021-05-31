package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Water;

import model.User;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/create-user-table?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "2109";

	private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (name, email,address,position,username,password) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,email,address,position,username,password from user where id =?";
	private static final String SELECT_ALL = "select id,thang,tieuthu,trangthai from nuoc where iduser=?";
	private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user set name = ?,email= ?,address= ?,position= ?,username= ? where id = ?;";
        private static final String SELECT_USERS_BY_NAME = "select id,name,email,address,position,username,password from user where name =?";
        	

    private boolean PreparedStatement;


	public UserDAO() {
	}

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

	
        

	public List<Water> selectAllNC(int iduser) {

		
		List<Water> nc = new ArrayList<>();
		
		try (Connection connection = getConnection();


			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
                     preparedStatement.setInt(1,iduser);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int id = rs.getInt("id");
				String thang = rs.getString("thang");
				int tieuthu = rs.getInt("tieuthu");
				String trangthai = rs.getString("trangthai");
                             
                                
                                
				nc.add(new Water(id, thang, tieuthu, trangthai));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return nc;
	}
        public List<User> selectByName(String name) {

		
		List<User> users = new ArrayList<>();
		
		try (Connection connection = getConnection();

			
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_NAME);) {
                    preparedStatement.setString(1, name);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				
				String email = rs.getString("email");
				String address = rs.getString("address");
                                String position = rs.getString("position");
                                String username = rs.getString("username");
                                String password = rs.getString("password");
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
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
