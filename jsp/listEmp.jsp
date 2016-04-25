<%@ page import="java.util.*,entity.*" 
	pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>

<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID编号
							</td>
							<td>
								Name姓名
							</td>
							<td>
								Salary薪水
							</td>
							<td>
								Age年龄
							</td>
							<td>
								Operation操作
							</td>
						</tr>
						<%
						//从request中取绑定的数据
						List<Employee> emps = (List<Employee>)request.getAttribute("allEmps");
						//遍历显示数据
						for(int i=0;i<emps.size();i++){
						Employee e = emps.get(i);
						 %>
						<tr class="row<%=i%2+1%>">
							<td>
								<%=e.getId() %>
							</td>
							<td>
								<%=e.getName() %>
							</td>
							<td>
								<%=e.getSalary() %>
							</td>
							<td>
								<%=e.getAge() %>
							</td>
							<td>
								<a href="del.do?id=<%=e.getId()%>" onclick="return confirm('确认删除<%=e.getName()%>吗?')">delete emp</a>&nbsp;<a href="load.do?id=<%=e.getId()%>">update emp</a>
							</td>
						</tr>
						<% } %>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>


