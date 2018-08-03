package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zx
 * 在页面输出表单信息
 * PrintWriter writer = response.getWriter();是由服务器响应的打印流输出到页面的
 */
@SuppressWarnings("serial")
public class Hello1Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//防止中文乱码
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;chatset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();//服务器响应--打印流
		//request是包含用户的所有请求信息
		String name = request.getParameter("name");//请求name,的到客户端表单中输入的name，name与html中的name相同
		writer.println("<h1>你好"+name+"</h1>");//input name="name"  ，输出name的value
		String[] info = request.getParameterValues("contact");//字符串数组,这个在html中的名称都为contact，所以可以用循环,输出value
		/*for(String string:info) {
			writer.println("<h1>hello"+string+"</h1>");
		}*/
		writer.close();
	}

}
