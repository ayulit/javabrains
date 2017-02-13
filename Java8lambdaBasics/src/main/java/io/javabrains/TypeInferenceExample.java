package io.javabrains;

public class TypeInferenceExample {

	public static void main(String[] args) {

		// very compact way to write		
		printLambda(s -> s.length());

	}
	
	public static void printLambda(StringLenghtLambda l) {
		System.out.println(l.getLength("Hello Lambda"));
	}
	
	
	interface StringLenghtLambda {
		int getLength(String s);
	}

}
