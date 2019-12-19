package BuyingCar;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	public Book(String name,String id) {
		this.id = id;
		this.name = name;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String ID) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
