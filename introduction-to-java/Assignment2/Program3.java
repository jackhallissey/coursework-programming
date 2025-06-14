import java.util.Scanner;

class Program3 {
    public static void main(String[] args) {
        // Create scanner
        Scanner userInput = new Scanner(System.in);

        // Get base and exponent from user
        System.out.print("Enter base: ");
		double base = userInput.nextDouble();

		System.out.print("Enter exponent: ");
		double exponent = userInput.nextDouble();

        // Initialise result
        double result = 1;

        // Multiply result by base n times (n = exponent)
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }

        // Print result
        System.out.println("Result: " + result);
    }
}