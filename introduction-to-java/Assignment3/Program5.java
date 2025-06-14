import java.util.HashMap;
import java.util.Scanner;

class Program5 {
    public static void main(String[] args) {
        // Create scanner
        Scanner userInput = new Scanner(System.in);

        // Get the two strings from the user
        System.out.print("Enter first string: ");
        String str1 = userInput.nextLine();
        System.out.print("Enter second string: ");
        String str2 = userInput.nextLine();

        // Check if the strings are anagrams and report the result
        if (isAnagram(str1, str2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not an anagram");
        }
    }

    static boolean isAnagram(String str1, String str2) {
        // Each pair in the hash map will be (char, count), where char is each character in str1, and count is the number of times that character occurs in str1
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        char c;
        int i;

        // Go through each character in str1
        for (i = 0; i < str1.length(); i++) {
            c = str1.charAt(i);
            if (charCount.containsKey(c)) {
                // If c is already in the hash map, increase its value by 1 to record this new occurrence
                charCount.put(c, charCount.get(c) + 1);
            } else {
                // If c is not already in the hash map, this is the first time it has occurred in str1, so its count is 1
                charCount.put(c, 1);
            }
        }

        // Go through each character in str2
        for (i = 0; i < str2.length(); i++) {
            c = str2.charAt(i);
            if (charCount.containsKey(c)) {
                // Reduce the count for c by 1 to represent str2 using c one time
                charCount.put(c, charCount.get(c) - 1);
            } else {
                // If c is not in the hash map, it means it was not in str1
                // If str2 uses a character that was not in str1, it cannot be an anagram
                return false;
            }
        }

        // Go through the count for each character in the has map
        for (int count : charCount.values()) {
            if (count != 0) {
                // If count < 0, the character occurred in str2 more times than it occurred in str1, so it cannot be an anagram
                // If count < 0, the character occurred in str2 fewer times than it occurred in str1, so str2 did not use all of the characters in str1, and it cannot be an anagram
                return false;
            }
        }

        // If each character was used in str2 the same number of times it was used in str1, it is an anagram
        return true;
    }
}