package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Exercise {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(            // this method takes bunch of objects and gives List of them
					new Person("Luke","Skywalker", 25),
					new Person("Han","Solo", 35),
					new Person("Lea","Organa", 25),
					new Person("Darh","Vader", 50),
					new Person("Emperor","Palpatine", 75)
				);
		
		
		System.out.println(people);
		

		
		/* Try both Java 7 and Java 8 approaches */
		
		/* Step 1: Sort list by last name */
		
			// Java 7 style
			Collections.sort(people, new Comparator<Person>() {
	
				@Override
				public int compare(Person o1, Person o2) {
					return 	o1.getLastName().compareTo(o2.getLastName());
				}
				
			});
			
			System.out.println(people);
			
			// Java 8 style (sorting by first name here)
			Collections.sort(people, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
			System.out.println(people);
			System.out.println("");
		
		/* Step 2: Create a method that prints all elements in the list */
		
			// Java 7 style
			System.out.println("--- Printing all persons.");
			printPersonJava7(people);
			System.out.println("");
			
			// Java 8 style
			Nike printingLambda = (p) -> {
				for (Person person : p) {
					System.out.println(person);
				}			
			};
			
			printingLambda.justDoIt(people);
			System.out.println("");
		
		
		/* Step 3: Create a method that prints all people that have last name beginning with S */

			// Java 7 style
			System.out.println("--- Printing all persons with last name begginig with S.");
			printConditionally(people, new Condition() {   // method should take behaviour!
				@Override
				public boolean test(Person p) {
					return p.getLastName().startsWith("S");
				}    
			});      
			System.out.println("");
			
			// Java 8 style. Here we can re-use our functional interface Nike!
			Nike lambdaPrintsAllS = (p) -> {
				for (Person person : p) {
					if (person.getLastName().startsWith("S")) {
						System.out.println(person);
					}
				}		
			};
			lambdaPrintsAllS.justDoIt(people);
			
	}
	
	interface Condition {
		boolean test(Person p);
	}
	
	private static void printConditionally (List<Person> people, Condition condition) {
		for (Person person : people) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}
	}

	interface Nike {
		void justDoIt(List<Person> people);
	}

	private static void printPersonJava7(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}

}
