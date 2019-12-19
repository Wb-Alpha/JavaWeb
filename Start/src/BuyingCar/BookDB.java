package BuyingCar;

import java.util.*;

public class BookDB {
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static {
		books.put("1", new Book("1","JavaWeb开发"));
		books.put("2", new Book("2","编译原理"));
		books.put("3", new Book("3","微型计算机"));
		books.put("4", new Book("4","操作系统"));
		books.put("5", new Book("5","人工智能与机器学习"));
	}
	
	//获取所有图书
	public static Collection<Book> getAll(){
		return books.values();
	}
	
	//根据指定的id获得图书
	public static Book getBook(String id) {
		return books.get(id);
	}
}
