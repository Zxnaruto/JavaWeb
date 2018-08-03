package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author zx
 * 随机生成1-100内的10个数
 * 求出里面的最大最小值
 * 
 * Math.abs Random 和 打擂台法
 *
 */
public class FindMaxMinValue {
	@SuppressWarnings("unused")
	public static void main(String[] args)throws IOException {
	
		String str;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int[] array=new int[10];
		Random random=new Random();
		//产生随机数
		System.out.println("产生的十个随机数为：");
		for(int i=0;i<10;i++) {
			array[i]=Math.abs(random.nextInt()%100)+1;//1-100
			System.out.print(array[i]+" ");
		}
		
		//打擂台
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
		//结果
		System.out.print("\n"+"max="+max+"\n");
		System.out.print("min="+min);
	}
}
