package com.ddb.demo.annotation.model;

import com.ddb.demo.annotation.definition.FruitColor;
import com.ddb.demo.annotation.definition.FruitFrom;
import com.ddb.demo.annotation.definition.FruitInfoUtils;
import com.ddb.demo.annotation.definition.FruitNmae;

public class Fruit {

	@FruitNmae(name = "香蕉")
	private String fruitName;
	// 有默认值--yellow
	@FruitColor
	private String fruitColor;
	// 有默认值--中国贵阳
	@FruitFrom(id = 1)
	private String fruitFrom;

	private void getFruitInfo() {
		System.err.println("水果名称: " + this.fruitName);
		System.err.println("水果颜色: " + this.fruitColor);
		System.err.println("水果产地: " + this.fruitFrom);
	}

	// getter,setter
	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitColor() {
		return fruitColor;
	}

	public void setFruitColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}

	public String getFruitFrom() {
		return fruitFrom;
	}

	public void setFruitFrom(String fruitFrom) {
		this.fruitFrom = fruitFrom;
	}

	public Fruit() {
		super();
		// 实例化就调用此方法
		getFruitInfo();
	}

	// =-------------------------------------------------------------------------------------------------
	// 测试注解---------------->记得添加注解哦
	public static void main(String[] args) {
		FruitInfoUtils.getFruitInfo(Fruit.class);
		System.err.println("-----------");
		Fruit fruit = new Fruit();
		System.err.println("-----------");
		System.err.println(fruit.fruitName + "@@" + fruit.fruitColor + "&&" + fruit.fruitFrom);
	}
	// 香蕉
	// YELLOW
	// 1 @ 中国 @ 贵阳
	// -----------
	// 水果名称: null
	// 水果颜色: null
	// 水果产地: null
	// -----------
	// null@@null&&null
}
