package pers.zx.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zx.dao.EmployeeDao;
import pers.zx.entity.Employee;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  //防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri=request.getRequestURI();//uri就是localhost:8080/scan 后面的那个/scan
		/*1.substring() 方法用于提取字符串中介于两个指定下标之间的字符。
          2.lastIndexOf 是从右向左查某个指定的字符串在字符串中最后一次出现的位置（也就是从后往前查）*/
		String action=uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));///list.jsp 得到list,+1是取/后面的字符串，/+1&.是开始和结束
		EmployeeDao dao=new EmployeeDao();
		
		//控制调用方法，不同页面调用不同的方法
		if(action.equals("list")) {//类似于首页
			try {
				List<Employee> emps = dao.findALL();//查找所有信息
				
				request.setAttribute("emps", emps);
				request.getRequestDispatcher("list.jsp").forward(request, response);//转发到list.jsp
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("add")) {
			String name=request.getParameter("name");
			double salary=Double.valueOf(request.getParameter("salary"));
			int age=Integer.valueOf(request.getParameter("age"));
			Employee emp=new Employee();
			emp.setEmp_name(name);
			emp.setEmp_age(age);
			emp.setEmp_salary(salary);
		   try {
			dao.add(emp);
			response.sendRedirect("list.do");//响应重定向页面在本页面，相当于刷新
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if(action.equals("delete")) {
			int id=Integer.valueOf(request.getParameter("id"));
			try {
				dao.delete(id);
				response.sendRedirect("list.do");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("load")) {//通过id找到信息加载到页面共修改
			int id=Integer.valueOf(request.getParameter("id"));
			try {
				Employee emp=dao.find(id);
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("update.jsp").forward(request, response);//转发到list.jsp
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(action.equals("update")) {
			
			int id=Integer.valueOf(request.getParameter("id"));
			String name=request.getParameter("name");
			double salary=Double.valueOf(request.getParameter("salary"));
			int age=Integer.valueOf(request.getParameter("age"));
			Employee emp=new Employee(id,name,age,salary);
			try {
				dao.modify(emp);
				response.sendRedirect("list.do");//重定向到list
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
