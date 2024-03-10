package com.newsportal.core.java.arraylist;

import java.util.ArrayList;

public class Adding {

	public static void main(String[] args) {
		
		ArrayList<String> arrList=new ArrayList<>();
		arrList.add("one");
		arrList.add("two");
		arrList.add("three");
		arrList.add("four");
		arrList.add("five");
		//System.out.println(arrList);
		arrList.add("six");
		//System.out.println(arrList);
		arrList.add(3, "seven");
		//System.out.println(arrList);
		arrList.remove(3);
		//System.out.println(arrList);
		arrList.set(0, "ten");
		//System.out.println(arrList);
		arrList.contains("three");
		System.out.println(arrList);
		for(String list:arrList) {
			System.out.println(list);
		}
	}

}
