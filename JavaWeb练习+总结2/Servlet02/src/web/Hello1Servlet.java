package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zx
 * ��ҳ���������Ϣ
 * PrintWriter writer = response.getWriter();���ɷ�������Ӧ�Ĵ�ӡ�������ҳ���
 */
@SuppressWarnings("serial")
public class Hello1Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ֹ��������
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;chatset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();//��������Ӧ--��ӡ��
		//request�ǰ����û�������������Ϣ
		String name = request.getParameter("name");//����name,�ĵ��ͻ��˱��������name��name��html�е�name��ͬ
		writer.println("<h1>���"+name+"</h1>");//input name="name"  �����name��value
		String[] info = request.getParameterValues("contact");//�ַ�������,�����html�е����ƶ�Ϊcontact�����Կ�����ѭ��,���value
		/*for(String string:info) {
			writer.println("<h1>hello"+string+"</h1>");
		}*/
		writer.close();
	}

}
