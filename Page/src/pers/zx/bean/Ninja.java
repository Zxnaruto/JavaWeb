package pers.zx.bean;

public class Ninja {
	private Integer NinjaId;
    private String NinjaName;
    private String NinjaSex;
    private Integer NinjaAge;
    private String NinjaPassword;
    private String NinjaLevel;
    
    
    
	public Ninja() {
		// TODO Auto-generated constructor stub
	}
	public Ninja(Integer ninjaId, String ninjaName, String ninjaSex, Integer ninjaAge,
			String ninjaLevel) {
		NinjaId = ninjaId;
		NinjaName = ninjaName;
		NinjaSex = ninjaSex;
		NinjaAge = ninjaAge;
		NinjaLevel = ninjaLevel;
	}
	public String getNinjaName() {
		return NinjaName;
	}
	public void setNinjaName(String ninjaName) {
		NinjaName = ninjaName;
	}
	public String getNinjaSex() {
		return NinjaSex;
	}
	public void setNinjaSex(String ninjaSex) {
		NinjaSex = ninjaSex;
	}
	public String getNinjaPassword() {
		return NinjaPassword;
	}
	public void setNinjaPassword(String ninjaPassword) {
		NinjaPassword = ninjaPassword;
	}
	public String getNinjaLevel() {
		return NinjaLevel;
	}
	public void setNinjaLevel(String ninjaLevel) {
		NinjaLevel = ninjaLevel;
	}
	public Integer getNinjaAge() {
		return NinjaAge;
	}
	public void setNinjaAge(Integer ninjaAge) {
		NinjaAge = ninjaAge;
	}
	public Integer getNinjaId() {
		return NinjaId;
	}
	public void setNinjaId(Integer ninjaId) {
		NinjaId = ninjaId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return NinjaId+" "+NinjaName+" "+NinjaSex+" "+NinjaAge+" "+NinjaLevel;
	}
}
