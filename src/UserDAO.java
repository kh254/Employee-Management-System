package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import entity.User;

/**
 * 用户表t_emp的数据操作类
 * @author kun
 *
 */
public class UserDAO {
	/**
	 * 按照username查询一个实体信息
	 * 注册时用于检测用户名是否重复
	 * 登录时用于检测用户名密码是否正确
	 */
	public User findByUserName(String userName) throws Exception{
		User user = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement("select * from t_user where username=?");
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setGender(rs.getString("gender"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(con);
		}
		return user;
	}
	
	/**
	 * 增加用户信息(注册时用)
	 */
	public void save(User user)throws Exception{
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement("insert into t_user values(user_id_seq.nextval,?,?,?,?)");
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPwd());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getGender());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(con);
		}
	}
	
	public static void main(String[] args) throws Exception {
	UserDAO dao = new UserDAO();
		User u = dao.findByUserName("test");
		System.out.println(u);
//		User u = new User();
//		u.setUserName("test");
//		u.setName("test");
//		u.setGender("m");
//		u.setPwd("text");
//		dao.save(u);
	}
}
