import java.util.Arrays;

class Lab5 {
    public static void main(String[] args) {
		// Length and average of array
        int[] myArray = {2, 4, 6, 8, 10};
		arrayInfo(myArray);
		
		
		// Matrix transpose
		int[][] testMatrix = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		int[][] testTranspose = matrixTranspose(testMatrix);
		
		System.out.println("Transposed matrix:");

		System.out.println(Arrays.toString((testTranspose)));
	}

    static void arrayInfo(int[] arr) {
        System.out.println("Number of items: " + arr.length);
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }
        System.out.println("Average: " + sum/arr.length);
    }
	
	static int[][] matrixTranspose(int[][] matrix) {
		int n = matrix.length;
		
		int[][] transpose = new int[n][n];
		
		int i = 0;
		int j = 0;
		
		while (i < n & j < n) {
			transpose[i][j] = matrix[j][i];
			if (j == n-1) {
				i += 1;
				j = 0;
			} else {
				j += 1;
			}
		}
		
		return transpose;
	}
}