class A {
	//The first class in the program
	public static void main(String[] args) {
		System.out.println("Hello from class A");
		//Call a method of class B
		B.hello();
	}
}

class B {
	//B is a second class in the same file, not nested within any other class
	static void hello() {
		//An example method for class B
		System.out.println("Hello from class B");
	}
}