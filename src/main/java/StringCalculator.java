import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StringCalculator {
    enum CalculateOperators {
        PLUS("+"),
        MINUS("-"),
        MULTIPLE("*"),
        DIVIDE("/"),
        ;

        private final String calculateOperator;
        CalculateOperators(String calculateOperator) {
            this.calculateOperator = calculateOperator;
        }

        public static boolean isOperator(String value) {
            for(CalculateOperators calculateOperators : values()) {
                if(calculateOperators.calculateOperator.equals(value)) {
                    return true;
                }
            }

            return false;
        }

        public static CalculateOperators fromString(String value) {
            CalculateOperators result = null;

            for(CalculateOperators calculateOperators : values()) {
                if(calculateOperators.calculateOperator.equals(value)) {
                    result = calculateOperators;
                    break;
                }
            }

            return result;
        }
    }

    public int calculate(String[] target) {
        List<CalculateOperators> operators = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        splitTargetIntoOperatorsAndNumbers(target, operators, numbers);
        isCalculable(operators, numbers);

        int numbersLength = numbers.size();
        int operatorPointer = 0;
        int numberPointer = 1;

        Integer answer = numbers.get(0);
        for (; numberPointer < numbersLength; ++ numberPointer, ++operatorPointer) {
            answer = operate(
                    operators.get(operatorPointer),
                    answer,
                    numbers.get(numberPointer)
            );
        }

        return answer;
    }

    private static void splitTargetIntoOperatorsAndNumbers(String[] target, List<CalculateOperators> operators, List<Integer> numbers) {
        for(String item : target) {
            CalculateOperators operator = CalculateOperators.fromString(item);
            if (operator == null) {
                numbers.add(Integer.parseInt(item));
                continue;
            }

            operators.add(operator);
        }
    }

    private static void isCalculable(List<CalculateOperators> operators, List<Integer> numbers) {
        int numberLength = numbers.size();
        int operatorLength = operators.size();

        if (numbers.size() < 1 || numberLength - 1 != operatorLength) {
            throw new UnsupportedOperationException("number size should be larger than 0");
        }
    }

    private List<CalculateOperators> filterOperator(String[] target) {
        return Arrays.stream(target).filter(CalculateOperators::isOperator).map(CalculateOperators::fromString).collect(Collectors.toList());
    }

    private List<Integer> filterNumber(String[] target) {
        return Arrays.stream(target).filter(this::isNumeric).map(Integer::parseInt).collect(Collectors.toList());
    }
    
    private boolean isNumeric(String input) {
        return input != null && input.matches("[0-9.]+");
    }

    private Integer operate(CalculateOperators calculateOperators, Integer value1, Integer value2) {
        switch(calculateOperators) {
            case PLUS:
                return value1 + value2;
            case MINUS:
                return value1 - value2;
            case MULTIPLE:
                return value1 * value2;
            case DIVIDE:
                return value1 / value2;
            default:
                throw new UnsupportedOperationException("operator not found");
        }
    }
}
