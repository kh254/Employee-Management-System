package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

/**
 * ÂëòÂ∑•‰ø°ÊÅØÁöÑÊï∞ÊçÆÊìç‰ΩúÁ±ª
 * Áî®‰∫éÂÆûÁé∞ÂëòÂ∑•‰ø°ÊÅØÁöÑÂ¢ûÂà†ÊîπÊü•ÂäüËÉΩ
 * @author kun
 *
 */

public class EmployeeDAO {
	/**Â¢ûÂä†ÂëòÂ∑•‰ø°ÊÅØ
	 * @throws Exception */
	public void save(Employee emp) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = DBUtil.getConnection();
			pst = con.prepareStatement("insert into t_emp values(emp_id_seq.nextval,?,?,?)");
			pst.setString(1, emp.getName());
			pst.setDouble(2, emp.getSalary());
			pst.setInt(3, emp.getAge());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(con);
		}
	}
	
	/**
	 * Âà†Èô§ÂëòÂ∑•‰ø°ÊÅØ
	 */
	public void delete(int id)throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = DBUtil.getConnection();
			pst = con.prepareStatement("delete from t_emp where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(con);
		}
		
	}

	/**ÊåâÁÖßidÊü•ËØ¢‰∏Ä‰∏™ÂëòÂ∑•‰ø°ÊÅØ 
	 * @throws Exception */
	public Employee findById(int id) throws Exception{
		Employee emp = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			pst = con.prepareStatement("select * from t_emp where id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(con);
		}
		return emp;
	}
	/** Êü•ËØ¢ÂÖ®ÈÉ®ÂëòÂ∑•‰ø°ÊÅØ
	 * @throws Exception */
	public List<Employee> findAll() throws Exception{
		List<Employee> emps = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			pst = con.prepareStatement("select * from t_emp");
			rs = pst.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				emps.add(emp);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(con);
		}
		return emps;
	}
	
	/**‰øùÂ≠ò‰øÆÊîπ‰ø°ÊÅØ */
	public void modify(Employee emp) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = DBUtil.getConnection();
			pst = con.prepareStatement("update t_emp set name=?,salary=?,age=? where id=?");
			pst.setString(1, emp.getName());
			pst.setDouble(2, emp.getSalary());
			pst.setInt(3, emp.getAge());
			pst.setInt(4, emp.getId());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(con);
		}
	}
	
	public static void main(String[] args) throws Exception{
		List<Employee> emps = new EmployeeDAO().findAll();
		for(Employee e : emps){
			System.out.println(e);
		}
//		Employee e = new Employee();
//		e.setName("Test");
//		e.setSalary(2000);
//		e.setAge(40);
//		new EmployeeDAO().save(e);
		
	} 
}
