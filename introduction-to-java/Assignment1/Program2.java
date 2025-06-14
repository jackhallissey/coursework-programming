import java.util.LinkedList;
import java.util.Scanner;

class Program2 {
    public static void main(String[] args) {
        // Create a scanner to get user input
        Scanner userInput = new Scanner(System.in);

        // Get the two binary numbers from the user
        String b1 = userInput.nextLine();
        String b2 = userInput.nextLine();

        // Convert the two binary numbers to integers and add them
        int sum = binToInt(b1) + binToInt(b2);

        // Convert the sum to a binary number and print it
        System.out.println(intToBin(sum));
    }

    static int binToInt(String bin) {
        int res = 0;
        
        // Represents the weight of the bit. Starts at 2^0 (1), then 2^1 (2), etc.
        int weight = 1;

        // Go through each bit in reverse order
        for (int i = bin.length() - 1; i > -1; i--) {
            // If the bit is 1, add the weight of the bit to the result
            if (bin.charAt(i) == '1') {
                res += weight;
            }
            // Double the weight before moving on to the next bit
            weight = weight * 2;
        }

        return res;
    }

    static String intToBin(int n) {
        // Create a linked list to store the bits of the resulting binary number
        LinkedList<String> bits = new LinkedList<>();

        while (n > 0) {
            // Divide n by 2. Get the next bit by taking the remainder. Add the next bit to the start of the linked list
            bits.addFirst(String.valueOf(n % 2));
            n = (int) Math.floor(n / 2);
        }

        // If no bits have been added, the input number was 0
        if (bits.isEmpty()) {
            return "0";
        }
        // Join the bits into a single string and return it
        return String.join("", bits);
    }
}