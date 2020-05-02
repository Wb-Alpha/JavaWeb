package com.itheima.instance.constructor;
/*
 * 实例工厂式采用直接创建Bean实例的方式，在配置文件中，通过factory-bean属性配置一个
 * 实例工厂，然后使用factory-method属性确定使用工厂中的哪个方法
 */
public class Bean3 {
	public Bean3 createBean() {
		return new Bean3();
	}
}
