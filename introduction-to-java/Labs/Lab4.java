import java.util.Scanner;

class Lab4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Program 1
		System.out.println("Even and odd numbers");
		int p1Number;
		int noEven = 0;
		int noOdd = 0;
		System.out.println("Enter 10 integers: ");
		for (int i = 0; i < 10; i++) {
			p1Number = input.nextInt();
			if (p1Number % 2 == 0) {
				noEven += 1;
			} else {
				noOdd += 1;
			}
		}
		
		System.out.printf("You entered %d even numbers and %d odd numbers\n", noEven, noOdd);
		
		
		// Program 2
		System.out.println("\nCalculating standard deviation");
		System.out.print("How many numbers? ");
		int[] arr = new int[input.nextInt()];
		
		int num;
		int sum = 0;
		System.out.printf("Enter %d integers:\n", arr.length);
		for (int i = 0; i < arr.length; i++) {
			num = input.nextInt();
			arr[i] = num;
			sum += num;
		}
		double mean = sum / arr.length;
		
		double top = 0;			// top part of fraction
		for (int x: arr) {
			top += Math.pow(x-mean, 2);
		}
		
		double s = Math.sqrt(top/arr.length);
		
		System.out.println(s);
	}
}