/**
 * this class is dedicated to the products of type Y
 *
 */
public class ProdY extends DollarCents {
	// declaring variables
	private double bolt5Price; // here product number 3's price will be stored
	private double bolt8Price; // here product number 4's price will be stored
	private double price; // here product 3/4 price will be stored after calculations
	private double discount5; // discount type 1
	private double discount15; // discount type 2
	private double discount25; // discount type 3

	/**
	 * constructor initializes variables
	 */
	public ProdY() {
		// initializing variables
		discount5 = 0.95; // sets discount 1 to 5%
		discount15 = 0.85; // sets discount to 15%
		discount25 = 0.75; // sets discount to 25%
		bolt5Price = 0.15; // sets product 3's price to 0.15 dollars
		bolt8Price = 0.25; // sets product 4's price to 0.25 dollars
	}

	/**
	 * this method calculates the price for the product number 3, depending on
	 * number of units inputed by the user and discount (depends on number of units
	 * as well), and print out available offers.
	 * 
	 * @param units units inputed by the user
	 * @return price here product 3 price will be stored after calculations
	 */
	public double totalBolt5(int units) {
		if (units <= 99) {
			price = units * bolt5Price;
			System.out.println("* If you buy more than 100 units you would pay $0.14 per unit.\n"
					+ "* If you buy more than 500 units you would pay $0.13 per unit.\n"
					+ "* If you buy more than 1500 units you would pay $0.11 per unit.");
		} else if (units >= 100 && units <= 499) {
			price = units * bolt5Price * discount5; // setting price to product
			System.out.println("* If you buy more than 500 units you would pay $0.13 per unit.\n"
					+ "* If you buy more than 1500 units you would pay $0.11 per unit.");
		} else if (units >= 500 && units <= 1499) {
			price = units * bolt5Price * discount15; // setting price to product
			System.out.println("* If you buy more than 1500 units you would pay $0.11 per unit.");
		} else if (units >= 1500) {
			price = units * bolt5Price * discount25; // setting price to product
		}
		return price;
	}

	/**
	 * this method calculates the price for the product number 4, depending on
	 * number of units inputed by the user and discount (depends on number of units
	 * as well) and prints out available offers
	 * 
	 * @param units units inputed by the user
	 * @return price here product 4 price will be stored after calculations
	 */
	public double totalBolt8(int units) {
		if (units < 100) {
			price = units * bolt8Price;
			System.out.println("** If you buy more than 100 units you would pay $0.24 per unit.\n"
					+ "** If you buy more than 500 units you would pay $0.21 per unit.\n"
					+ "** If you buy more than 1500 units you would pay $0.19 per unit.");
		} else if (units > 99 && units < 500) {
			price = units * bolt8Price * discount5; // setting price to product
			System.out.println("** If you buy more than 500 units you would pay $0.21 per unit.\n"
					+ "** If you buy more than 1500 units you would pay $0.19 per unit.");
		} else if (units > 499 && units < 1500) {
			price = units * bolt8Price * discount15; // setting price to product
			System.out.println("** If you buy more than 1500 units you would pay $0.19 per unit.");
		} else if (units > 1499) {
			price = units * bolt8Price * discount25; // setting price to product
		}
		return price;
	}
}