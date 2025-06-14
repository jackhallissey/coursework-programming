import java.util.Arrays;
import java.util.Scanner;

class Program1 {
    public static void main(String[] args) {
        // Create the scanner
        Scanner userInput = new Scanner(System.in);

        // Create the 3D matrix
        int[][][] matrix3D = {
			{ {1,2,3}, {4,5,6}, {7,8,9} },
			{ {10,11,12}, {13,14,15}, {16,17,18} },
			{ {19,20,21}, {22,23,24}, {25,26,27} }
		};
		
        // Print the 3D matrix
		System.out.println(Arrays.deepToString(matrix3D));
		
        // Get the target integer from the user
		System.out.print("Enter an integer to search for: ");
		int target = userInput.nextInt();
		
		search: {
            // Loop through the 3 layers of the matrix to check each individual cell
			for (int[][] midArr: matrix3D) {
				for (int[] innerArr: midArr) {
					for (int num: innerArr) {
                        // Check if number in cell is equal to target
						if (num == target) {
							System.out.printf("%d is present in the 3D array",target);
							// Break out of this block so that the not present message below is not printed
                            break search;
						}
					}
				}
			}
            // If the number is not found, this block will not be broken out of, and the below message will be printed
			System.out.printf("%d is NOT present in the 3D array",target);
		}
    }
}