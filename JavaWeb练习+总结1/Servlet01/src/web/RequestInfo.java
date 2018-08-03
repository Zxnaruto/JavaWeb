package web;
/**
 * @author zx
 * 
 * ����������ݰ��е�����
 * 
 * �ͻ��˷������������ݰ�������������Ժ�ᱻ����ΪHttpServletRequest���͵Ķ���
 * ���ݰ��е����ݻᱻ�洢�������͵Ķ���֮�У����Խ����ڸö����ṩ��getHeaderNames(),getHeader(),getMethod(),getRequestURI()�ȷ������ɻ�ȡ��Щ��Ϣ��
 *
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//������ϢӦ��

public class RequestInfo extends HttpServlet {

	@Override
	//�ͻ��˷������������ݰ�������������Ժ�ᱻ����ΪHttpServletRequest���͵Ķ��� ���ݰ��е����ݻᱻ�洢�������͵Ķ���֮��
	//���Կ���ͨ��HttpServletRequest��ȡ������Ϣ��
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration<String> headerNames = request.getHeaderNames();//ö�ٷ�ʽ�������Ԫ��
		//����Enumeration��ȡÿһ����Ϣͷ������
		while(headerNames.hasMoreElements()) {
			String nextElement = headerNames.nextElement();
			System.out.println(nextElement+":"+request.getHeader(nextElement));//�����Ϣͷ����-ֵ�Զ���Ϣ
		}
	   System.out.println("����ʽ��"+request.getMethod());
	   System.out.println("Э�����ࣺ"+request.getProtocol());
	   System.out.println("����·��"+request.getServletPath());//web.xml�е�url
       System.out.println("������Դ·����"+request.getRequestURI());        
       System.out.println("�����·����Ϣ��"+request.getRequestURL());  

	}

	
}
