package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import io.javabrains.Person;

public class StreamsExample1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(            // this method takes bunch of objects and gives List of them
				new Person("Luke","Skywalker", 25),
				new Person("Han","Solo", 35),
				new Person("Lea","Organa", 25),
				new Person("Darh","Vader", 50),
				new Person("Emperor","Palpatine", 75)
			);
		
		/* We need to print people whose 1st name starts with 'L' */
		people.stream()
			  .filter(p -> p.getFirstName().startsWith("L"))        // like quality control: removes from conveer!
			  .forEach(p -> System.out.println(p.getFirstName()));  // never executes on removed elements
		
		
		long count = people.stream()
		.filter(p -> p.getFirstName().startsWith("L"))        // like quality control: removes from conveer!
		.count();										      // terminal operation: just count elements
		
		System.out.println(count);
	}

}
