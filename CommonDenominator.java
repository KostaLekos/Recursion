import java.util.Scanner;

public class CommonDenominator {

	public static String findCommonDenominator(int num1, int num2, int den1, int den2) {
		if (den1 == den2) {
			return ((num1 + num2) + "/" + den1);
		} else if (den1 > den2) {
			findCommonDenominator(num1, num2 * 2, den1, den2 * 2);
		} else {
			findCommonDenominator(num1 * 2, num2, den1 * 2, den2);
		}
		return "Error";
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a fraction ('x/y' format):");
		String frac1 = input.nextLine();

		System.out.println("Now enter another fraction to add to the first:");
		String frac2 = input.nextLine();

		System.out.println(frac1 + " + " + frac2 + " = " + findCommonDenominator(Integer.valueOf(frac1.substring(0, frac1.indexOf("/"))), 
		Integer.valueOf(frac2.substring(0, frac2.indexOf("/"))), Integer.valueOf(frac1.substring(frac1.indexOf("/") + 1)), 
		Integer.valueOf(frac2.substring(frac2.indexOf("/") + 1))));

	}
}
