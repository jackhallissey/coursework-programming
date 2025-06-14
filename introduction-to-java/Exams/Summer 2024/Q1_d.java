// This class lets us create a thread by extending the Thread class
class T1 extends Thread {
	//Override the run() method to provide the code that the thread should execute when it starts
	public void run() {
		System.out.println("A thread created by extending the Thread class");
	}
}

//This class lets us create a thread by implementing the Runnable interface
class T2 implements Runnable {
	//Define a run() method for the same purpose as in T1
	public void run() {
		System.out.println("A thread created by implementing the Runnable interface");
	}
}

public class Q1_d {
	public static void main(String[] args) {
		//Create a thread using T1 by creating an instance of T1
		T1 t1 = new T1();
		//Start the thread by calling the start() method
		t1.start();
		
		
		//Create a thread using T2 by first creating an instance of T2 
		T2 t2 = new T2();
		//Create a thread object and pass the T2 object into its constructor
		Thread t = new Thread(t2);
		//Start the thread by calling its start() method
		t.start();		
	}
}