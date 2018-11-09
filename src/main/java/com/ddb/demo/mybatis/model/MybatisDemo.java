package com.ddb.demo.mybatis.model;


public class MybatisDemo {

	private String id;
	private String username;
	private String age;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MybatisDemo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MybatisDemo(String id, String username, String age, String address) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.address = address;
	}
	
}

