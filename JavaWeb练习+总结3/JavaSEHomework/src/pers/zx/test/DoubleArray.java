package pers.zx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zx
 * ����3�����5��ѧ��ĳ�ſγ̵ĳɼ�����ȷʹ�ö�ά���������ͼ��ʾ3������Ե��ܳɼ���
 * ����������ж�ά����ĵ�һά�ǰ༶���ڶ�ά�Ǹ��༶��ѧ������֮��Ӧ��˫��ѭ���У�
 * ���ѭ��iΪ�༶���ڲ�ѭ��jΪ���༶��ѧ����
 *
 */
public class DoubleArray {

	public static void main(String[] args)throws IOException {
		BufferedReader buf;
	    String str;
	    int sum1=0,sum2=0,sum3=0;
	    buf=new BufferedReader(new InputStreamReader(System.in));
	    int[][] array=new int[3][5];
	    for(int i=0;i<3;i++) {//�༶��
	    	if(i==0) {
	    		System.out.println("������һ��ĳɼ�:");
	    	}else if(i==1) {
	    		System.out.println("\n"+"���������ĳɼ�:");
	    	}else {
	    		System.out.println("\n"+"����������ĳɼ�:");
	    	}
	    	for(int j=0;j<5;j++) {//ѧ���ɼ�
	    		System.out.print("�������"+(j+1)+"��ѧ���ĳɼ���");
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
	    System.out.println("�ܳɼ���");
	    System.out.println("һ�ࣺ"+sum1);
	    System.out.println("���ࣺ"+sum2);
	    System.out.println("���ࣺ"+sum3);
	    
	    
	}
}
