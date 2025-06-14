import java.util.Arrays;
import java.util.Scanner;

class Program4 {
    public static void main(String[] args) {
        // Create scanner
        Scanner userInput = new Scanner(System.in);

        // n = height and width of matrices
        int n = 3;
		
        int i, j;
		
        // Initialise matrices
		int[][] matrix1 = new int[n][n];
		
		int[][] matrix2 = new int[n][n];
		
		// Get user input for matrix 1
		System.out.printf("Enter %d integers for matrix 1: ", n * n);
		
        // Loop through each cell in the matrix and insert the integer given by the user
		for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
			    matrix1[i][j] = userInput.nextInt();
            }
		}
		
		// Get user input for matrix 2
		System.out.printf("Enter %d integers for matrix 2: ", n * n);
		
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
			    matrix2[i][j] = userInput.nextInt();
            }
		}
		
		// Add the two matrices
		int[][] matrixSum = addMatrices(matrix1, matrix2);

        // Print the resulting matrix
		System.out.println(Arrays.deepToString(matrixSum));
    }

	static int[][] addMatrices(int[][] m1, int[][] m2) {
		int n = m1.length;

        // Initialise the resulting matrix
		int[][] sumMatrix = new int[n][n];

        // Loop through each cell in the resulting matrix
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Add the values in the corresponding cells in m1 and m2. Insert the sum in this cell in sumMatrix.
			    sumMatrix[i][j] = m1[i][j] + m2[i][j];
            }
		}

		return sumMatrix;
	}
}