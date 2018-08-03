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
		  //��ֹ��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri=request.getRequestURI();//uri����localhost:8080/scan ������Ǹ�/scan
		/*1.substring() ����������ȡ�ַ����н�������ָ���±�֮����ַ���
          2.lastIndexOf �Ǵ��������ĳ��ָ�����ַ������ַ��������һ�γ��ֵ�λ�ã�Ҳ���ǴӺ���ǰ�飩*/
		String action=uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));///list.jsp �õ�list,+1��ȡ/������ַ�����/+1&.�ǿ�ʼ�ͽ���
		EmployeeDao dao=new EmployeeDao();
		
		//���Ƶ��÷�������ͬҳ����ò�ͬ�ķ���
		if(action.equals("list")) {//��������ҳ
			try {
				List<Employee> emps = dao.findALL();//����������Ϣ
				
				request.setAttribute("emps", emps);
				request.getRequestDispatcher("list.jsp").forward(request, response);//ת����list.jsp
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
			response.sendRedirect("list.do");//��Ӧ�ض���ҳ���ڱ�ҳ�棬�൱��ˢ��
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
		}else if(action.equals("load")) {//ͨ��id�ҵ���Ϣ���ص�ҳ�湲�޸�
			int id=Integer.valueOf(request.getParameter("id"));
			try {
				Employee emp=dao.find(id);
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("update.jsp").forward(request, response);//ת����list.jsp
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
				response.sendRedirect("list.do");//�ض���list
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
