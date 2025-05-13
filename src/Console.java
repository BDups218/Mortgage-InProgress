import java.util.Scanner;

public class Console {
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        System.out.print(prompt);
        while (true) {

            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.print("Please enter a number between " + min + " and " + max + ": ");
        }
        return value;
    }



}
