package com;

import com.dao.Axe;
import com.dao.impl.StealAxe;
import com.proxy.AxeProxyCglib;
import com.proxy.AxeProxyJdk;

public class Test {
	public static void main(String[] args) {
		AxeProxyJdk apj = new AxeProxyJdk();
		Axe axe = new StealAxe();
		Axe axe1 = (Axe)apj.createProxy(axe);
		
		axe1.chop();
		
		
		//测试CGLIB代理增加方法的效果
		AxeProxyCglib axeProCglib = new AxeProxyCglib();
		StealAxe sa = new StealAxe();
		StealAxe sa1 = (StealAxe)axeProCglib.createProxy(sa);
		
		//执行方法
		sa1.chop();
	}
}
