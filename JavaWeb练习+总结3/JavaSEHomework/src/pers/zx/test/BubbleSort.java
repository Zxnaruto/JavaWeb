package pers.zx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author zx
 * ð������
 *
 */
public class BubbleSort {

	public static void main(String[] args)throws IOException {
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		String str;
	    int[] array=new int[5];
	    System.out.println("�������������");
	    for(int i=0;i<5;i++) {
	    	str=buf.readLine();
	    	array[i]=Integer.parseInt(str);
	    }
	    System.out.print("\n"+"����������Ϊ��");
	    for(int i=0;i<array.length;i++)	{
	    	System.out.print(" "+array[i]);
	    }
	    
	   int temp;
	    for(int i=0;i<array.length-1;i++) {
		   for(int j=0;j<array.length-1-i;j++) {
			   if(array[j]>array[j+1]) {
				   temp=array[j];
				   array[j]=array[j+1];
				   array[j+1]=temp;
			   }
		   }
	   }
	    System.out.print("\n"+"ð�������Ľ��Ϊ��");
	    for(int i=0;i<array.length;i++) {
	    	System.out.print(array[i]+" ");
	    }
	    
	}
}
