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

    private static void output() {
        System.out.println("Результат: ");

        if (currentValue == (long) currentValue) {
            System.out.println((long) currentValue);
            return;
        }

        System.out.println(currentValue);
    }

    private static void reset() {
        currentValue = 0;
    }

    private static void sum(double number) {
        currentValue += number;
    }

    private static void executeOperation(String operation) {
        switch (operation) {
            case "+":
                double number = toNumber(input("Введите число: "));
                sum(number);
                output();
                break;
            default:
                System.out.println("Неизвестная операция.");
                break;
        }
    }

    private static void run() {
        isRunning = true;
        currentValue = toNumber(input("Введите число: "));

        while (isRunning) {
            String operation = input("Введите операцию: +");
            executeOperation(operation);
        }

        scanner.close();
    }
}