class Lab3 {
    public static void main(String[] args) {
		// Program 1 - perfect numbers
		System.out.println("Program 1");
		perfectNumber(20);
		perfectNumber(28);
			
		// Program 2 - factorial		
		System.out.println("\nProgram 2");
        System.out.println(factorial(1l));
        System.out.println(factorial(3l));
        System.out.println(factorial(10l));
		System.out.println(factorial(15l));
    }
	
	static void perfectNumber(int n) {
		if (n < 20) {
			System.out.println("The number is too small");
			return;
		}
		if (n > 30) {
			System.out.println("The number is too big");
			return;
		}
		
		int sum = 0;
		
		for (int m = 1; m < n; m++) {
			if (n % m == 0) {
				System.out.printf("%d is a proper divisor of %d\n", m, n);
				sum += m;
			}
		}
		
		if (sum == n) {
			System.out.printf("%d is a perfect number\n", n);
		} else {
			System.out.printf("%d is NOT a perfect number\n", n);
		}
	}

    static long factorial(long n) {
        if (n == 1) {
            return 1l;
        } else {
            return n * factorial(n-1);
        }
    }
}