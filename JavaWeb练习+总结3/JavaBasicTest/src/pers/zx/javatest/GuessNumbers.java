package pers.zx.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author zx
 * 编写程序，实现猜数小游戏。随机生成一个0~99（包括0和99）的数字，从控制台输入猜测的数字，输出提示太大还是太小，
 * 继续猜测，直到猜到为止，游戏过程中，记录猜对所需的次数，游戏结束后公布结果。
 *
 */
public class GuessNumbers {

	public static void main(String[] args) throws IOException {
		String str;
		BufferedReader buf;
		int sum=0;//猜的次数
		int in;//输入的数
		buf=new BufferedReader(new InputStreamReader(System.in));
		Random ran=new Random();
		int guess=Math.abs(ran.nextInt()%100);//0~99非负数
		System.out.print("答案："+guess+"\n");
	
		while(true) {
		System.out.print("请输入所猜的数字：");
		str=buf.readLine();
		 in=Integer.parseInt(str);
			sum++;
			if(in==guess&&sum==1) {
				System.out.println("你太聪明了");
				System.out.print("答案："+guess);
				break;
			}
			if(in==guess&&(sum<=5&&sum>=2)) {
				System.out.println("再接再厉");
				System.out.print("答案："+guess);
				break;
			}
			if(in==guess&&sum>=6) {
				System.out.println("要努力");
				System.out.print("答案："+guess);
				break;
			}
		
		}
	}
	}


