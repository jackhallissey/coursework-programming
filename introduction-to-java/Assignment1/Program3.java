import java.util.Scanner;

class Program3 {
    public static void main(String[] args) {
        // Create a scanner
        Scanner userInput = new Scanner(System.in);

        // Get the number of lines from the user
        System.out.print("Number of lines: ");
        int noLines = userInput.nextInt();

        // For each line, print n stars, with the appropriate number of spaces before it to make sure each line lines up
        for (int n = 1; n <= noLines; n++) {
			System.out.print(" ".repeat(noLines-n));
			System.out.println("*".repeat(n));
		}
    }
}