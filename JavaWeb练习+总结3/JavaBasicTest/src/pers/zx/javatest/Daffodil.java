package pers.zx.javatest;

/**
 * @author zx
 * ˮ�ɻ���100-1000
 *"ˮ�ɻ���"��ָһ����λ�������λ���������͵��ڸ�������
 */
public class Daffodil {

	public static void main(String[] args) {
		int one;//��λ
		int ten;//ʮλ
		int hunderd;//��λ
		System.out.println("ˮ�ɻ���Ϊ��");
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
