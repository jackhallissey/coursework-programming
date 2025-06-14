import java.util.Scanner;

class Program4 {
    public static void main(String[] args) {
        // Create a scanner
        Scanner userInput = new Scanner(System.in);

        // Get the number of lines from the user
        System.out.print("Number of lines: ");
        int noLines = userInput.nextInt();

        // The number of lines must be odd to make a diamond shape
        if (noLines % 2 == 0) {
			System.out.println("The number must be odd");
			return;
		}

        // m = number of spaces before the stars in each line
        // n = number of stars in each line
		int n, m;
		
		// Top part of diamond
        // Start with 1 star. The number of starts increases by 2 until it fills the line.
        // On each line, print the appropriate number of spaces before the starts to ensure the stars are centred.
		for (n = 1; n <= noLines; n += 2) {
			m = (noLines - n) / 2;
			System.out.print(" ".repeat(m));
			System.out.println("*".repeat(n));
		}
		
		// Bottom part of diamond
        // Start with 2 less starts than the last row of the top part. Decrease by 2 until there is only one star.
        // On each line, print the appropriate number of spaces before the starts to ensure the stars are centred.
		for (n = noLines - 2; n >= 1; n -= 2) {
			m = (noLines - n) / 2;
			System.out.print(" ".repeat(m));
			System.out.println("*".repeat(n));
		}
    }
}