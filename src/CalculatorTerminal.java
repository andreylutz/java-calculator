import java.util.Scanner;

public class CalculatorTerminal {
    private final Scanner scanner = new Scanner(System.in);
    private final Calculator calculator = new Calculator();
    private boolean isRunning = false;
    private boolean hasResult = false;

    public static void main(String[] args) {
        new CalculatorTerminal().run();
    }

    private double toNumber(String value) {
        return Double.parseDouble(value);
    }

    private String formatNumber(double number) {
        if (number == (long) number) {
            return Long.toString((long) number);
        }

        return Double.toString(number);
    }

    private String input(String message) {
        System.out.print(message);
        return scanner.next();
    }

    private void output(double firstNumber, String operation, double secondNumber) {
        System.out.println();
        System.out.println(formatNumber(firstNumber) + " " + operation + " "  + formatNumber(secondNumber) + " = " + formatNumber(calculator.getCurrentValue()));
        System.out.println();
    }

    private void executeOperation(String operation) {
        double firstNumber = calculator.getCurrentValue();
        switch (operation) {
            case "+":
                double number = toNumber(input("Число: "));
                calculator.sum(number);
                hasResult = true;
                output(firstNumber, operation, number);
                break;
            case "-":
                double subtrahend = toNumber(input("Число: "));
                calculator.subtract(subtrahend);
                hasResult = true;
                output(firstNumber, operation, subtrahend);
                break;
            case "*":
                double multiplier = toNumber(input("Число: "));
                calculator.multiply(multiplier);
                hasResult = true;
                output(firstNumber, operation, multiplier);
                break;
            case "/":
                double divisor = toNumber(input("Число: "));
                if (calculator.divide(divisor)) {
                    hasResult = true;
                    output(firstNumber, operation, divisor);
                } else {
                    System.out.println("Ошибка: деление на ноль. Текущий результат не изменён.");
                }
                break;
            case "C":
            case "c":
                calculator.reset();
                hasResult = false;
                System.out.println("Результат сброшен: 0");
                calculator.setCurrentValue(toNumber(input("Число: ")));
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

    private void run() {
        isRunning = true;
        calculator.setCurrentValue(toNumber(input("Число: ")));

        while (isRunning) {
            String message = hasResult
                    ? "Продолжить с " + formatNumber(calculator.getCurrentValue()) + " (+, -, *, /), сбросить (C) или выйти (S): "
                    : "Операция: ";

            String operation = input(message);
            executeOperation(operation);
        }

        scanner.close();
    }
}
