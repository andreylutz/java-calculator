import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static double currentValue = 0;
    private static boolean isRunning = false;
    private static boolean hasResult = false;

    public static void main(String[] args) {
        run();
    }

    private static double toNumber(String value) {
        return Double.parseDouble(value);
    }

    private static String formatNumber(double number) {
        if (number == (long) number) {
            return Long.toString((long) number);
        }
        return Double.toString(number);
    }

    private static String input(String message) {
        System.out.print(message);
        return scanner.next();
    }

    private static void output(double firstNumber, String operation, double secondNumber) {
        System.out.println();
        System.out.println(formatNumber(firstNumber) + " " + operation + " "
                + formatNumber(secondNumber) + " = " + formatNumber(currentValue));
        System.out.println();
        hasResult = true;
    }

    private static void reset() {
        currentValue = 0;
        hasResult = false;
    }

    private static void sum(double number) {
        currentValue += number;
    }

    private static void subtract(double number) {
        currentValue -= number;
    }

    private static void multiply(double number) {
        currentValue *= number;
    }

    private static void divide(double number) {
        if (number == 0) {
            System.out.println("Ошибка: деление на ноль. Текущий результат не изменён.");
            return;
        }
        currentValue /= number;
    }

    private static void executeOperation(String operation) {
        double firstNumber = currentValue;
        switch (operation) {
            case "+":
                double number = toNumber(input("Число: "));
                sum(number);
                output(firstNumber, operation, number);
                break;
            case "-":
                double subtrahend = toNumber(input("Число: "));
                subtract(subtrahend);
                output(firstNumber, operation, subtrahend);
                break;
            case "*":
                double multiplier = toNumber(input("Число: "));
                multiply(multiplier);
                output(firstNumber, operation, multiplier);
                break;
            case "/":
                double divisor = toNumber(input("Число: "));
                divide(divisor);
                if (divisor != 0) {
                    output(firstNumber, operation, divisor);
                }
                break;
            case "C":
            case "c":
                reset();
                System.out.println("Результат сброшен: 0");
                currentValue = toNumber(input("Число: "));
                break;
            case "S":
            case "s":
                isRunning = false;
                break;

            default:
                System.out.println("Неизвестная операция.");
                break;
        }
    }

    private static void run() {
        isRunning = true;
        currentValue = toNumber(input("Число: "));

        while (isRunning) {
            String message = hasResult
                    ? "Продолжить с " + formatNumber(currentValue) + " (+, -, *, /), сбросить (C) или выйти (S): "
                    : "Операция: ";
            String operation = input(message);
            executeOperation(operation);
        }

        scanner.close();
    }
}
