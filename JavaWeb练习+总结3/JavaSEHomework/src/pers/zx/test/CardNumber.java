package pers.zx.test;

import java.util.Scanner;

/**
 * @author zx
 * ʹ��Scanner��ü���������λ���ֵĻ�Ա���ţ�
 * �ֱ�ʹ�á�/���͡�%��������ֽ��û�Ա����λ�ϵ����֣���󽫸�λ��������Ͳ����
 *
 */
public class CardNumber {
  public static void main(String[] args) {
	  @SuppressWarnings("resource")
	Scanner reader=new Scanner(System.in);
	  int cardnumber;
	  System.out.print("������һ����Ա���ţ���λ������");
      cardnumber=reader.nextInt();
      
      int one=cardnumber%10;//��λ
      int ten=cardnumber%100/10;//ʮλ
      int hud=cardnumber/100%10;
      int thou=cardnumber/1000;//ǧλ
      
      System.out.print("\n"+"�ָ�����"+"\n");
      System.out.print("��λ��"+one+" ʮλ��"+ten+" ��λ��"+hud+" ǧλ��"+thou);
      System.out.print("\n"+"�ͣ�"+(one+ten+hud+thou));
  }
}
