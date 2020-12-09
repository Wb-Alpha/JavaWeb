package com.tools;

import java.util.List;

public class TestTools {
	// 展示List
	public static void showList(List list) {
		for (Object obj : list) {
			System.out.println(obj.toString());
		}
	}
}
