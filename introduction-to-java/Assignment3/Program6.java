import java.util.Date;

public class Program6 {
    public static void main(String[] args) {
        // Create the Customer and Visit objects
        Customer customer = new Customer("Jack");
        Visit visit = new Visit(customer, new Date());
        
        // Make the customer a premium member
        customer.setMember(true);
        customer.setMemberType("Premium");

        // Set the expense of the visit
        visit.setServiceExpense(100);
        visit.setProductExpense(100);

        // Print the details of the customer and the visit
        System.out.println(customer);
        System.out.println(visit);

        // Get the service, product and total expenses of the visit and print them
        System.out.printf("Service Expense: %.2f, Product Expense: %.2f, Total Expense: %.2f", visit.getServiceExpense(), visit.getProductExpense(), visit.getTotalExpense());
    }
}

class Customer {
    // Declare variables to represent the name of the customer, whether they are a member, and their membership type
    private final String name;
    private boolean member;
    private String memberType;

    // Constructor for Customer. Accepts the customer name as an argument.
    public Customer(String name) {
        // Set the name of the customer
        this.name = name;

        // The customer is initialised as a non-member.
        this.member = false;
        this.memberType = null;
    }

    public String getName() {
        // Getter for name
        return this.name;
    }

    public boolean isMember() {
        // Getter for member
        return this.member;
    }

    public String getMemberType() {
        // Getter for memberType
        return this.memberType;
    }

    public void setMember(boolean member) {
        // Setter for member. Used to set whether the customer is a member or not.
        this.member = member;
    }

    public void setMemberType(String type) {
        // Setter for memberType. Used to set the membership type of the customer.
        this.memberType = type;
    }

    @Override
    public String toString() {
        // Returns a string representation of the details of the customer
        if (this.member) {
            // If the customer is a member, include their name and membership type
            return String.format("%s (%s member)", this.name, this.memberType);
        }
        // If the customer is not a member, include their name and indicate that they are not a member
        return String.format("%s (Non-member)", this.name);
    }
}

class Visit {
    // Declare variables to represent the customer who made the visit, the date on which it occurred, and the amount spent on services and products
    private final Customer customer;
    private final Date date;
    private double serviceExpense, productExpense;

    // Constructor for Visit. Accepts Customer and Date objects as parameters.
    public Visit(Customer customer, Date date) {
        // Store the customer who made the visit and date on which it occurred
        this.customer = customer;
        this.date = date;
    }

    public String getName() {
        // Returns the name of the customer who made the visit
        return this.customer.getName();
    }

    public double getServiceExpense() {
        // Returns the amount payable by the customer for services in this visit, taking into account the potential discount the customer will receive according to their membership status
        if (this.customer.isMember()) {
            /*
            If the customer is a member, get the discount rate for their membership type and apply this rate to the service expense of the visit
            E.g. If a premium member spends €100:
            The discount rate is 0.2 (20%)
            1 - 0.2 = 0.8
            €100 * 0.8 = €80
            */
            return this.serviceExpense * (1 - DiscountRate.getServiceDiscountRate(this.customer.getMemberType()));
        }
        // If the customer is not a member, they receive no discount. Return the service expense as-is.
        return this.serviceExpense;
    }

    public double getProductExpense() {
        // Returns the amount payable by the customer for products in this visit, taking into account the potential discount the customer will receive according to their membership status
        if (this.customer.isMember()) {
            // If the customer is a member, get the discount rate for their membership type and apply this rate to the product expense of the visit
            return this.serviceExpense * (1 - DiscountRate.getProductDiscountRate(this.customer.getMemberType()));
        }
        // If the customer is not a member, they receive no discount. Return the product expense as-is.
        return this.productExpense;
    }

    public double getTotalExpense() {
        // Returns the total amount payable by the customer for services and products in this visit, taking into account the potential discount the customer will receive according to their membership status
        // Get the amounts payable for services and products in this visit. Add them, return the sum.
        return this.getServiceExpense() + this.getProductExpense();
    }

    public void setServiceExpense(double ex) {
        // Sets the service expense of the visit. Accepts the expense as a parameter.
        this.serviceExpense = ex;
    }

    public void setProductExpense(double ex) {
        // Sets the product expense of the visit. Accepts the expense as a parameter.
        this.productExpense = ex;
    }

    @Override
    public String toString() {
        // Returns a string representation of the details of the visit, including the date on which occurred, the name of the customer, and the total expense
        return String.format("Visit on %s by %s, with expense of %.2f", this.date, this.getName(), this.getTotalExpense());
    }
}

class DiscountRate {
    // Declare and initalise variable representing the discount rates for each member type for services and products
    private static final double serviceDiscountPremium = 0.2;
    private static final double serviceDiscountGold = 0.15;
    private static final double serviceDiscountSilver = 0.1;
    private static final double productDiscountPremium = 0.1;
    private static final double productDiscountGold = 0.1;
    private static final double productDiscountSilver = 0.1;

    // Return the discount rate that a member will receive on services, according to their membership type. Accepts the type as a parameter.
    public static double getServiceDiscountRate(String type) {
        // Use a switch expression to return the appropriate discount rate according to the membership type
        return switch (type) {
            case "Premium" -> serviceDiscountPremium;
            case "Gold" -> serviceDiscountGold;
            case "Silver" -> serviceDiscountSilver;
            default -> 0;
        };
    }

    // Return the discount rate that a member will receive on products, according to their membership type. Accepts the type as a parameter.
    public static double getProductDiscountRate(String type) {
        // Use a switch expression to return the appropriate discount rate according to the membership type
        return switch (type) {
            case "Premium" -> productDiscountPremium;
            case "Gold" -> productDiscountGold;
            case "Silver" -> productDiscountSilver;
            default -> 0;
        };
    }
}