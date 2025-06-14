import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Lab9 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter string: ");
        String userStr = userInput.nextLine();
        int i, j;

        // Program 1: All substrings
        System.out.println("Printing all substrings");
        for (i = 0; i <= userStr.length(); i++) {
            for (j = i+1; j <= userStr.length(); j++) {
                System.out.printf("%d:%d = %s\n", i, j, userStr.substring(i, j));
            }
        }

        // Program 2: Longest substring without repeating characters
        String longest = "";
        String current;
        Character c;
        Set<Character> chars = new HashSet<>();

        for (i = 0; i < userStr.length(); i++) {
            current = "";
            chars.clear();
            for (j = i; j < userStr.length(); j++) {
                c = userStr.charAt(j);
                if (chars.contains(c)) {
                    if (current.length() > longest.length()) {
                        longest = current;
                    }
                    break;
                }
                chars.add(c);
                current += c;
            }
        }

        System.out.println("Longest substring without repeating characters: " + longest);

        // Program 3: Most common repeating sequence
        HashMap<String, Integer> substrings = new HashMap<>();
        String s;

        for (i = 0; i <= userStr.length(); i++) {
            for (j = i+1; j <= userStr.length(); j++) {
                s = userStr.substring(i, j);
                if (substrings.containsKey(s)) {
                    substrings.put(s, substrings.get(s) + 1);
                } else {
                    substrings.put(s, 1);
                }                
            }
        }

        String substr = "";
        int freq = 0;
        for (Map.Entry<String, Integer> entry : substrings.entrySet()) {
            if (entry.getValue() > freq) {
                substr = entry.getKey();
                freq = entry.getValue();
            }
        }

        System.out.printf("%s occurs the most with %d occurrences", substr, freq);
    }
}