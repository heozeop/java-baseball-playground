import java.util.Random;

public class NumberBaseballGame {
    private GameStatus gameStatus;
    private int targetNumber;

    NumberBaseballGame() {
        gameStatus = GameStatus.START;
        targetNumber = getRandomNumber();
        gameStatus = GameStatus.ON_GOING;
    }


    public GameStatus currentGameStatus() {
        return gameStatus;
    }

    public int getRandomNumber() {
        Random random = new Random(System.currentTimeMillis());

        return random.nextInt(899) + 100;
    }
}
