package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.获取uri
		String uri = request.getRequestURI();
		//2.截取uri中的动作
		uri=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(uri.equals("/list")){
			try {
				//创建DAO对象，调用findAll()方法获取数据
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> emps = dao.findAll();
				//绑定数据到request中
				request.setAttribute("allEmps", emps);
				//转发
				request.getRequestDispatcher("listEmp.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(uri.equals("/add")){
			//获取表单数据，封装成对象，实例化dao，调save方法，重定向到list.do
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			Employee emp = new Employee();
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.save(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(uri.equals("/del")){
			//获取地址栏中的id
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				//实例化dao，调用删除方法
				EmployeeDAO dao = new EmployeeDAO();
				dao.delete(id);
				//重定向到/list.do查看新的查询结果
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(uri.equals("/load")){
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee emp =  dao.findById(id);
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(uri.equals("/update")){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			Double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			Employee emp = new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.modify(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
