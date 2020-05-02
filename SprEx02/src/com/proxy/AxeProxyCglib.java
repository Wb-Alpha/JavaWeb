package com.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.aspect.ToolUpkeep;

//CGLIB代理类
public class AxeProxyCglib implements MethodInterceptor{
	
	public Object createProxy(Object target) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object proxy, Method m, Object[] arg, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		ToolUpkeep tuk = new ToolUpkeep();
		tuk.grind();
		
		Object obj = methodProxy.invokeSuper(proxy, arg);
		
		tuk.repair();
		return obj;
	}
	
}
