package io.javabrains;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting(); 
		
		// passing behavior
		greeter.greet(helloWorldGreeting);

	}

}
