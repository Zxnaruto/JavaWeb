package pers.zx.httpservlet;

/**
 * @author zx
 * 
 * ����ǰʱ�䵽ҳ��
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
	  response.setContentType("text/html;charset=utf-8");//������Ӧ�ĸ�ʽ���ַ�����
	  PrintWriter writer = response.getWriter();//��ӡ��Ϣ
	  //Date����
	  Date date = new Date();
	    //Calendar ����
	  Calendar cal=Calendar.getInstance();
	  int year=cal.get(Calendar.YEAR);
	  int month=cal.get(Calendar.MONTH);
	  int day=cal.get(Calendar.DATE);
	  int hour=cal.get(Calendar.HOUR_OF_DAY);
	  int minute=cal.get(Calendar.MINUTE);
	  int second=cal.get(Calendar.SECOND);
	  int week=cal.get(Calendar.DAY_OF_WEEK);//������ڼ���ע�⣨�����Date���ǲ�ͬ�ģ���1���������ա�2��������1��3�������ڶ����Դ����ƣ�
	  String weeks=null;
      if(week==2) {
    	  weeks="����һ";
      }else if(week==3) {
    	  weeks="���ڶ�";
      }else if(week==4) {
    	  weeks="������";
      }else if(week==5) {
    	  weeks="������";
      }else if(week==6) {
    	  weeks="������";
      }else if(week==7) {
    	  weeks="������";
      }else if(week==1) {
    	  weeks="������";
      }
	  String title="��ǰ��ʱ��";
	  String html="<!DOCTYPE html>\n";
	  writer.println(html+
			  "<html>\n"+
			  "<head><title>"+title+"</title>\n"+
			  "<body>\n"+
			  "<h1>��ǰ��ʱ��(Date):</h1>"+
			  "<h2>"+date.toString()+"</h2>\n"+
			  "<h1>��ǰʱ��(Calendar):</h1>"+
			  "<h2>"+year+"��"+month+"��"+day+"��"+"</h2>"+
			  "<h2>"+hour+"ʱ"+minute+"��"+second+"��"+"</h2>"+
			  "<h2>"+weeks+"</h2>"+
			  "</body></html>");
	 
	}

	
}
