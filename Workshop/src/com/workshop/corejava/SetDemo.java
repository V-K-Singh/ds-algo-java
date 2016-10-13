package com.workshop.corejava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set<Employee> set = new HashSet<>();
		Employee emp1 = new Employee(10, "ABC", 20);
		Employee emp2 = new Employee(20, "DEF", 30);
		set.add(emp1);
		set.add(emp2);
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
	}

}
