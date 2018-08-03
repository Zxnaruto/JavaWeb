package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 
 * 判断是否是闰年
 * （1）能被4整除而不能被100整除
     （2）能被400整除
 *
 */
public class DetermineLeapYear {

	public static boolean year() throws IOException {
		String str;
		BufferedReader buf;
		boolean flag=true;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入一个年份：");
		str=buf.readLine();
		int year=Integer.parseInt(str);
		
		if(year%400==0) {
			flag=true;
		}else if(year%4==0&&year%100!=0) {
			flag=true;
		}else {
			flag=false;
		}
		
		return flag;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("结果："+DetermineLeapYear.year());
	}
}
