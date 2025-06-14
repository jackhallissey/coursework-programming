//Create the Employee class
class Employee {
	//It has one field: salary
	int salary;
}

//Create the Programmer class, which inherits from the Employee class
class Programmer extends Employee {
	//It has one field in addition to those it inherits: bonus
	int bonus;
	
	public static void main(String[] args) {
		//Create a Programmer object
		Programmer p = new Programmer();
		//Set its salary (it inherits this field from Employee)
		p.salary = 1000;
		//Set its bonus
		p.bonus = 100;
		//Output the values for both fields
		System.out.println(p.salary);
		System.out.println(p.bonus);
	}
}