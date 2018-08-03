package pers.zx.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zx
 *生成10个1至100之间的随机整数(不能重复)，存入一个List集合.
 */
public class Set {

	public static void main(String[] args) {
		List<Integer>  list=new ArrayList<Integer>();
		Random random=new Random();
		for(int i=0;i<10;i++) {
			list.add(Math.abs((random.nextInt()%100))+1);
		}
		System.out.println("list里的数为：");
		for(Integer result:list) {
			System.out.print(result+" ");
		}
	}
}
