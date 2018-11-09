package com.ddb.demo.annotation.definition;

import java.lang.reflect.Field;

/**
 * 注解处理器
 */
public class FruitInfoUtils {

	//定义一个静态方以便于使用main测试代码
	public static void getFruitInfo(Class<?> clazz) {//实测这里只能使用?不能使用T
		//使用传进来的对象反射获取
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitNmae.class)) {
				FruitNmae fruitNmae = field.getAnnotation(FruitNmae.class);
				System.err.println(fruitNmae.name());
			}else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				System.err.println(fruitColor.fColor());
			}else if (field.isAnnotationPresent(FruitFrom.class)) {
				FruitFrom fruitFrom = field.getAnnotation(FruitFrom.class);
				System.err.println(fruitFrom.id()+" @ "+fruitFrom.country()+" @ "+fruitFrom.address());
			}
		}
	}
}
