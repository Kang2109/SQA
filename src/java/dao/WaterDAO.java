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
import model.Water;

/**
 *
 * @author duyqu
 */
public class WaterDAO extends dao.DAO{
   /* private String jdbcURL = "jdbc:mysql://localhost:3306/create-user-table?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "2109";
*/
	private static final String INSERT_WATER_SQL = "INSERT INTO water" + "  (thang, chiso,trangthai,idclient) VALUES "
			+ " ( ?,?, ?, ?);";
        private static final String SELECT_CHISOCU = "select chiso from water where idclient =? and thang=?";
	private static final String SELECT_WATER_BY_ID = "select id,thang,chiso from water where id =?";
	private static final String SELECT_ALL_WATER_BY_IDCLIENT = "select id,thang,chiso,trangthai from water where idclient=? and trangthai=?";
	
	private static final String UPDATE_WATER_SQL = "update water set trangthai= ? where id = ?;";
        	

    private boolean PreparedStatement;


	public WaterDAO() {
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
        public List<Water> selectAllWater(int idclient, String tthai) {

		
		List<Water> water = new ArrayList<>();
		
		try (


			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_WATER_BY_IDCLIENT);) {
                     preparedStatement.setInt(1,idclient);
                     preparedStatement.setString(2,tthai);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int id = rs.getInt("id");
				String thang = rs.getString("thang");
				int chiso = rs.getInt("chiso");
				String trangthai = rs.getString("trangthai");
                             
                                
                                
				water.add(new Water(id, thang, chiso, trangthai));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return water;
	}
        public void insertWater(Water water) throws SQLException {
		System.out.println(INSERT_WATER_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_WATER_SQL)) {
                    
			preparedStatement.setString(1, water.getThang());
                        preparedStatement.setInt(2, water.getChiso());
			preparedStatement.setString(3, water.getTrangthai());
			preparedStatement.setInt(4, water.getClient().getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}public Water selectWater(int id) {
		Water water= null;
		// Step 1: Establishing a Connection
		try (
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = con.prepareStatement(SELECT_WATER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
                                
				String thang = rs.getString("thang");
                                int chiso = rs.getInt("chiso");
				water = new Water(id, thang,chiso);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return water;
	}
        public Water selectChisocu(int idclient,String thang) {
		Water water= null;
		// Step 1: Establishing a Connection
		try (
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = con.prepareStatement(SELECT_CHISOCU);) {
			preparedStatement.setInt(1, idclient);
                        preparedStatement.setString(2,thangtrc(thang));
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
                                
				
                                int chiso = rs.getInt("chiso");
				water = new Water(chiso);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return water;
	}
        public static String thangtrc( String str){
        
        String[] s = str.split("-");
        int m = Integer.parseInt(s[0]+"");
        int y = Integer.parseInt(s[1]+"");
        if(m==1){
            m=12;
            y=y-1;
        }
        else{
            m=m-1;
        }
        String a = m+"-"+y;
        return a;
    }
       public static double tinhTien( int soKhoi ){
        double tongTien = 0;
        if( soKhoi <= 10) {
            tongTien = soKhoi*5973.0;
        } else if (soKhoi <= 20) {
            tongTien = 10*5973.0 + (soKhoi-10)*7052.0;
        } else if (soKhoi <= 30) {
            tongTien = 10*5973.0 + 10*7052.0 + (soKhoi-20)*8669.0;
        } else {
            tongTien = 10*5973.0 + 10*7052.0 + 10*8669.0 + (soKhoi-30)*15929.0;
        }
        return tongTien;
    }
       public boolean updateWater(Water water) throws SQLException {
		boolean rowUpdated;
		try (
				PreparedStatement statement = con.prepareStatement(UPDATE_WATER_SQL);) {
			
                    statement.setString(1,water.getTrangthai());
                    statement.setInt(2,water.getId());    

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
