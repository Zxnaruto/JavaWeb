package pers.zx.test;

import java.util.Scanner;

/**
 * @author zx
 * 查询商品价格
 * 需求说明：正确使用while循环，根据“是否继续”和“商品编号”两个条件，反复查询所选商品的价格
 */
public class Shop {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		Scanner reader1=new Scanner(System.in);
		int choose;
		String str;
		System.out.println("商品信息如下：");
		System.out.print("  1.排球      2.矿泉水     3.书");
	
		while(true) {
			System.out.print("\n"+"请选择：");
			choose=reader.nextInt();
			if(choose==1) {
				System.out.print("排球   200￥");
			}
			if(choose==2) {
				System.out.print("矿泉水   2￥");
			}
			if(choose==3) {
				System.out.print("书   20￥");
			}
			System.out.print("\n"+"是否继续选择(y/n)：");
			str=reader1.nextLine();
			if(str.equals("y")) {
				continue;
			}else{
				System.out.println("退出");
				break;
			}
			
			
		}
	}
}
