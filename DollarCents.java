import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException; // needed for LocalDate type
import java.util.Arrays;

/**
 * ICSI 201. Introduction to computer science. Fall 2021. HW3
 * 
 * @author Mir-Mammad Javad-zada. 001404463 TA: Josue Ruiz In this project user
 *         will input the date in order to get access to our awesome inventory
 *         with 6 items with 3 different pricing models including, seasonal
 *         discount type and multiple unit discount one. program will add up
 *         products chosen by the user till user decides to stop, and prints to
 *         user the total amount of dollars and cents for the transaction, and
 *         creates adds receipt to bill.txt file.
 */
public class DollarCents {
	public static void main(String[] arg) throws ParseException, IOException {

		Order o = new Order(); // creating Order object
		// starting our shop program
		o.order();
}
}
