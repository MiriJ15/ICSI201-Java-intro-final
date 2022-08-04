import java.util.Scanner;

/*
 * This class represents the customer and contains methods asking for customer's name, phone number, number of units of desired product and product id 
 */
public class Customer {
	Scanner keyboard = new Scanner(System.in);

	/**
	 * this method asks user how many units of the choice(product chosen) he needs
	 * 
	 * @return units units of chosen product
	 */
	public int unit() {
		System.out.print("How many units you would like to get? ");
		int units = keyboard.nextInt();
		while (units < 1) {
			System.out.println("Please input correct number of units.");
			System.out.print("How many units you would like to get? ");
			units = keyboard.nextInt();
		}
		return units;
	}

	/**
	 * This method asks user to enter integer corresponding to the inventory
	 * products numbering. If choice integer is out of range program asks for
	 * another integer within 1-6 range.
	 * 
	 * @return choice product choice from the user
	 */
	public int choice() {
		// running scanner class
		Scanner keyboard = new Scanner(System.in);
		// asking user to input integer choice
		System.out.print("Your choice: ");
		int choice = keyboard.nextInt();
		// run while loop till user inputs correct integer for choice ( if choice
		// integer was not in range 1-6 initially)
		while (!(choice > 0 && choice < 7)) {
			if (!(choice > 0 && choice < 7)) {
				System.out.println("You should choose item from 1 to 6.");
				System.out.print("Your choice: ");
				choice = keyboard.nextInt();
			}
		}
		return choice;
	}

	/**
	 * this method asks user for first and last name and concatenates 2 variables to
	 * form full name and return it.
	 * 
	 * @return name Name of the customer
	 */
	public String name() {
		System.out.println("What is your name First Name?");
		String fName = keyboard.nextLine();
		System.out.println("What is your name Last Name?");
		String lName = keyboard.nextLine();
		String name = fName + " " + lName;
		return name;

	}

	/**
	 * This program asks user to input phone number and returns it
	 * 
	 * @return phoneN Phone Number of the user
	 */
	public String phoneN() {
		System.out.println("What is your name phone number?");
		int phone = keyboard.nextInt();
		String phoneN = "Phone Number: " + phone;
		return phoneN;
	}
}
