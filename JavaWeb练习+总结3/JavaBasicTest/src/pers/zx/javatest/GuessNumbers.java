package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author zx
 * ��д����ʵ�ֲ���С��Ϸ���������һ��0~99������0��99�������֣��ӿ���̨����²�����֣������ʾ̫����̫С��
 * �����²⣬ֱ���µ�Ϊֹ����Ϸ�����У���¼�¶�����Ĵ�������Ϸ�����󹫲������
 *
 */
public class GuessNumbers {

	public static void main(String[] args) throws IOException {
		String str;
		BufferedReader buf;
		int sum=0;//�µĴ���
		int in;//�������
		buf=new BufferedReader(new InputStreamReader(System.in));
		Random ran=new Random();
		int guess=Math.abs(ran.nextInt()%100);//0~99�Ǹ���
		System.out.print("�𰸣�"+guess+"\n");
	
		while(true) {
		System.out.print("���������µ����֣�");
		str=buf.readLine();
		 in=Integer.parseInt(str);
			sum++;
			if(in==guess&&sum==1) {
				System.out.println("��̫������");
				System.out.print("�𰸣�"+guess);
				break;
			}
			if(in==guess&&(sum<=5&&sum>=2)) {
				System.out.println("�ٽ�����");
				System.out.print("�𰸣�"+guess);
				break;
			}
			if(in==guess&&sum>=6) {
				System.out.println("ҪŬ��");
				System.out.print("�𰸣�"+guess);
				break;
			}
		
		}
	}
	}


