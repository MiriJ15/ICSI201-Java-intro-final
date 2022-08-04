import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
	private LocalDate date; // date of the purchase will be stored here
	private double total; // final bill will be stored here
	private int choice; // user's choice will be stored here
	private int units; // number of units asked by the user will be stored here
	private double price; // price (product price * n of units) will be stored here
	private String input; // users input for whether he wants us continue shopping will be stored here
	private String name; // user's name will be stored here
	private String file; // users input for whether he wants us to transfer bill to bill.txt file will be
							// stored here
	private String phone; // user's phone number will be stored here
	private String insert1; // decoration for the bill will be stored here
	private String insert2; // another decoration for the bill will be stored here
	private String finalTotal; // final statement containing total price in dollars + cents will be stored here
	ArrayList<String> typeX = new ArrayList<String>(); // typeX items will be stored here
	ArrayList<String> typeY = new ArrayList<String>(); // TypeY items will be stored here
	ArrayList<String> typeZ = new ArrayList<String>(); // TypeZ items will be stored here
	ArrayList<String> bill = new ArrayList<String>(); // chosen items will be stored here

	// constructor to initialize certain variables
	public Order() {
		insert1 = "*********************************************"; // initializing decoration for the bill
		insert2 = "+-------------------------------------------+"; // initializing another decoration for the bill
	}

	Scanner keyboard = new Scanner(System.in); // initializing scanner

	/**
	 * This method will be called in main in order to start our program.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public void order() throws ParseException, IOException {
		Customer c = new Customer(); // initializing Customer
		Date d = new Date(); // initializing Date
		Order o = new Order(); // initializing Order

		// reading txt file and creating arrays
		List<String> lines = Files.readAllLines(new File("Inventory.txt").toPath());
		String p1 = lines.get(1);
		String p2 = lines.get(2);
		String p3 = lines.get(3);
		String p4 = lines.get(4);
		String p5 = lines.get(5);
		String p6 = lines.get(6);
		typeX.add(p1);
		typeX.add(p2);
		typeY.add(p3);
		typeY.add(p4);
		typeZ.add(p5);
		typeZ.add(p6);
		// here you can wee us calling methods and printing output required for running
		// our store
		System.out.println("Hello welcome to our store!");
		// storing user's name
		name = c.name();
		// store phone number
		phone = c.phoneN();
		// storing verified date for future use
		date = d.isWithinRange(d.date());
		// starting do-while loop so that user may purchase as many distinct items as he
		// wants to. user will be able to see the inventory chose the product number
		// and units, then program will calculate the price in dollars + cents for
		// products + units combination and ask user whether he wants to continue. If
		// user says yes, loop will repeat till user says no.
		do {
			System.out.println(" ");
			System.out.println("Customer: " + name);
			System.out.println(phone);
			System.out.println(" ");
			System.out.println("The Inventory:");
			inventory(typeX, typeY, typeZ);
			choice = c.choice();
			units = c.unit();
			price = calculation(choice, units, d.extractingDay(date), d.extractingMonth(date));
			total += price;
			int priceDollars = (int) price;
			long priceCents = Math.round((price - priceDollars) * 100);
			System.out.println("Yout total for " + productName(choice) + " is " + priceDollars + " dollars "
					+ priceCents + " cents.");
			System.out.println(" ");
			bill.add("| " + productName(choice) + ", " + units + " units, total: $" + price);
			System.out.print("Would you like to continue your shopping? (Yes/No) ");
			input = keyboard.nextLine();
			System.out.println(" ");
		} while (input.equalsIgnoreCase("yes"));
		// converting final total price into dollars and cents and printing out the
		// bill with final price of the shopping
		bill();
		// asking whether user needs .txt version of the receipt and adding text to
		// bill.txt if file=Yes
		System.out.println("Would you like to save to file? (Yes/No)");
		file = keyboard.nextLine();
		if (file.equalsIgnoreCase("yes")) {
			billToTxt();
			System.out.println("Now you can find your bill in bill.txt file!");
		} else {
			System.out.println("Have a nice Day!");
		}
	}

	/**
	 * this method uses choice from the user in order to pass it through the switch
	 * and use correct calculation method in order to produce price for this item
	 * and n of units
	 * 
	 * @param choice users choice integer from 1-6
	 * @param units  units of product inputed by the user
	 * @param day    extracted from the date inputed by the user
	 * @param month  extracted from the date inputed by the user
	 * @return price total cost of products chosen
	 * @throws ParseException
	 */
	public double calculation(int choice, int units, int day, int month) throws ParseException {
		ProdX x = new ProdX(); // introducing prod X to main
		ProdY y = new ProdY(); // introducing prod Y to main
		ProdZ z = new ProdZ(); /// introducing prod Z to main
		double price = 0; // setting our price for products to 0

		switch (choice) {
		case (1):
			price = x.totalBulb1(units);
			break;
		case (2):
			price = x.totalBulb2(units);
			break;
		case (3):
			price = y.totalBolt5(units);
			break;
		case (4):
			price = y.totalBolt8(units);
			break;
		case (5):
			price = z.totalHose20(units, day, month);
			break;
		case (6):
			price = z.totalHose50(units, day, month);
			break;
		default:
			System.out.println("Invalid product choice");
			break;
		}
		return price;
	}

	/**
	 * this method combines elements of 3 type arrays into inventory output
	 * 
	 * @param typeX
	 * @param typeY
	 * @param typeZ
	 * @throws IOException
	 */
	public void inventory(ArrayList<String> typeX, ArrayList<String> typeY, ArrayList<String> typeZ)
			throws IOException {
		typeX.forEach(System.out::println);
		typeY.forEach(System.out::println);
		typeZ.forEach(System.out::println);
	}

	/**
	 * this product sets name of the product according to the choice of the user
	 * 
	 * @param choice
	 * @return name name of the product
	 * @throws IOException
	 */
	public String productName(int choice) throws IOException {
		String name = null;
		switch (choice) {
		case (1):
			name = "Light Bulb 60W";
			break;
		case (2):
			name = "Light Bulb 100W";
			break;
		case (3):
			name = "Bolt M5";
			break;
		case (4):
			name = "Bolt M8";
			break;
		case (5):
			name = "Hose 25 feet";
			break;
		case (6):
			name = "Hose 50 feet";
			break;
		default:
			System.out.println("Invalid product choice");
			break;
		}
		return name;
	}

	/*
	 * this method print out statements containing user's info, date and final total
	 * of the shopping
	 */
	public void bill() {
		System.out.println(insert1);
		System.out.println(date);
		System.out.println(insert1);
		System.out.println("Customer: " + name);
		System.out.println(phone);
		System.out.println("Your Bill: ");
		System.out.println(insert2);
		bill.forEach(System.out::println);
		System.out.println(insert2);
		int priceDollars = (int) total;
		long priceCents = Math.round((total - priceDollars) * 100);
		finalTotal = "Yout final bill is " + priceDollars + " dollars " + priceCents
				+ " cents. Thank you for shopping with us!";
		System.out.println(finalTotal);
		System.out.println(" ");
	}

	/*
	 * this method converts code from bill to bill.txt for user who needs a copy of
	 * the receipt
	 */
	public void billToTxt() throws IOException {
		FileWriter fw = new FileWriter("bill.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(insert1);
		bw.newLine();
		bw.write(date.toString());
		bw.newLine();
		bw.write(insert1);
		bw.newLine();
		bw.write("Customer: " + name);
		bw.newLine();
		bw.write(phone);
		bw.newLine();
		bw.write("Your Bill: ");
		bw.newLine();
		bw.write(insert2);
		bw.newLine();
		for (String str : bill) {
			bw.write(str + System.lineSeparator());
		}
		bw.write(insert2);
		bw.newLine();
		bw.write(finalTotal);
		bw.close();
	}
}