package com.newsportal.core.java.learning;

public class Address extends Person {
	
	public String name="world";
	public String word="java";
	
	public void superWord() {
		System.out.println(super.name);
		System.out.println(name);
		super.personVariable();
		instance();
	}
	
	public static void instance() {
		
		System.out.println("instance method");
	}
   
}
