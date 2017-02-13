package io.javabrains;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		// way 1: class-implementation
		Greeting helloWorldGreeting = new HelloWorldGreeting(); 
		
		// way 2: lambda expression - var of has type of interface - Java's happy :)
		Greeting lambdaGreeting = () -> System.out.println("Hello world!");
		
		// way 3: inner class
		Greeting innerClassGreating = new Greeting() {
			
			@Override
			public void perform() {
				System.out.println("Hello world!");				
			}
		};
				
		helloWorldGreeting.perform();		
		// lambda call
		lambdaGreeting.perform();
		innerClassGreating.perform();
		
		/* passing behavior */
		
		greeter.greet(helloWorldGreeting);		
		greeter.greet(lambdaGreeting);
		greeter.greet(innerClassGreating);
			
		
	}

}
