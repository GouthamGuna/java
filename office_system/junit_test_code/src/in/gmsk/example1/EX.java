package in.gmsk.example1;

import static dev.gmsk.util.RandomTokenGenerator.*;

public class EX {
	
	/*public static void m1() { // =
		m2();
	}
	
	public static void m2() { 
		m3();
	}
	
	public static void m3() { 
		System.out.println("Hello World!");
	}
	
	
	public static void main(String[] args) { 
		m1();
	}*/
	
	public static void main(String[] args) {
		
		char no = 67;
		System.out.println(no);
		
		System.out.println(tokenGenerator());
		System.out.println(tokenGenerator(10));
	}
}
