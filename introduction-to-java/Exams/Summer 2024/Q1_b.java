public class Q1_b {
	public static void main(String[] args) {
		int[] troops = {10, 20, 30};
		// Place this code in a try block to test it for errors as it is being executed
		try {
			System.out.println(troops[100]);
		} catch (Exception e) {
			// If an exception occurred during the try block, report that there was an errors
			System.out.println("An error occurred");
		} finally {
			// The code in the finally block will be executed after the try...catch blocks, regardless of whether an exception occurred in the try block or not
			System.out.println("Waiting for next assignment");
		}
	}
}