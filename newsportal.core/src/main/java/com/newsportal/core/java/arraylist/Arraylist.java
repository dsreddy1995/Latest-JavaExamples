package com.newsportal.core.java.arraylist;

import java.util.ArrayList;

public class Arraylist {

	public static void main(String[] args) {
		ArrayList<String> arrays=new ArrayList<>();
		arrays.add("one");
		arrays.add("two");
		System.out.println(arrays);
		arrays.add(2, "three");
  for (String list:arrays) {
	  System.out.println(list);
  }
	}

}
