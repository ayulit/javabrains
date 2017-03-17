package io.javabrains.unit2;

public class ClosuresExample {

	public static void main(String[] args) {

		int a = 10;
		int b = 20; // effectively final (means final without 'final')
		
		// closure: 'b' value will be frozen inside lambda: we cant change it inside, e.g. do like b++
		doProcess(a, i -> { i++; System.out.println(i + b); } );
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}
	
}

interface Process {
	void process(int i);
}
