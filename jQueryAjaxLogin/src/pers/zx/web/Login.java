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
		
		 String actionIndicator = req.getParameter("action");//获取servlet返回的字符串特指action
		 Method method = null;
	      //  Object result = null;
	      
            try {
            	//获取该类所需求的方法,这里指获取check方法
				method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class, HttpServletResponse.class);
				//执行方法
				method.invoke(this, req, resp);//方法实现，调用Login类里面的check方法	
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
     * 登陆的方法
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
		
		if(ver.toLowerCase().equals(verificate.toLowerCase())) {//不受大小写的的限制，toLower是将大写字母变为小写
			if(flag==true) {

				result.returnSuccess("登陆成功");
				 PrintUtil.write(result, response);//向ajax传值
			}else {
				result.returnFail("登陆失败");
				 PrintUtil.write(result, response);
				 
			}
		}else {
			result.returnFail("验证码错误");
			 PrintUtil.write(result, response);
		}
		
		  
		return result;
	}
 
   /* public String verification(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
           
        //生成随机字串  
       ver = Verification.generateVerifyCode(4);  
        //存入会话session  
       HttpSession session = request.getSession(true);  
        //删除以前的
        session.removeAttribute("ver");
       session.setAttribute("ver", ver.toLowerCase());  
        //生成图片  
        int w = 100, h = 30;  
        Verification.outputImage(w, h, response.getOutputStream(), ver);
        
        return ver;
    }
*/
      
}
