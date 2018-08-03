package pers.zx.car;

public class Bicycle {

	protected int Lnumbers;//轮子数
	protected String Color;//颜色
	
	public void Brun(int lnumber,String color) {
		this.Lnumbers=lnumber;
		this.Color=color;
		System.out.println(Lnumbers+"个轮子"+Color+"的车瞪着跑");
	}
	
}
