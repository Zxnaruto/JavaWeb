package pers.zx.httpservlet;

/**
 * @author zx
 * 
 * 请求当前时间到页面
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class requestDate extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  response.setContentType("text/html;charset=utf-8");//设置响应的格式即字符编码
	  PrintWriter writer = response.getWriter();//打印信息
	  //Date方法
	  Date date = new Date();
	    //Calendar 方法
	  Calendar cal=Calendar.getInstance();
	  int year=cal.get(Calendar.YEAR);
	  int month=cal.get(Calendar.MONTH);
	  int day=cal.get(Calendar.DATE);
	  int hour=cal.get(Calendar.HOUR_OF_DAY);
	  int minute=cal.get(Calendar.MINUTE);
	  int second=cal.get(Calendar.SECOND);
	  int week=cal.get(Calendar.DAY_OF_WEEK);//获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
	  String weeks=null;
      if(week==2) {
    	  weeks="星期一";
      }else if(week==3) {
    	  weeks="星期二";
      }else if(week==4) {
    	  weeks="星期三";
      }else if(week==5) {
    	  weeks="星期四";
      }else if(week==6) {
    	  weeks="星期五";
      }else if(week==7) {
    	  weeks="星期六";
      }else if(week==1) {
    	  weeks="星期天";
      }
	  String title="当前的时间";
	  String html="<!DOCTYPE html>\n";
	  writer.println(html+
			  "<html>\n"+
			  "<head><title>"+title+"</title>\n"+
			  "<body>\n"+
			  "<h1>当前的时间(Date):</h1>"+
			  "<h2>"+date.toString()+"</h2>\n"+
			  "<h1>当前时间(Calendar):</h1>"+
			  "<h2>"+year+"年"+month+"月"+day+"日"+"</h2>"+
			  "<h2>"+hour+"时"+minute+"分"+second+"秒"+"</h2>"+
			  "<h2>"+weeks+"</h2>"+
			  "</body></html>");
	 
	}

	
}
