package pers.zx.bean;

public class Person {

	private Integer Pid;
	private String Pname;
	private String password;
	private String Lname;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Pid+" "+Pname+" "+Lname+" "+password;
	}
	public Person() {
		
		// TODO Auto-generated constructor stub
	}
	public Person(Integer pid, String pname, String password, String lname) {
		super();
		Pid = pid;
		Pname = pname;
		this.password = password;
		Lname = lname;
	}
	public Integer getPid() {
		return Pid;
	}
	public void setPid(Integer pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	
	
	
}
