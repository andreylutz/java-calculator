public class Calculator {
    private double currentValue = 0;

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public void reset() {
        currentValue = 0;
    }

    public void sum(double number) {
        currentValue += number;
    }

    public void subtract(double number) {
        currentValue -= number;
    }

    public void multiply(double number) {
        currentValue *= number;
    }

    public boolean divide(double number) {
        if (number == 0) {
            return false;
        }
        currentValue /= number;
        return true;
    }
}
