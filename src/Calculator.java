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
        switch (operation) {
            case "+":
                double number = toNumber(input("Введите число: "));
                sum(number);
                output();
                break;
            case "-":
                double subtrahend = toNumber(input("Введите число: "));
                subtract(subtrahend);
                output();
                break;
            case "*":
                double multiplier = toNumber(input("Введите число: "));
                multiply(multiplier);
                output();
                break;
            case "/":
                double divisor = toNumber(input("Введите число: "));
                divide(divisor);
                output();
                break;
            case "C":
            case "c":
                reset();
                output();
                currentValue = toNumber(input("Введите число: "));
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
        currentValue = toNumber(input("Введите число: "));

        while (isRunning) {
            String operation = input("Введите операцию: +, -, *, /, C — сброс, S — выход");
            executeOperation(operation);
        }

        scanner.close();
    }
}
