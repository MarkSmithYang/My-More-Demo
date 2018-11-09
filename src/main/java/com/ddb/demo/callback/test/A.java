package com.ddb.demo.callback.test;

public class A implements CallBack{

	B b = new B();
	
	/* 
	 * 响应回调函数的实现
	 */
	@Override
	public void solu() {
		System.err.println("问题已经被解决");
	}

	/**
	 * 登记回调函数 
	 */
	public void name() {
		System.err.println("叫b去解决问题");
		
		/**
		 * 做自己的事情
		 */
		
//		new  Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.err.println("A去做自己想做的事情");
//			}
//		}).start();;
		
		System.err.println("A去做自己想做的事情");
		
		//b.pub(this);this这里指的是类A的对象
		this.b.pub(this);//----------------------------------->这点有问题,这个调用应该是在线程里的,而不是最下面,这样的话,还是同步回调,还是需要等待
		System.err.println("我想要的效果");
	}
	
	/**
	 * @param args
	 * 测试回调
	 */
	public static void main(String[] args) {
		A a = new A();
		a.name();
	}
}
