package com.po;
  
public class User { 
	private String UserId;
	private String UserName;
	private String password; 
	private String tel; 
	private String prems; 
	public String getUserId() { return UserId; } 
	public void setUserId(String userId) { UserId = userId; } 
	public String getUserName() { return UserName; } 
	public void setUserName(String userName) { UserName = userName; } 
	public String getPassword() { return password; } 
	public void setPassword(String password) {this.password = password; } 
	public String getTel() { return tel; } 
	public void setTel(String tel) { this.tel = tel; } 
	public String getPrems() { return prems; } 
	public void setPrems(String prems) { this.prems = prems; }
}
 