package cn.com.chnsys.pojo;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * ���л�ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * �û�ID
	 */
	private Integer id;
	/**
	 * �û�����
	 */
	private String name;
	private String pwd;
	/**
	 * �û�����
	 */
	private int age;
	/**
	 * �û��ֻ��
	 */
	private String phone;
	public User() {
		super();
	}
	public User(Integer id, String name, String pwd ,int age, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age=" + age + ", phone=" + phone + "]";
	}
}
