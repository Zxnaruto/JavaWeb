package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 
 * 冒泡排序：按照大小从上往下（从下往上）相邻的比较，在交换位置，每一轮排好一个数，
 * 循环次数为n-1。  
 */
public class BubbleSort {

	public static void main(String[] args)throws IOException {
		String str;
		int temp;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int[] array=new int[5];
		System.out.println("请随机输入5个数：");
		for(int i=0;i<5;i++) {
			str=buf.readLine();
			array[i]=Integer.parseInt(str);
		}
		System.out.println("输入的五个数为");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		//冒泡排序
		for(int i=0;i<array.length-1;i++) {//外层控制总次数
			for(int j=0;j<array.length-1-i;j++) {//内层数值比较
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
		System.out.println("\n"+"结果显示：");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
}
