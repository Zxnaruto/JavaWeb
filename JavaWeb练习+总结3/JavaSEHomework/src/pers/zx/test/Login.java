package pers.zx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 
 * ģ���¼,�����λ���,����ʾ���м��λ���
��1�������û����������Ϊadmin�����������ȷ������̨�������ӭadmin��¼
��2�����������󣬿���̨�����¼�����,������2�λ��ᣨ�����3�λ��ᣩ

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
		System.out.println("****    �û���½        ****");
		while(true) {
			flag++;
		System.out.print("name:");
		str1=buf.readLine();
		System.out.print("password:");
		str2=buf.readLine();
		if(str1.equals(name)&&str2.equals(password)) {
			System.out.println("��ӭadmin��½������");
			break;
		}else if(str1.equals(name)&&!str2.equals(password)){
		 
			System.out.println("������󣡣���������"+(3-flag)+"����");
		}else if(!str1.equals(name)&&str2.equals(password)) {
			System.out.println("�û������󣡣���������"+(3-flag)+"����");
		}else {
			System.out.println("�û�����������󣡣���������"+(3-flag)+"����");
		}
		
		if(flag==3) {
			System.out.println("��½ʧ�ܣ�����");
			break;
		}
		}
	}
}
