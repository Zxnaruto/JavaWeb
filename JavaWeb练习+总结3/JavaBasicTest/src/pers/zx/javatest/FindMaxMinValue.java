package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author zx
 * �������1-100�ڵ�10����
 * �������������Сֵ
 * 
 * Math.abs Random �� ����̨��
 *
 */
public class FindMaxMinValue {
	@SuppressWarnings("unused")
	public static void main(String[] args)throws IOException {
	
		String str;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int[] array=new int[10];
		Random random=new Random();
		//���������
		System.out.println("������ʮ�������Ϊ��");
		for(int i=0;i<10;i++) {
			array[i]=Math.abs(random.nextInt()%100)+1;//1-100
			System.out.print(array[i]+" ");
		}
		
		//����̨
		int max=array[0];
		int min=array[0];
		for(int i=1;i<10;i++) {
			if(array[i]>max) {
				max=array[i];
			}
			
			if(array[i]<min) {
				min=array[i];
			}
		}
		//���
		System.out.print("\n"+"max="+max+"\n");
		System.out.print("min="+min);
	}
}
