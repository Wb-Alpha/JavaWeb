package BuyingCar;

import java.util.*;

public class BookDB {
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static {
		books.put("1", new Book("1","JavaWeb����"));
		books.put("2", new Book("2","����ԭ��"));
		books.put("3", new Book("3","΢�ͼ����"));
		books.put("4", new Book("4","����ϵͳ"));
		books.put("5", new Book("5","�˹����������ѧϰ"));
	}
	
	//��ȡ����ͼ��
	public static Collection<Book> getAll(){
		return books.values();
	}
	
	//����ָ����id���ͼ��
	public static Book getBook(String id) {
		return books.get(id);
	}
}
