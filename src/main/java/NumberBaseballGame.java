import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class NumberBaseballGame {
    private GameStatus gameStatus;
    private String[] targetNumberArray;
    private int targetNumberLength;

    NumberBaseballGame(int targetNumberLength) {
        isValidTargetNumberLength(targetNumberLength);
        this.targetNumberLength = targetNumberLength;
    }

    private void isValidTargetNumberLength(int targetNumberLength) {
        if(targetNumberLength > 10)  {
            throw new UnsupportedOperationException("target number length should be less than 10");
        }

    }

    NumberBaseballGame(int targetNumberLength, String[] targetNumberArray) {
        isValidTargetNumberLength(targetNumberLength);

        this.targetNumberLength = targetNumberLength;
        this.targetNumberArray = targetNumberArray;
    }

    public void gameStart() {
        targetNumberArray = getRandomNumberList();
    }

    public BaseballGameResult calculate(String[] numberArray) {
        int numberOfStrike = calculateStrike(numberArray);
        int numberOfBall = calculateBall(numberArray, numberOfStrike);

        return new BaseballGameResult(numberOfStrike, numberOfBall);
    }

    public int calculateStrike(String[] numberArray) {
        int count = 0;

        for(int i = 0; i < targetNumberLength; ++i) {
            count += Boolean.compare(Objects.equals(targetNumberArray[i],numberArray[i]), false);
        }

        return count;
    }

    public int calculateBall(String[] numberArray, int numberOfStrike) {
        Set<String> set = new HashSet<>();

        set.addAll(Arrays.asList(targetNumberArray));
        set.addAll(Arrays.asList(numberArray));

        return targetNumberArray.length + numberArray.length - set.size() - numberOfStrike;
    }

    public String[] getRandomNumberList() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

        List<String> subNumbers = GameUtils.pickNRandom(numbers, targetNumberLength);
        if (Objects.equals(subNumbers.get(0), "0")) {
            subNumbers.set(0,subNumbers.get(1));
            subNumbers.set(1, "0");
        }

        return numbers.toArray(new String[targetNumberLength]);
    }

}
