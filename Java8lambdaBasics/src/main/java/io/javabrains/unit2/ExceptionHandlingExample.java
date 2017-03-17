package io.javabrains.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int [] someNumbers = { 1, 2, 3, 4 };
		int key = 0;
		
		// nice and short. O, yeah!
		process(someNumbers, key, wrapperLambda( (i, k) -> System.out.println(i / k) ) ); 

	}

	// input: array, number, operation (lambda)
	private static void process(int[] someNumbers,
								int key,
								BiConsumer<Integer, Integer> consumer) {
		
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
		
	}
	
	// Wrapper lambda: input will be another lambda!
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		// will return another lambda  with the same type
		return (i, k) -> {
			try {
				// executing input lambda
				consumer.accept(i, k);				
			} catch (ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda.");
			}
		};
	}
	

}
