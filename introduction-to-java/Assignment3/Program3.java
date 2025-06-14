import java.util.HashSet;
import java.util.Scanner;

class Program3 {
    public static void main(String[] args) {
        // Create scanner
        Scanner userInput = new Scanner(System.in);

        // Get input string from user
        System.out.print("Enter a string: ");
        String userStr = userInput.nextLine();

        // seen set contains characters that have already been found in the string
        HashSet<Character> seen = new HashSet<>();

        // duplicates set contains characters that have already identified as duplicates
        HashSet<Character> duplicates = new HashSet<>();

        char c;

        // Go through each character in the string
        for (int i = 0; i < userStr.length(); i++) {
            // Get the character at this position in the string
            c = userStr.charAt(i);
            // If c is already in seen, it must occur in the string another times before position i, so it must be a duplicate character
            if (seen.contains(c)) {
                // Add the duplicate character c to the duplicates set
                duplicates.add(c);
            } else {
                // If c is not a duplicate and is not already in seen, add it to seen so we know we have now seen it
                seen.add(c);
            }
        }

        // Print each of the duplicate characters
        for (char dup: duplicates) {
            System.out.println("Duplicate character: " + dup);
        }
    }
}