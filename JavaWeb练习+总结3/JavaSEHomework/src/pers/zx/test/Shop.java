package pers.zx.test;

import java.util.Scanner;

/**
 * @author zx
 * ��ѯ��Ʒ�۸�
 * ����˵������ȷʹ��whileѭ�������ݡ��Ƿ�������͡���Ʒ��š�����������������ѯ��ѡ��Ʒ�ļ۸�
 */
public class Shop {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		Scanner reader1=new Scanner(System.in);
		int choose;
		String str;
		System.out.println("��Ʒ��Ϣ���£�");
		System.out.print("  1.����      2.��Ȫˮ     3.��");
	
		while(true) {
			System.out.print("\n"+"��ѡ��");
			choose=reader.nextInt();
			if(choose==1) {
				System.out.print("����   200��");
			}
			if(choose==2) {
				System.out.print("��Ȫˮ   2��");
			}
			if(choose==3) {
				System.out.print("��   20��");
			}
			System.out.print("\n"+"�Ƿ����ѡ��(y/n)��");
			str=reader1.nextLine();
			if(str.equals("y")) {
				continue;
			}else{
				System.out.println("�˳�");
				break;
			}
			
			
		}
	}
}
