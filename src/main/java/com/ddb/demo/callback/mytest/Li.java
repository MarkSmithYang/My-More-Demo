package com.ddb.demo.callback.mytest;

/**
 * @author Administrator
 *	解决问题需要时间的一方
 */
public class Li {

	//接收问题,解决问题,返回结果的方法
	public void returnMessages(Wang wang,String question){
		//模拟需要很长时间处理业务
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 10000; k++) {
					for (int l = 0; l < 100; l++) {
						
					}
				}
			}
		}
		//假如问题是天有多高,地有多大--------->知道问题的答案了,告诉Wang结果
		wang.result("天要多高就有多高,地再大也没有人的想象大");
	}
}
