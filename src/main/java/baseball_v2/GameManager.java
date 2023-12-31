package baseball_v2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import javax.lang.model.element.UnknownElementException;
import javax.lang.model.type.UnknownTypeException;

public class GameManager {

    public static final int NUMBER_LENGTH = 3;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isGameOver = false;
        while(!isGameOver) {
            isGameOver = play();
        }
    }

    private static boolean play() {
        Balls balls = new Balls(RandomNumberGenerator.generate(NUMBER_LENGTH), NUMBER_LENGTH);

        boolean isGameOver = false;
        while(!isGameOver) {
            isGameOver = step(balls);
        }

        System.out.println(PromptManager.gameOverPrompt());
        String gameResult = scanner.nextLine();

        return checkGameOver(gameResult);
    }

    private static boolean step(Balls balls) {
        System.out.print(PromptManager.inputPrompt());
        String numberString = scanner.nextLine();
        if (!InputNumberValidator.validate(numberString, NUMBER_LENGTH)) {
            System.out.println("정확한 숫자의 입력을 부탁드립니다.");
            return false;
        }

        Balls inputBalls = new Balls(
            Arrays.stream(numberString.split("")).mapToInt(Integer::parseInt).toArray(),
            NUMBER_LENGTH
        );

        BallsCompareResult result = balls.compare(inputBalls);
        System.out.println(PromptManager.outputPrompt(result));

        return result.isGameOver(NUMBER_LENGTH);
    }

    private static boolean checkGameOver(String gameResult) {
        if (Objects.equals(gameResult, "1")) {
            return false;
        }

        if(Objects.equals(gameResult, "2")) {
            return true;
        }

        throw new UnknownError("알 수 없는 입력입니다.");
    }
}
