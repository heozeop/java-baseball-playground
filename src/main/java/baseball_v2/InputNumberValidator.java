package baseball_v2;

public class InputNumberValidator {

    public static boolean validate(String numberString, int length) {
        if (numberString.length() != length) {
            return false;
        }

        return numberString.matches("[1-9]+");
    }
}
