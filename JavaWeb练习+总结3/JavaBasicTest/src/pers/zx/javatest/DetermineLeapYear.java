package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 
 * �ж��Ƿ�������
 * ��1���ܱ�4���������ܱ�100����
     ��2���ܱ�400����
 *
 */
public class DetermineLeapYear {

	public static boolean year() throws IOException {
		String str;
		BufferedReader buf;
		boolean flag=true;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������һ����ݣ�");
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
		
		System.out.println("�����"+DetermineLeapYear.year());
	}
}
