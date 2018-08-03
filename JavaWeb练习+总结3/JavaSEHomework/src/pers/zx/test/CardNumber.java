package pers.zx.test;

import java.util.Scanner;

/**
 * @author zx
 * 使用Scanner获得键盘输入四位数字的会员卡号，
 * 分别使用“/”和“%”运算符分解获得会员卡各位上的数字，最后将各位上数字求和并输出
 *
 */
public class CardNumber {
  public static void main(String[] args) {
	  @SuppressWarnings("resource")
	Scanner reader=new Scanner(System.in);
	  int cardnumber;
	  System.out.print("请输入一个会员卡号（四位数）：");
      cardnumber=reader.nextInt();
      
      int one=cardnumber%10;//个位
      int ten=cardnumber%100/10;//十位
      int hud=cardnumber/100%10;
      int thou=cardnumber/1000;//千位
      
      System.out.print("\n"+"分割结果："+"\n");
      System.out.print("个位："+one+" 十位："+ten+" 百位："+hud+" 千位："+thou);
      System.out.print("\n"+"和："+(one+ten+hud+thou));
  }
}
