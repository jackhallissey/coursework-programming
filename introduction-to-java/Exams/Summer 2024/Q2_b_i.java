class A {
	//The first class in the program
	
	public static void main(String[] args) {
		//Call a method of class A
		A.hello();
		//Call a method of class B 
		B.hello();
	}
	
	static void hello() {
		//An example method for class A
		System.out.println("Hello from class A");
	}
	
	class B {
		//B is a nested class within A
		static void hello() {
			//An example method for class B
			System.out.println("Hello from class B");
		}
	}
}