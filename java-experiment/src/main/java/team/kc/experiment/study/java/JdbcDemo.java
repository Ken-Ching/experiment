package team.kc.experiment.study.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcDemo {
	protected static final Logger logger = 
			LoggerFactory.getLogger(JdbcDemo.class);
	
	public static void main (String[] args) {
		
		Connection conn = null;
		try {
			conn = getConn();
			
			selectCase(conn);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error( e.getMessage(), e);
		} finally {
			try { conn.close(); } catch (SQLException e) { }
		}
		
	}
	
	private static void selectCase (Connection conn) {
		String sql = "select u.comCode from um_t_user u where u.userCode = ?";
		try {
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, "admin4300");
			
			ResultSet result= pstmt.executeQuery();
			if (result.next()) {
				logger.info( result.getString("comCode") );
			} else {
				logger.info( "Empty result!" );
			}
			
			result.close();
			pstmt.close();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 获取数据库连接
	 * @return 数据库连接
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private static Connection getConn() 
			throws ClassNotFoundException, SQLException {
		
	    String driver = "oracle.jdbc.OracleDriver";
	    //String url = "jdbc:oracle:thin:@xxxx:1521:xxxx";
	    String url = "jdbc:oracle:thin:@"
	    		+"(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = xxxxx)"
	    		+"(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)"
	    		+"(SERVICE_NAME = xxxx)))";
	    String username = "";
	    String password = "";
	    Connection conn = null;
	    
        Class.forName(driver); //classLoader,加载对应驱动
        conn = (Connection) DriverManager.getConnection(url, username, password);
        
	    return conn;
	}
}
