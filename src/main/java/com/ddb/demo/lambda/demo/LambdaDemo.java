package com.ddb.demo.lambda.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaDemo {

	public static void main(String[] args) {
		 List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		 //查询C++语言
		 System.err.printf("%s","查询C++语言");
		filter(languages, (str)->str.equals("C++"));
		name();
		
		//----------------------------------------------------------------------------------------------------------
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println("Sir,can you help me?");
			}
		}).start();

		new Thread(() -> System.err.println("I'm sorry too much!")).start();
		//----------------------------------------------------------------------------------------------------------
		
		// Java 8之后：
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		//----------------------------------------------------------------------------------------------------------
		features.forEach(System.out::println);
		//----------------------------------------------------------------------------------------------------------
	}

	public static void name() {
		System.out.println("Hello Lambda Expressions");
		System.err.println("I'm sorry too much!");
	}

	// 更好的办法
	@SuppressWarnings("unchecked")
	public static void filter(List names, Predicate condition) {
		names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
			System.out.println(name + " ");
		});
	}
	
	
}
