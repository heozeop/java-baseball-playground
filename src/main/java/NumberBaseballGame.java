import java.util.Objects;
import java.util.Random;

public class NumberBaseballGame {
    private GameStatus gameStatus;
    private String[] targetNumberString;
    private int targetNumberLength;

    NumberBaseballGame() {
        gameStart();
    }

    private void gameStart() {
        gameStatus = GameStatus.START;
        targetNumberString = String.valueOf(getRandomNumber()).split("");
        targetNumberLength = targetNumberString.length;
        gameStatus = GameStatus.ON_GOING;
    }

    public int calculateStrike(String[] targetNumberString, String[] numberString) {
        int count = 0;

        for(int i = 0; i < targetNumberLength; ++i) {
            count += Boolean.compare(Objects.equals(targetNumberString[i],numberString[i]), false);
        }

        return count;
    }

    public GameStatus currentGameStatus() {
        return gameStatus;
    }

    public int getRandomNumber() {
        Random random = new Random(System.currentTimeMillis());

        return random.nextInt(899) + 100;
    }
}
