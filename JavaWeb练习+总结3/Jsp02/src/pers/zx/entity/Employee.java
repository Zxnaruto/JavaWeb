package pers.zx.entity;
//�ѱ�����������������ķ�ʽ���ã������ݷŵ�������
public class Employee {

	private Integer emp_id;
	private String emp_name;
	private Integer emp_age;
	private Double emp_salary;
	
	public Employee() {
		
	}
	//atl+shift+s construts  
	public Employee(Integer emp_id, String emp_name, Integer emp_age, Double emp_salary) {
		/*super();*/
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.emp_salary = emp_salary;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Integer getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(Integer emp_age) {
		this.emp_age = emp_age;
	}
	public Double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}
	//��дtoString,�����ڴ���������������ݿ�������ݣ��������@............(��ַ)
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return emp_id+" "+emp_name+" "+emp_age+" "+emp_salary;
	}
	
	
}
