package pers.zx.car;

public class DianBicycle extends Bicycle{

	private boolean Dian;
	
	public void Drun(int lnumber,String color,boolean dian) {
		this.Lnumbers=lnumber;
		this.Color=color;
		this.Dian=dian;
		if(Dian==true) {
			
			  System.out.println(Lnumbers+"������"+Color+"�ĳ�������");
		}else {
			DianBicycle dianBicycle = new DianBicycle();
			dianBicycle.Brun(Lnumbers, Color);
		}
	  
	}
}
