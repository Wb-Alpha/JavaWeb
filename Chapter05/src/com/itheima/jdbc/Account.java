package com.itheima.jdbc;

public class Account {
	private Integer id;			//账户
	private String username;	//用户名
	private Double balance;	//余额
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance; 
	}
	
	public String toString() {
		return "Account [id=" + id + ","
				+ "username=" + username +
				",balance=" + balance + "]";
	}
}
