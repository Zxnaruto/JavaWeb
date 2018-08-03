package pers.zx.printer;

public class test {

	public static void main(String[] args) {
		DoMatriPrinter doMatriPrinter = new DoMatriPrinter();//ÕëÊ½
		InkperPrinter inkperPrinter = new InkperPrinter();//ÅçÄ«
		LaserPrinter laserPrinter = new LaserPrinter();//¼¤¹â
		
		doMatriPrinter.print();
		inkperPrinter.print();
		laserPrinter.print();
		
	}
}
