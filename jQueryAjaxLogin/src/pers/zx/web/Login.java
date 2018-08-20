package pers.zx.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.zx.service.PersonService;
import pers.zx.util.PrintUtil;
import pers.zx.util.ReturnResult;
import pers.zx.util.Verification;

/**
 * Servlet implementation class Login
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Login" }, name = "Login")
public class Login extends HttpServlet {

	//private String ver;
	@SuppressWarnings("rawtypes")
	public Class getServletClass(){
		return Login.class;
	}
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
		 //resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String actionIndicator = req.getParameter("action");//��ȡservlet���ص��ַ�����ָaction
		 Method method = null;
	      //  Object result = null;
	      
            try {
            	//��ȡ����������ķ���,����ָ��ȡcheck����
				method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class, HttpServletResponse.class);
				//ִ�з���
				method.invoke(this, req, resp);//����ʵ�֣�����Login�������check����	
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
	}

	/**
     * ��½�ķ���
     * @param request
     * @return
     */
public ReturnResult check(HttpServletRequest request, HttpServletResponse response) {
	    ReturnResult result=new ReturnResult();
	    VerSerlvet v=new VerSerlvet();
		boolean flag=false;
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String verificate=request.getParameter("verificate");
		PersonService per=new PersonService();
		flag=per.check(name, password);
		System.out.println(name);
		String ver=v.vercode;
		
		if(ver.toLowerCase().equals(verificate.toLowerCase())) {//���ܴ�Сд�ĵ����ƣ�toLower�ǽ���д��ĸ��ΪСд
			if(flag==true) {

				result.returnSuccess("��½�ɹ�");
				 PrintUtil.write(result, response);//��ajax��ֵ
			}else {
				result.returnFail("��½ʧ��");
				 PrintUtil.write(result, response);
				 
			}
		}else {
			result.returnFail("��֤�����");
			 PrintUtil.write(result, response);
		}
		
		  
		return result;
	}
 
   /* public String verification(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
           
        //��������ִ�  
       ver = Verification.generateVerifyCode(4);  
        //����Ựsession  
       HttpSession session = request.getSession(true);  
        //ɾ����ǰ��
        session.removeAttribute("ver");
       session.setAttribute("ver", ver.toLowerCase());  
        //����ͼƬ  
        int w = 100, h = 30;  
        Verification.outputImage(w, h, response.getOutputStream(), ver);
        
        return ver;
    }
*/
      
}
