package com.ddb.demo.lambda.stream;

import com.ddb.demo.model.People;
import com.ddb.demo.repository.PeoppleRepository;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * stream的修改
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyLambdaStream {

    @Autowired
    private PeoppleRepository peoppleRepository;

    @Test
    public void Mytest() {
        //
        DoubleStream doubleStream = DoubleStream.of(1, 2, 3, 4);
        LongStream range = LongStream.range(0, 10);
        IntStream of = IntStream.range(0, 10);
//		of.forEachOrdered(System.out::println);
        List<Integer> numbers = Arrays.asList(1, 8, 10, 12, 11, 9, 2, 3, 2, 5, 6, 8, 6, 9);
        //筛选没有重复的偶数
        //forEachOrdered表示按照集合元素的顺序输出
        //forEach这个就是各异步的,顺序是乱的
        //要给输出的数字按大小排序,sorted
        String s1 = numbers.stream().filter(s -> s % 2 == 0).sorted().collect(Collectors.toList()).toString();
        String s2 = numbers.stream().filter(s -> s % 2 == 0).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).toString();
        System.err.println(s1);
        System.err.println(s2);
        //截断流limit和skip
        System.out.println("-----------------------------");
        System.out.println(numbers.toString());
        //只输出前三个
        String sss = numbers.stream().limit(3).collect(Collectors.toList()).toString();
        System.err.println(sss);
        //输出第3个以后的元素
        String ss = numbers.stream().skip(3).collect(Collectors.toList()).toString();
        System.err.println(ss);
        System.out.println("-----------------------------");
        //查询people数据列表
        List<People> list = peoppleRepository.findAll();
        if (CollectionUtils.isNotEmpty(list)) {
            //根据年龄正反排序
            long count = list.stream().sorted(Comparator.comparing(People::getAge).reversed()).collect(Collectors.toList())
                    .stream().peek(s -> System.err.println(s.toString())).count();
            System.err.println("------------------------");
            System.err.println(count);
            System.err.println("------------------------");
            long coun = list.stream().sorted(Comparator.comparing(People::getAge))
                    .peek(s -> System.err.println(s.toString())).count();
            System.err.println(coun);
            //
            Optional<People> any = list.stream().findAny();
            System.err.println(any.isPresent()?any.get():null);
            Optional<People> first = list.stream().findFirst();
            System.err.println(first.isPresent()?first.get():null);

            boolean jack = list.stream().anyMatch(d -> d.getUsername().equals("jack"));
            boolean jack1 = list.stream().noneMatch(d -> d.getUsername().equals("jack"));
            boolean jack2 = list.stream().allMatch(d -> d.getUsername().equals("jack"));
            System.err.println(jack);
            System.err.println(jack1);
            System.err.println(jack2);
            if(jack){
                System.err.println("I'm jack?");
            }
            if(jack1){
                System.err.println("I'm jack1?");
            }
            if(jack2){
                System.err.println("I'm jack2?");
            }
        }
        //
    }
}
