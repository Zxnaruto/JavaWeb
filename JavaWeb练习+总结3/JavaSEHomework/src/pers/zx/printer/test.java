package pers.zx.printer;

public class test {

	public static void main(String[] args) {
		DoMatriPrinter doMatriPrinter = new DoMatriPrinter();//��ʽ
		InkperPrinter inkperPrinter = new InkperPrinter();//��ī
		LaserPrinter laserPrinter = new LaserPrinter();//����
		
		doMatriPrinter.print();
		inkperPrinter.print();
		laserPrinter.print();
		
	}
}
