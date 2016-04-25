package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 管理数据库连接的工具类
 * 可以获取数据库的连接对象
 * 以及关闭数据库连接
 * @author kun
 *
 */
public class DBUtil {
	/*
	 * 获取数据库连接
	 */
	public static Connection getConnection() throws Exception{
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@prophet.njit.edu:1521:course",
					"kh254",
					"GL1nGLJFM");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return con;
	}
	
	/*
	 * 关闭数据库连接
	 */
	public static void close(Connection con) throws SQLException{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
}
