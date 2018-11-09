package com.ddb.demo.callback.mytest;

/**
 * @author Administrator 拥有回调函数,含有主要逻辑业务的一方
 */
public class Wang {
	
	// 开启线程异步调用Li中需要时间处理业务的方法
	public static void askQuestion() {
		Li li = new Li();
		//开启线程---------->亲,是开启线程,不是线程的业务,而且线程是需要开启的---------->错误的代码
//**************************************************************************************************************
//		new Runnable() {
//			@Override
//			public void run() {
//				//开启的线程的处理的逻辑业务----->相当于同一个工作之前是一个人做,先分给两个人,
//				//各做各的,每开启一个线程就是添加一个人来分担工作
//				//调用Li来回答问题
//				li.returnMessages(new Wang(), "亲爱的Li,请问天有多高,地有多大?");
//			}
//		};
//**************************************************************************************************************
		//开启线程的正确姿势
		new Thread(new Runnable() {
			@Override
			public void run() {
				//开启的线程的处理的逻辑业务----->相当于同一个工作之前是一个人做,先分给两个人,
				//各做各的,每开启一个线程就是添加一个人来分担工作
				//调用Li来回答问题
				System.err.println("Wang:已经向Li咨询了问题--->天有多高,地有多大");
				li.returnMessages(new Wang(), "亲爱的Li,请问天有多高,地有多大?");
			}
		} ).start();//------------------>开辟线程,并启动
//--------------------------------------------------------------------------------------------------------------
		
		//干其他事
		pub();
		name();
	}
	
	//Wang其他的不需要等待的其他业务--->比如玩游戏,做作业等
	private static void pub() {
		System.err.println("Wang:我要做完老师发的所有试卷");
	}
	
	public static void name() {
		System.err.println("Wang:玩几场好玩的游戏");
	}
	
	//回调函数,Li用来告诉Wang答案的方法
	public void result(String result) {
		System.err.println("Li的答案是:"+result);
	}
	
	//测试代码------->运行Wang的代码
	public static void main(String[] args) {
		askQuestion();
	}
}
