import java.util.Scanner;

public class CommonDenominator {

	public static int greatestCommonDivisor(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return greatestCommonDivisor(y, x % y);
		}
	}

	public static String addFraction(String frac1, String frac2) {
		int num1 = Integer.valueOf((frac1.indexOf("/") == -1) ? frac1 : frac1.substring(0, frac1.indexOf("/")));
		int num2 = Integer.valueOf((frac2.indexOf("/") == -1) ? frac2 : frac2.substring(0, frac2.indexOf("/")));
		int den1 = (frac1.indexOf("/") == -1) ? 1 : Integer.valueOf(frac1.substring(frac1.indexOf("/") + 1));
		int den2 = (frac2.indexOf("/") == -1) ? 1 : Integer.valueOf(frac2.substring(frac2.indexOf("/") + 1));

		if (den1 == 0 || den2 == 0) {
			return "Divide by 0 error.";
		}

		int den3 = den1 * den2 / greatestCommonDivisor(den1, den2); // Least Common Denominator
		int num3 = (num1 * (den3 / den1)) + (num2 * (den3 / den2));

		int gcd = greatestCommonDivisor(num3, den3);
		num3 /= gcd;
		den3 /= gcd;
		
		return (den3 == 1) ? String.valueOf(num3) : (num3 + "/" + den3);		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a fraction ('x/y' format):");
		String frac1 = input.nextLine();

		System.out.println("\nNow enter another fraction to add to the first:");
		String frac2 = input.nextLine();

		System.out.println(frac1 + " + " + frac2 + " = " + addFraction(frac1, frac2) + "\n\n");

		main(null);
	}
}
