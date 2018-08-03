package pers.zx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * 根据3个班各5名学生某门课程的成绩，正确使用二维数组计算如图所示3个班各自的总成绩。
 * 在这个程序中二维数组的第一维是班级，第二维是各班级的学生，与之对应的双重循环中，
 * 外层循环i为班级，内层循环j为各班级的学生。
 *
 */
public class DoubleArray {

	public static void main(String[] args)throws IOException {
		BufferedReader buf;
	    String str;
	    int sum1=0,sum2=0,sum3=0;
	    buf=new BufferedReader(new InputStreamReader(System.in));
	    int[][] array=new int[3][5];
	    for(int i=0;i<3;i++) {//班级数
	    	if(i==0) {
	    		System.out.println("请输入一班的成绩:");
	    	}else if(i==1) {
	    		System.out.println("\n"+"请输入二班的成绩:");
	    	}else {
	    		System.out.println("\n"+"请输入三班的成绩:");
	    	}
	    	for(int j=0;j<5;j++) {//学生成绩
	    		System.out.print("请输入第"+(j+1)+"个学生的成绩：");
	    		str=buf.readLine();
	    		array[i][j]=Integer.parseInt(str);
	    		if(i==0) {
	    			sum1+=array[i][j];
	    		}
	    		if(i==1) {
	    			sum2+=array[i][j];
	    		}
	    		if(i==2) {
	    			sum3+=array[i][j];
	    		}
	    	}
	    }
	    System.out.println("总成绩：");
	    System.out.println("一班："+sum1);
	    System.out.println("二班："+sum2);
	    System.out.println("三班："+sum3);
	    
	    
	}
}
