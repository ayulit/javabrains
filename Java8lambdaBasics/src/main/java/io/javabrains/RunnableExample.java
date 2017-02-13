package io.javabrains;

public class RunnableExample {

	public static void main(String[] args) {
		
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
				
			}
		});
		
		myThread.run();
		
		/* Simple inline lambda -
		 * it's OK because Runnable has only one method */
		Thread myLambdaThread = new Thread(()->System.out.println("Printed inside Lambda Runnable"));
		myLambdaThread.run();
		
	}

}
