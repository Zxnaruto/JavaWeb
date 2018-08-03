package pers.zx.javatest;

/**
 * @author zx
 * 水仙花数100-1000
 *"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 */
public class Daffodil {

	public static void main(String[] args) {
		int one;//个位
		int ten;//十位
		int hunderd;//百位
		System.out.println("水仙花数为：");
		for(int i=100;i<1000;i++) {
			one=i%10;
			ten=i%100/10;
			hunderd=i/100;
			if((one*one*one+ten*ten*ten+hunderd*hunderd*hunderd)==i) {
				System.out.print(i+" ");
			}
		}
	}
}
