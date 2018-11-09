package com.ddb.demo.lambda.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLambda {

	public static void main(String[] args) {
		Lambda lambda=()->{int i =0;System.err.println(i);};
		lambda.run();
		//0000000000000000000000000000
		List<Student> list = new ArrayList<>();
		list.add(new Student("java", "1", 19));
		list.add(new Student("C++", "0", 22));
		list.add(new Student("Python", "3", 10));
		//通过集合获取流
		Stream<Student> stream = list.stream();
//		Stream<Student> filter = stream.filter(s->s.getAge()>18);filter.close();
		stream.filter(s->s.getAge()>18).collect(Collectors.toList()).forEach(System.out::println);;
		
		System.err.println("----------------------------------------------------------");
		Stream<Student> stream1 = list.stream();
		long count = stream1.filter(s->s.getAge()>18).map(s->{return 90;}).count();
		System.err.println(count);
		System.err.println("----------------------------------------------------------");
		
		try {
			Stream<String> lines = Files.lines(Paths.get("src/main/resources/static/学生信息模板.xlsx"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stream<String> aa = Stream.of("aa","bb","aa");
		
		Stream<String> of = Stream.of("aa","bb","aa");
		List<String> collect2 = of.distinct().collect(Collectors.toList());
		collect2.forEach(System.err::println);
		System.err.println("0000000000000000000000000000");
		int sum = Integer.sum(11, 22);//类型自带的求和功能
		System.err.println("sum="+sum);
		 Stream.iterate(0, n -> n + 2).limit(10) .forEach(System.out::println);//::方法的引用方式
		 Stream.generate(Math::random).limit(5) .forEach(System.out::println);//limit(n),执行n次遍历(操作)
		 
		 //************************************************************************
		 
	}
}
