package com.proxy;

import java.lang.reflect.*;
import com.dao.*;
import com.aspect.*;

public class AxeProxyJdk implements InvocationHandler{
	private Axe axe;
	
	public Object createProxy(Axe axe) {
		this.axe = axe;
		ClassLoader cl = AxeProxyJdk.class.getClassLoader();
		Class<?>[] classes = axe.getClass().getInterfaces();
		return Proxy.newProxyInstance(cl, classes, this);
	}
	
	@Override
	public Object invoke(Object proxy, Method m, Object[] arg) throws Throwable {
		// TODO Auto-generated method stub
		ToolUpkeep tuk = new ToolUpkeep();
		tuk.grind();
		Object obj = m.invoke(axe,arg);
		
		tuk.repair();
		return obj;
	}

}
