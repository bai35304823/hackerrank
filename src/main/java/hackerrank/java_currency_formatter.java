package hackerrank;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class java_currency_formatter {
	/*
	 * Sample Input
	 * 
	 * 12324.134 
	 * Sample Output
	 * 
	 * US: $12,324.13 India: Rs.12,324.13 China: ￥12,324.13 France: 12 324,13 €
	 */
	
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    double payment = scanner.nextDouble();
	    scanner.close();

	    NumberFormat f1 = NumberFormat.getCurrencyInstance(Locale.US);
	    NumberFormat f2 = NumberFormat.getCurrencyInstance(Locale.CHINA);
	    NumberFormat f3 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	    Locale l = new Locale("en","in");
	    Currency r = Currency.getInstance(l);
	    NumberFormat f = NumberFormat.getCurrencyInstance(l);


	    System.out.println("US: " + f1.format(payment));
	    System.out.println("India: " + f.format(payment));
	    System.out.println("China: " + f2.format(payment));
	    System.out.println("France: " + f3.format(payment));
	}
}
