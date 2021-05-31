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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Bill;
import model.Water;

/**
 *
 * @author duyqu
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class BillDAO extends dao.DAO{
    /*private String jdbcURL = "jdbc:mysql://localhost:3306/create-user-table?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "2109";
*/
	private static final String INSERT_BILL_SQL = "INSERT INTO bill" + "  (idclient,idwater,ngaytt,cscu,tieuthu,tiennuoc,tienthue,phibvmt,tongtien) VALUES "
			+ " (?, ?, ?,?, ?, ?,?,?,?);";
        
	

    private boolean PreparedStatement;


	public BillDAO() {
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
        public void insertBill(Bill bill) throws SQLException {
		System.out.println(INSERT_BILL_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_BILL_SQL)) {
                    
			
                        preparedStatement.setInt(1, bill.getClient().getId());
                        preparedStatement.setInt(2, bill.getWater().getId());
                        
			preparedStatement.setTimestamp(3,bill.getNgaytt() );
			preparedStatement.setInt(4,bill.getCscu());
                        preparedStatement.setInt(5,bill.getTieuthu());
                        preparedStatement.setDouble(6,bill.getTiennuoc());
                        preparedStatement.setDouble(7,bill.getTienthue());
                        preparedStatement.setDouble(8,bill.getPhibvmt());
                        preparedStatement.setDouble(9,bill.getTongtien());
			System.out.println(preparedStatement);
                        
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
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

