import java.util.Scanner;

class Lab13 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Program 1
        System.out.println("Triangle pattern");

        System.out.print("Number of lines: ");
        int n = userInput.nextInt();
        int[][] triangle = new int[n+1][(n*4)+1];

        triangle[0][n*2] = 1;

        int start = n*2 - 2;
        int end = n*2 + 2;

        int i, j, count;

        for (i = 1; i < n + 1; i++) {
            triangle[i][n*2] = 1;

            count = 2;
            for (j = n*2 - 2; j >= start; j -= 2) {
                triangle[i][j] = count;
                count++;
            }

            count = 2;
            for (j = n*2 + 2; j <= end; j += 2) {
                triangle[i][j] = count;
                count++;
            }

            start -= 2;
            end += 2;
        }

        // Print triangle
        for (i = 0; i < triangle.length; i++) {
            for (j = 0; j < triangle[0].length; j++) {
                if (triangle[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(triangle[i][j]);
                }
            }
            System.out.println();
        }
    }
}