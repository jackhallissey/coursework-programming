import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Program4 {
    public static void main(String[] args) {
        // Create scanner
        Scanner userInput = new Scanner(System.in);

        // Get input string from user
        System.out.print("Enter a string: ");
        String userStr = userInput.nextLine();

        // Create a queue and stack to store the characters of the string
        Stack<Character> charStack = new Stack<>();
        Queue<Character> charQueue = new LinkedList<>();

        char c;
        int i;

        // Add each character of the string to the stack and queue
        for (i = 0; i < userStr.length(); i++) {
            c = userStr.charAt(i);
            charStack.push(c);
            charQueue.add(c);
        }

        // Remove a character from the stack and one from the queue n times (n = length of string) and compare them.
        // Because a queue is FIFO and a stack is LIFO, the characters of the string will be removed in order from the queue, but in reverse order from the stack
        // If the two characters are not equal, this means the equivalent character on the other side of the string is different, meaning the string is not a palindrome
        // If each of the pairs of removed characters are the same, the string is a palindrome.
        check: {
            for (i = 0; i < userStr.length(); i++) {
                if (!charStack.pop().equals(charQueue.remove())) {
                    System.out.println("The string is NOT a palindrome");
                    break check;
                }
            }
            System.out.println("The string is a palindrome");
        }
    }
}