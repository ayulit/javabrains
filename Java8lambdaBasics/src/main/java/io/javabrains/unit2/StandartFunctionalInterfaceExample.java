package io.javabrains.unit2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.Person;

public class StandartFunctionalInterfaceExample {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(            // this method takes bunch of objects and gives List of them
				new Person("Luke","Skywalker", 25),
				new Person("Han","Solo", 35),
				new Person("Lea","Organa", 25),
				new Person("Darh","Vader", 50),
				new Person("Emperor","Palpatine", 75)
			);
		
		performConditionally(people, p -> true, p -> System.out.println(p));

	}
	
	
	/* We will pass in the method
	 * 	- what to do
	 * 	- in what contdition */
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
