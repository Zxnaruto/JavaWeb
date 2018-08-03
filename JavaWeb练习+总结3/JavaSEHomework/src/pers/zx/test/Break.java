package pers.zx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 循环录入某学生5门课的成绩并计算平均分，如果某分数录入为负，使用break语句停止录入，并提示录入错误
 *
 */
public class Break {

	@SuppressWarnings("unused")
	public static void main(String[] args)throws IOException {
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		String str,str1;
		int i=0;
		int score;
		System.out.print("请输入学生姓名：");
		str=buf.readLine();
		System.out.println();
		System.out.println("请录入学生成绩：");
		while(true) {
			i++;
		System.out.print("请输入第"+i+"门课成绩：");
		str1=buf.readLine();
		score=Integer.parseInt(str1);
		if(score<0||score>100) {
			System.out.println("输入有误，请重新输入");
			i--;
			continue;
		}
		if(i==5) {
			System.out.println("输入完成");
			break;
		}
		}
	}
}
