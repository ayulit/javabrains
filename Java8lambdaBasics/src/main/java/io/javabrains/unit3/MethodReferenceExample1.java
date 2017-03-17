package io.javabrains.unit3;

public class MethodReferenceExample1 {
	
	public static void main(String[] args) {
		
		printMessage();
		
		/*
		 * Let's do method in another Thread using lambda
		*/
		Thread t = new Thread( () -> printMessage() );
		t.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}

}
