import java.util.ArrayList;
import java.util.Scanner;

class Program1 {
    public static void main(String[] args) {
        // Create scanner
        Scanner userInput = new Scanner(System.in);

        // Create array list to store names
        ArrayList<String> names = new ArrayList<>();
		
        // Ask the user for 10 names
		System.out.println("Enter 10 names:");

        int i;
		
        // Get the 10 names from the user and add each of them to the list
		for (i = 0; i < 10; i++) {
			names.add(userInput.nextLine());
		}
		
        // Continue until all names have been printed and removed
        while (!names.isEmpty()) {
            // Next name initially set to first name in list
            int nextName = 0;
            // Loop through all the remaining names to find which one comes first alphabetically
            for (i = 1; i < names.size(); i++) {
                // If this name comes before the current next name alphabetically, set next name to this name
                if (names.get(i).compareToIgnoreCase(names.get(nextName)) < 0) {
                    nextName = i;
                }
            }
            // Print the name remaining that comes first alphabetically and remove it from the list
            System.out.println(names.get(nextName));
            names.remove(nextName);
        }
    }
}