package io.javabrains.unit2;

public class ThisReferenceExample {

	public static void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public void execute() {
		// not static anymore
		doProcess(10, i -> {                           // here we have lambda
			System.out.println("Value of i is " + i);
			System.out.println(this);                  // OK with 'this', if method in which we call lambda not static
			                                           // it will be link to 'thisReferenceExample' object
		});
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		
		// System.out.println(this); // will not work inside static method!
		
		// here we have lambda
		thisReferenceExample.doProcess(10, i -> {
			
			System.out.println("Value of i is " + i);
			// System.out.println(this);  // 'this' will not work inside lambda if call inside static method
		});

		thisReferenceExample.execute();
	}
	
	public String toString() {
		return "This is the main ThisReferenceExample class instance";
	}

}
