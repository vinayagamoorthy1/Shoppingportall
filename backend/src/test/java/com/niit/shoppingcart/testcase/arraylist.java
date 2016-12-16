package com.niit.shoppingcart.testcase;

import java.util.ArrayList;
import java.util.List;

public class arraylist {
	public static void main(String args[]){
List<Object> ab =new ArrayList <Object> ();
ab.add(0,"raja");
ab.add(0,"ramu");
ab.add(0,"raman");

System.err.println(ab.indexOf("ramu"));
for(Object a: ab){
	System.out.println(a);
}
	}
}
