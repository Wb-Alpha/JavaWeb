package com.itheima.instance.constructor;
/*
 * ʵ������ʽ����ֱ�Ӵ���Beanʵ���ķ�ʽ���������ļ��У�ͨ��factory-bean��������һ��
 * ʵ��������Ȼ��ʹ��factory-method����ȷ��ʹ�ù����е��ĸ�����
 */
public class Bean3 {
	public Bean3 createBean() {
		return new Bean3();
	}
}
