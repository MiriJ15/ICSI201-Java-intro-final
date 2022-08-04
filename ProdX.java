/**
 * this class is dedicated to the products of type X
 *
 */
public class ProdX extends DollarCents {
	// declaring some variables
	private double price; // here product 1/2 price will be stored after calculations
	private double bulb1Price; // here product number 1's price will be stores
	private double bulb2Price; // here product number 2's price will be stores

	/**
	 * constructor initializes variables
	 */
	public ProdX() {
		// initializing variables
		bulb1Price = 3.00; // sets product number 1's price to 3.00 dollars
		bulb2Price = 5.99; // sets product number 2's price to 5.99 dollars
	}

	/**
	 * this method calculates the price for the product number 1, depending on
	 * number of units inputed by the user
	 * 
	 * @param units units inputed by the user
	 * @return price here product 1 price will be stored after calculations
	 */
	public double totalBulb1(int units) {
		price = units * bulb1Price; // setting our price to the product
		return price;
	}

	/**
	 * this method calculates the price for the product number 2, depending on
	 * number of units inputed by the user
	 * 
	 * @param units units inputed by the user
	 * @return price here product 2 price will be stored after calculations
	 */
	public double totalBulb2(int units) {
		price = units * bulb2Price; // setting our price to the product
		return price;
	}
}
