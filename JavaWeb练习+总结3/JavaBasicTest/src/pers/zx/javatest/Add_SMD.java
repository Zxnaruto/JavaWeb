package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * ����������ʵ�ּӼ��˳�
 *
 */
public class Add_SMD {
	public static void main(String[] args) throws IOException {
		String str1,str2;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�������һ������");
		str1=buf.readLine();
		int a=Integer.parseInt(str1);
		System.out.print("������ڶ�������");
		str2=buf.readLine();
		int b=Integer.parseInt(str2);
		
		System.out.println("num1="+a);
		System.out.print("num2="+b);
		System.out.println();
		System.out.println("a+b="+ (a+b));
		System.out.println("a-b="+ (a-b));
		System.out.println("a*b="+ (a*b));
		System.out.println("a/b="+ (a/b));
		System.out.println("a%b="+ (a%b));
	}
}
