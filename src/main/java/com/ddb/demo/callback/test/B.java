package com.ddb.demo.callback.test;

/**
 * @author Administrator
 *	回调函数
 */
public class B {

	public void pub(CallBack a) {
		//帮助A解决问题的逻辑代码
		
		System.err.println("B帮助A解决问题");
		for (long i = -1000000000; i <1000000000;i++ ) {
			for (int j = -1000; j < 100000; j++) {
			}
		}
		
		//问题结局之后去通知A
		a.solu();
	}
	
}
