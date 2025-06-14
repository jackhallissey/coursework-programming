class Circle {
	Operation op;
	//Aggregation takes place here - the op field of the Circle class will contain a reference to an Operation object
	
	double pi;
	
	double area(int radius) {
		return pi * op.square(radius);
	}
}

class Operation {
	int square(int n) {
		return n * n;
	}
}