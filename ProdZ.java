/**
 * this class is dedicated to the products of type Z
 *
 */
public class ProdZ extends DollarCents {
	// declaring variables
	private double hose20; // here product number 5's price will be stored
	private double hose50; // here product number 6's price will be stored
	private double price; // here product 5/6 price will be stored after calculations

	/**
	 * constructor initializes variables
	 */
	public ProdZ() {
		// initializing variables
		hose20 = 10; // sets product number 5's price to 10 dollars
		hose50 = 15; // sets product number 6's price to 15 dollars

	}

	/**
	 * This method calculates whether user qualifies on seasonal discount, buy 3 pay
	 * for 2 during september 15- october 15 every year, based on the month-date
	 * combination from the date inputed in the beginning of the program, and
	 * calculates price of the products added
	 * 
	 * @param units units inputed by user
	 * @param day   day of the month int from 1-31
	 * @param month month int number 1-12
	 * @return price here product 6 price will be stored after calculations
	 */
	public double totalHose20(int units, int day, int month) {
		price = 0; // setting price to 0 to start calculatiion
		if ((month == 9 && day >= 15) || (month == 10 && day <= 15)) {
			for (int i = 0; i < units; i++) {
				price += hose20;
				if ((i != 0) && (i % 3 == 0)) {
					price -= hose20;
				}
			}
		} else {
			price = units * hose20; // setting price to product
		}
		return price;

	}

	/**
	 * This method calculates whether user qualifies on seasonal discount, buy 3 pay
	 * for 2 during september 15- october 15 every year, based on the month-date
	 * combination from the date inputed in the beginning of the program, and
	 * calculates price of the products added
	 * 
	 * @param units units inputed by user
	 * @param day   day of the month int from 1-31
	 * @param month month int number 1-12
	 * @return price here product 6 price will be stored after calculations
	 */
	public double totalHose50(int units, int day, int month) {
		price = 0; // setting price to 0 to start calculatiion
		if ((month == 9 && day >= 15) || (month == 10 && day <= 15)) {
			for (int i = 0; i < units; i++) {
				price += hose50;
				if ((i != 0) && (i % 3 == 0)) {
					price -= hose50;
				}
			}
		} else {
			price = units * hose50; // setting price to product
		}
		return price;
	}
}
