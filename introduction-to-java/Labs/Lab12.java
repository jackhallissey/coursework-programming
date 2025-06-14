import java.util.Scanner;

class Lab12 {
    public static void main(String[] args) {
        int i, j;
        Scanner userInput = new Scanner(System.in);

        // Program 1
        int n = userInput.nextInt();
        int[][] triangle = new int[n+1][(n+1)*2];
        
        triangle[0][n+1] = 1;

        int start = n;  //(n+1)-1
        int end = n+2;  //(n+1)+1

        for (i = 1; i < triangle.length; i++) {
            triangle[i][start] = 1;
            triangle[i][end] = 1;

            for (j = start + 2; j < end; j += 2) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j+1];
            }

            start--;
            end++;
        }

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


        // Program 2
        System.out.println("Program 2");
        System.out.print("Side length: ");
        int sideLength = userInput.nextInt();
        int noSpaces = (sideLength * 2) - 3;
        System.out.println("* ".repeat(sideLength));
        for (i = 0; i < sideLength - 2; i++) {
            System.out.print("*");
            System.out.print(" ".repeat(noSpaces));
            System.out.println("*");
        }
        System.out.println("* ".repeat(sideLength));

        // Program 3
        System.out.println("Program 3");
        int[] nums = {9, 3, 7, 15, 12, 16, 11};
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.print("\nSearch target: ");
        int target = userInput.nextInt();
        
        search: {
            for (i = 0; i < nums.length; i++) {
                if (nums[i]== target) {
                    System.out.printf("Found %d at position %d\n", target, i);
                    break search;
                }
            }
            System.out.printf("%d not found in array\n", target);
        }
    }
}