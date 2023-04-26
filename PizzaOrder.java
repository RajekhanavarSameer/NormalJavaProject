package Pizza;
import java.util.*;
import java.util.Scanner;

import com.qualys.entity.Pizza;

//TASK #5 add an import statement to use the DecimalFormat class
import java.text.DecimalFormat;

public class PizzaOrder
{
	public static void main (String [] args)
	{
		//TASK #5 Create a DecimalFormat object with 2 decimal places
		DecimalFormat money = new DecimalFormat ("#0.00");
		//Create a Scanner object to read input
		Scanner keyboard = new Scanner (System.in);

		//Create an instance of a Pizza
		Pizza order = new Pizza ();

		String firstName;		//user's first name
		boolean discount = false;//flag, true if user is eligible for discount
		int inches;				//size of the pizza
		char crustType;			//type of crust
		double cost;			//cost of the pizza
		final double TAX_RATE = .08;//sales tax rate
		double tax;				//amount of tax
		char choice;			//user's choice
		String input;			//user input
		String toppings = "Cheese ";//list of toppings
		int numberOfToppings = 0;	//number of toppings

		//prompt user and get first name
		System.out.println("Welcome to PizzaFactory");
		System.out.print("Enter your Resturent name(Hut, or Dom):  ");
		firstName = keyboard.nextLine();

		//determine if user is eligible for discount by
		//having the same first name as one of the owners
		//ADD LINES HERE FOR TASK #1
		if (firstName.equalsIgnoreCase("Hut") || firstName.equalsIgnoreCase("Dom"))
			discount= true;


		//prompt user and get pizza size choice
		System.out.println("Pizza Size (Regular)   Cost");
		System.out.println("        10            Rs.150");
		System.out.println("        12            Rs.175");
		System.out.println("        14            Rs.160");
		System.out.println("        16            Rs.190");
		System.out.println("What size pizza would you like?");
		System.out.print("10, 12, 14, or 16 (enter the number only): ");
		inches = keyboard.nextInt();

		//set price and size of pizza ordered
		//ADD LINES HER FOR TASK #2
		if (inches == 10)
		{
			order.setSize(10);
			order.setCost(-2);
		}
		else if (inches ==12)
		{
			order.setSize(12);
			order.setCost(0);
		}
		else if (inches == 14)
		{
			order.setSize(14);
			order.setCost(2);
		}
		else if (inches == 16)
		{
			order.setSize(16);
			order.setCost(4);
		}
		else
		{
			System.out.print("User input was not one of the choices, so a 12 inch pizza will be made");
			order.setSize(12);
			order.setCost(0);
		}
		//consume the remaining newline character
		keyboard.nextLine();

		//prompt user and get crust choice
		System.out.println("What type of crust do you want? ");
		System.out.print("(H)Hand-tossed, (T) Thin-crust, or " +
			"(C) Cheese-Brust ,(P)Pan-pizza(enter H, T, C, or P): ");
		input = keyboard.nextLine();
		crustType = input.charAt(0);

		//set user's crust choice on pizza ordered
		//ADD LINES FOR TASK #3
		switch(crustType)
		{
			case 'H':
			case 'h':
				order.setCrust("Hand-Tossed");
				break;
			case 'T':
			case 't':
				order.setCrust("Thin-Crust");
				break;
			case 'C':
			case 'c':
				order.setCrust("Cheese-Brust");
				break;
			case 'P':
			case 'p':
				order.setCrust("Pan-pizza");
				break;
			default:
				System.out.print("User's input not one of the choices, so a hand tossed crust will be made");
				order.setCrust("Cheese-Brust");
		}

		//prompt user and get topping choices one at a time
		System.out.println("All pizzas come with cheese.");
		System.out.println("Additional toppings are Rs30 each,"
				+ " choose from");
		System.out.println("Pepperoni, Sausage, Onion, Mushroom");

		//if topping is desired,
		//add to topping list and number of toppings
		System.out.print("Do you want Pepperoni?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Pepperoni ";
		}
		System.out.print("Do you want Sausage?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Sausage ";
		}
		System.out.print("Do you want Onion?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Onion ";
		}
		System.out.print("Do you want Mushroom?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Mushroom ";
		}

		//set number of toppings and topping list on pizza ordered
		order.setNumToppings (numberOfToppings);
		order.setToppingList(toppings);

		//add additional toppings cost to cost of pizza
		order.setCost(30*numberOfToppings);

		//display order confirmation
		System.out.println();
		System.out.println("Your order is as follows: ");
		System.out.println(order.getSize() + " inch pizza");
		System.out.println(order.getCrust() + " crust");
		System.out.println(order.getToppingList());

		//apply discount if user is elibible
		//ADD LINES FOR TASK #4 HERE
		if (discount==true)
		{
			System.out.print("User is eligable for a Rs10 discount. ");
			order.setCost(-2);
		}

		//EDIT PROGRAM FOR TASK #5
		//SO ALL MONEY OUTPUT APPEARS WITH 2 DECIMAL PLACES
		//display cost of pizza
		cost = order.getCost();
		System.out.println("The cost of your order is: Rs" + money.format(cost));

		//calculate and display tax and total cost
		tax = cost * TAX_RATE;
		System.out.println("The tax is:  Rs" + money.format(tax));
		System.out.println("The total due is:  Rs" + money.format(tax + cost));

		System.out.println("Your order will be ready" +
			" for pickup in 30 minutes.");
	}
}
