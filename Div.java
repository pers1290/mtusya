class CustomDivisionException extends Exception {
    public CustomDivisionException(String message) {
        super(message);
    }
}

public class Div {
    public static void main(String[] args) {
        try {
            double result = div(10, 0);
            System.out.println(result);
        } catch (CustomDivisionException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double div(double a, double b) throws CustomDivisionException {
        if (b == 0) {
            throw new CustomDivisionException("division error");
        }
        return a / b;
    }
}