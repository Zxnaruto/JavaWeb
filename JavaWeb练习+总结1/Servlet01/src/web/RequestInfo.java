package web;
/**
 * @author zx
 * 
 * 输出请求数据包中的内容
 * 
 * 客户端发来的请求数据包到达服务器端以后会被解释为HttpServletRequest类型的对象，
 * 数据包中的数据会被存储到该类型的对象之中，所以借助于该对象提供的getHeaderNames(),getHeader(),getMethod(),getRequestURI()等方法即可获取这些信息。
 *
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//请求信息应用

public class RequestInfo extends HttpServlet {

	@Override
	//客户端发来的请求数据包到达服务器端以后会被解释为HttpServletRequest类型的对象 数据包中的数据会被存储到该类型的对象之中
	//所以可以通过HttpServletRequest获取请求信息。
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration<String> headerNames = request.getHeaderNames();//枚举方式获得请求元素
		//遍历Enumeration获取每一个消息头的名称
		while(headerNames.hasMoreElements()) {
			String nextElement = headerNames.nextElement();
			System.out.println(nextElement+":"+request.getHeader(nextElement));//输出消息头的名-值对儿信息
		}
	   System.out.println("请求方式："+request.getMethod());
	   System.out.println("协议种类："+request.getProtocol());
	   System.out.println("请求路径"+request.getServletPath());//web.xml中的url
       System.out.println("请求资源路径："+request.getRequestURI());        
       System.out.println("请求的路径信息："+request.getRequestURL());  

	}

	
}
