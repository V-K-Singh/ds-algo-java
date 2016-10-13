package com.workshop.corejava;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Employee emp1 = new Employee(100,"XY",30);
		Employee emp2 = new Employee(101,"DEF",40);
		Employee emp3 = new Employee(102,"AAB",40);
		Employee emp4 = new Employee(103,"ABCD",40);
		Set treeSet = new TreeSet<>();
		treeSet.add(emp1);
		treeSet.add(emp2);
		treeSet.add(emp3);
		treeSet.add(emp4);
		System.out.println(treeSet);
		
		Set treeSet1 = new TreeSet<>(new MyComparator());
		treeSet1.add(emp1);
		treeSet1.add(emp2);
		treeSet1.add(emp3);
		treeSet1.add(emp4);
		System.out.println(treeSet1);
	}
	
}
