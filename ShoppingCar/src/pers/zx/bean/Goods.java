package pers.zx.bean;

public class Goods {

	private Integer g_id;//商品id
	private String g_name;//商品名称
	private float g_charge;//商品单价
	private Integer g_num;//购物车中商品的数量
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Goods(Integer g_id, String g_name, float g_charge, Integer g_num) {
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_charge = g_charge;
		this.g_num = g_num;
	}



	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public float getG_charge() {
		return g_charge;
	}
	public void setG_charge(float g_charge) {
		this.g_charge = g_charge;
	}
	public Integer getG_num() {
		return g_num;
	}
	public void setG_num(Integer g_num) {
		this.g_num = g_num;
	}
	
	
}
