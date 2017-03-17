package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.Person;

public class MethodReferenceExample2 {
	
	public static void main(String[] args) {

		List<Person> people = Arrays.asList(            // this method takes bunch of objects and gives List of them
				new Person("Luke","Skywalker", 25),
				new Person("Han","Solo", 35),
				new Person("Lea","Organa", 25),
				new Person("Darh","Vader", 50),
				new Person("Emperor","Palpatine", 75)
			);
		
		// Method reference instead of lambda 'p -> method(p)' where 'Consumer' functional interface
		performConditionally(people, p -> true, System.out::println); 

	}
	
	
	/* We will pass in the method
	 * 	- consumer  : action - what to do
	 * 	- predicate : in what condition */
	private static void performConditionally (List<Person> people,
			                                  Predicate<Person> predicate,
			                                  Consumer<Person> consumer) {
		for (Person person : people) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}

}
