package com.ddb.demo.controller;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class MyDemo {

	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		Set<Character> set1 = new TreeSet<>();
		Set<Character> set2 = new LinkedHashSet<>();
		
		String aString  = "aaasdfsadfadsfasdfqa";
		char[] charArray = aString.toCharArray();
		for (Character c : charArray) {
			set2.add(c);
			set1.add(c);
		}
	System.err.println(set.size());
	System.err.println(charArray.length);
	System.err.println(set2.toString()); 
	System.err.println(set1.toString()); 
	for (char c : set1) {
		System.out.println(c);
	}
	}


}
