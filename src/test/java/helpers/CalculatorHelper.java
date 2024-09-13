package helpers;

public class CalculatorHelper {

    public static double calculate(double num1, double num2, String operation) {
        double result = 0.0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return roundToTwoDigits(result);
    }

    public static double roundToTwoDigits(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
