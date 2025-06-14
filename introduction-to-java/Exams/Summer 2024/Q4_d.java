//Import the Scanner class for user input and the Arrays class for methods related to arrays
import java.util.Arrays;
import java.util.Scanner;

public class Q4_d {
	public static void main(String[] args) {
		//Create 3x12 matrices for Cork temps, Dublin temps and average temps
		int[][] td = new int[3][12];
		int[][] tc = new int[3][12];
		int[][] tavg = new int[3][12];

		//Test
		System.out.println(Arrays.deepToString(tavg));
		
		
		//Create the scanner for user input from standard input
		Scanner in = new Scanner(System.in);
		
		//Declare int variables for use in loops
		int i, j;
		
		//Prompt user 1 for input
		System.out.println("User 1 - Enter 36 temperatures for Dublin:");
		
		//Iterate through each cell in td and insert the number entered by the user
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 12; j++) {
				td[i][j] = in.nextInt();
			}
		}
		
		//Prompt user 2 for input
		System.out.println("User 2 - Enter 36 temperatures for Cork:");
		
		//Fill tc in the same way as with td
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 12; j++) {
				tc[i][j] = in.nextInt();
			}
		}
		
		//Iterate through each cell in tavg, calculate the average temp, and insert it
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 12; j++) {
				tavg[i][j] = (int) (td[i][j] + tc[i][j]) / 2;
			}
		}
		
		//Print a string representation of tavg
		//Use deepToString() to get string representations of the inner lists
		System.out.println(Arrays.deepToString(tavg));
	}
}