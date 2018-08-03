package pers.zx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 
 * 模拟登录,给三次机会,并提示还有几次机会
（1）假设用户名和密码均为admin，如果输入正确，控制台输出：欢迎admin登录
（2）如果输入错误，控制台输出：录入错误,您还有2次机会（最多有3次机会）

 *
 */
public class Login {

	public static void main(String[] args)throws IOException {
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		String name="admin";
		String password="admin";
		String str1,str2;
		int flag=0;
		System.out.println("****    用户登陆        ****");
		while(true) {
			flag++;
		System.out.print("name:");
		str1=buf.readLine();
		System.out.print("password:");
		str2=buf.readLine();
		if(str1.equals(name)&&str2.equals(password)) {
			System.out.println("欢迎admin登陆！！！");
			break;
		}else if(str1.equals(name)&&!str2.equals(password)){
		 
			System.out.println("密码错误！！！您还有"+(3-flag)+"机会");
		}else if(!str1.equals(name)&&str2.equals(password)) {
			System.out.println("用户名错误！！！您还有"+(3-flag)+"机会");
		}else {
			System.out.println("用户名和密码错误！！！您还有"+(3-flag)+"机会");
		}
		
		if(flag==3) {
			System.out.println("登陆失败！！！");
			break;
		}
		}
	}
}
