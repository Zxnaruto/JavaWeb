package pers.zx.test;

/**
 * @author zx
 * 
 * 实现两个数据交换
 * 使用变量以及赋值运算符实现两个int类型数据num1和num2的交换，交换前后的结果如图所示。
 */
public class DataChange {

	public static void main(String[] args) {
		int num1=5;
		int num2=6;
		System.out.print("交换前："+" num1="+num1+" num2="+num2);
		int temp;
		temp=num1;
		num1=num2;
		num2=temp;
		System.out.print("\n"+"交换后结果："+" num1="+num1+" num2="+num2);
	}
}
