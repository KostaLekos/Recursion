import java.util.Scanner;

public class Pascal {
    public static int[] genPascal(int line) {
        int[] toReturn = new int[line];
        int[] prevLine;

        if (line < 1) {
            throw new IllegalArgumentException("Number of lines must be greater than zero.");
        } else if (line == 1) {
            toReturn[0] = 1;
        } else {
            prevLine = genPascal(line - 1);

            for (int i = 1; i < line - 1; i++) {
                toReturn[i] = prevLine[i - 1] + prevLine[i];
            }

            toReturn[0] = 1;
            toReturn[line - 1] = 1;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
		    System.out.println("Cleaning up...");
		}));

        System.out.println("How many lines of Pascal's Triangle would you like?");
        int lineNum = Integer.valueOf(input.nextLine());
        System.out.println();

        int[] line;
        for (int i = 1; i <= lineNum; i++) {
            System.out.print(" ");
            line = genPascal(i);

            for (int j = 0; j < line.length; j++) {
                System.out.print(line[j]);
                if (j != line.length - 1) {
                    System.out.print(" "); // space between numbers
                }
            }
            System.out.println();
        }
        input.close();
    }
}