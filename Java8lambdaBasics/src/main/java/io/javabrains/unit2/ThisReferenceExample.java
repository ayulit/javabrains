package io.javabrains.unit2;

public class ThisReferenceExample {

	public static void doProcess(int i, Process p) {
		p.process(i);
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		
		// System.out.println(this); // will not work inside static method!
		
		thisReferenceExample.doProcess(10, new Process() {
			
			@Override
			public void process(int i) {
				System.out.println("Value of i is " + i);
				
				// will be this=instance of anonymous unner class!
				System.out.println(this);
				
			}
			
			// let's override toString method
			public String toString() {
				return "This is anonymous inner class.";
			}
			
		});

	}

}
