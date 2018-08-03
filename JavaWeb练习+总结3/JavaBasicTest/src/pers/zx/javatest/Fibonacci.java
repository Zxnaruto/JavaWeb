package pers.zx.javatest;

/**
 * @author zx
 * 
 * 菲波那契数列输出前十个数
 * 通项公式： f1=0
 *           f2=1
 *           fn=fn-1+fn-2 n>=3;
 */
public class Fibonacci {

	public static void main(String[] args) {
		int max=10;
		int i=1,j=1,k=1;
		while(k<=max) {
			System.out.print(" "+i+" "+j);
			i=i+j;
			j=i+j;
			k=k+2;
		}
		
		
	}
}
