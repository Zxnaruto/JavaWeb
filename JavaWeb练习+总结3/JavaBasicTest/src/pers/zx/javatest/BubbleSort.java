package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 
 * ð�����򣺰��մ�С�������£��������ϣ����ڵıȽϣ��ڽ���λ�ã�ÿһ���ź�һ������
 * ѭ������Ϊn-1��  
 */
public class BubbleSort {

	public static void main(String[] args)throws IOException {
		String str;
		int temp;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int[] array=new int[5];
		System.out.println("���������5������");
		for(int i=0;i<5;i++) {
			str=buf.readLine();
			array[i]=Integer.parseInt(str);
		}
		System.out.println("����������Ϊ");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		//ð������
		for(int i=0;i<array.length-1;i++) {//�������ܴ���
			for(int j=0;j<array.length-1-i;j++) {//�ڲ���ֵ�Ƚ�
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
		System.out.println("\n"+"�����ʾ��");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
}
