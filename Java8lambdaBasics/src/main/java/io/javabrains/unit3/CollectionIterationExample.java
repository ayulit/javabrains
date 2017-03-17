package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;

import io.javabrains.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(            // this method takes bunch of objects and gives List of them
				new Person("Luke","Skywalker", 25),
				new Person("Han","Solo", 35),
				new Person("Lea","Organa", 25),
				new Person("Darh","Vader", 50),
				new Person("Emperor","Palpatine", 75)
			);
		
		/* External iterators */
		
		System.out.println("Using for loop");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("\nUsing for-in loop");
		for (Person p : people) {
			System.out.println(p);
		}
		
		/* Internal iterators featured Java 8 */
		
		System.out.println("\nUsing Java 8 lambda for-each");
		// super-easy to read!
		people.forEach(p -> System.out.println(p));
	
		System.out.println("\nUsing Java 8 lambda for-each: Method reference");
		// we can use '::' instead of lambda, because it's a Consumer
		people.forEach(System.out::println);
		
	}

}
