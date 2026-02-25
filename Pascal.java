import java.util.Scanner;

public class Pascal {
    public static int[] printPascal(int line, int totalLines) {
        int[] toReturn = new int[line];
        int[] prevLine;

        if (line < 1) {
            throw new IllegalArgumentException("Number of lines must be greater than zero.");
        } else if (line == 1) {
            toReturn[0] = 1;
        } else {
            prevLine = printPascal(line - 1, totalLines);

            for (int i = 1; i < line - 1; i++) {
                toReturn[i] = prevLine[i - 1] + prevLine[i];
            }

            toReturn[0] = 1;
            toReturn[line - 1] = 1;
        }

        for (int s = 0; s < totalLines - line; s++) { // add spaces to center
            System.out.print(" "); // spacing to center doesn't account for multi-digit numbers, 
        }                          // but in order for it to do so the program would be less preformant

        for (int i = 0; i < line; i++) {
            System.out.print(toReturn[i]);
            if (i != line - 1) {
                System.out.print(" "); // space between numbers
            }
        }
        System.out.println();

        return toReturn;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
		    System.out.println("Cleaning up...");
            input.close();
		}));

        System.out.println("How many lines of Pascal's Triangle would you like?");
        int lineNum = Integer.valueOf(input.nextLine());
        System.out.println();

        printPascal(lineNum, lineNum);
    }
}