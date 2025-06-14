import java.util.Scanner;

class Program1 {
    public static void main(String[] args) {
        // Check if a year, given by the user, is a leap year

        // Create a new scanner to get user input through stdin
        Scanner userInput = new Scanner(System.in);

        // Get the year from the user
        System.out.print("Enter year: ");
        int year = userInput.nextInt();

        // Call the method below to check if the year is a leap year. Print the result.
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is NOT a leap year.\n", year);
        }
    }

    static boolean isLeapYear(int year) {
        // Accepts the year as an integer as a parameter
        // Returns a Boolean indicating whether the given year is a leap year or not

        // If the year is evenly divisible by 400, it is a leap year (e.g. 2000)
		if (year % 400 == 0) {
			return true;
		}
        // Otherwise, if the year is evenly divisible by 100, it is not a leap year (e.g. 1900)
		if (year % 100 == 0) {
			return false;
		}
        // Otherwise, the year is a leap year if it is evenly divisible by 4.
        // Otherwise, it is not a leap year.
		return year % 4 == 0;
	}
}