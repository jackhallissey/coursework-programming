import java.util.Scanner;

class Program2 {
    public static void main(String[] args) {
        // Create scanner
        Scanner userInput = new Scanner(System.in);
        
        // Get dividend and divisor from user
		System.out.print("Enter dividend: ");
		int dividend = userInput.nextInt();

		System.out.print("Enter divisor: ");
		int divisor = userInput.nextInt();
		
        // Calculate quotient by dividing dividend by divisor and converting to int
		System.out.printf("Quotient: %d\n", (int) Math.floor(dividend / divisor));

        // Calculate remainder using modulo
		System.out.printf("Remainder: %d\n", dividend % divisor);
    }
}