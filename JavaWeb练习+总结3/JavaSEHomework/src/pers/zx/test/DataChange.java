package pers.zx.test;

/**
 * @author zx
 * 
 * ʵ���������ݽ���
 * ʹ�ñ����Լ���ֵ�����ʵ������int��������num1��num2�Ľ���������ǰ��Ľ����ͼ��ʾ��
 */
public class DataChange {

	public static void main(String[] args) {
		int num1=5;
		int num2=6;
		System.out.print("����ǰ��"+" num1="+num1+" num2="+num2);
		int temp;
		temp=num1;
		num1=num2;
		num2=temp;
		System.out.print("\n"+"����������"+" num1="+num1+" num2="+num2);
	}
}
