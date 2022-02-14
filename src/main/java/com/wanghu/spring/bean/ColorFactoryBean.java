package com.wanghu.spring.bean;


import org.springframework.beans.factory.FactoryBean;

//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

	//返回一个Color对象，这个对象会添加到容器中
	@Override
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean...getObject...");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}

	/**
	 * isSingleton():是单例吗
	 * true：这个bean是单实例，在容器中会保存一份
	 * false:多实例，每次都会创建一个新的bean
	 *
	 * 怎么去创建实例，他回去调用顶部getObject方法去创建
	 * @return
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}















//	//返回一个Color对象，这个对象会添加到容器中
//	@Override
//	public Color getObject() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("ColorFactoryBean...getObject...");
//		return new Color();
//	}
//
//	@Override
//	public Class<?> getObjectType() {
//		// TODO Auto-generated method stub
//		return Color.class;
//	}
//
//	//是单例？
//	//true：这个bean是单实例，在容器中保存一份
//	//false：多实例，每次获取都会创建一个新的bean；
//	@Override
//	public boolean isSingleton() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
