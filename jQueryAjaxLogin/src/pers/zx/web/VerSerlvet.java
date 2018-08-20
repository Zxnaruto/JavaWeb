package pers.zx.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.zx.util.Verification;

/**
 * Servlet implementation class VerSerlvet
 */
@WebServlet("/VerSerlvet")
public class VerSerlvet extends HttpServlet {
	public static String vercode;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
        //��������ִ�  
        String verifyCode = Verification.generateVerifyCode(4);  
        vercode=verifyCode;
        //����Ựsession  
        HttpSession session = request.getSession(true);  
        //ɾ����ǰ��
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());  
        //����ͼƬ  
        int w = 100, h = 30;  
        Verification.outputImage(w, h, response.getOutputStream(), verifyCode);
	
	}

	
}
