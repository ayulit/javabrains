package io.javabrains.unit3;

public class MethodReferenceExample1 {
	
	public static void main(String[] args) {
		
		printMessage();
		
		/*
		 * Let's do method in another Thread using Method Reference syntax
		 * instead of lambda, so there wil be
		 * 'MethodReferenceExample1::printMessage' === '() -> printMessage()'
		*/
		Thread t = new Thread( MethodReferenceExample1::printMessage );
		t.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}

}
