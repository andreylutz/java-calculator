import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static double currentValue = 0;
    private static boolean isRunning = false;

    public static void main(String[] args) {
        run();
    }

    private static double toNumber(String value) {
        return Double.parseDouble(value);
    }

    private static String input(String message) {
        System.out.println(message);
        return scanner.next();
    }

    private static void reset() {
        currentValue = 0;
    }

    private static void run() {
        currentValue = toNumber(input("Введите число: "));

        while (isRunning) {
            String operation = input("Введите операцию: ");
            System.out.println("Оператор: " + operation);
        }

        scanner.close();
    }
}