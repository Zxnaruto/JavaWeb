package pers.zx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * ѭ��¼��ĳѧ��5�ſεĳɼ�������ƽ���֣����ĳ����¼��Ϊ����ʹ��break���ֹͣ¼�룬����ʾ¼�����
 *
 */
public class Break {

	@SuppressWarnings("unused")
	public static void main(String[] args)throws IOException {
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		String str,str1;
		int i=0;
		int score;
		System.out.print("������ѧ��������");
		str=buf.readLine();
		System.out.println();
		System.out.println("��¼��ѧ���ɼ���");
		while(true) {
			i++;
		System.out.print("�������"+i+"�ſγɼ���");
		str1=buf.readLine();
		score=Integer.parseInt(str1);
		if(score<0||score>100) {
			System.out.println("������������������");
			i--;
			continue;
		}
		if(i==5) {
			System.out.println("�������");
			break;
		}
		}
	}
}
