import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame(3);

        playGame(numberBaseballGame);
    }

    private static void playGame(NumberBaseballGame game) {
        Scanner in = new Scanner(System.in);
        game.gameStart();

        String isOnGoing = "1";
        while(isOnGoing.equals("1")) {
            isOnGoing = eachStep(game, in);
        }
    }

    private static String eachStep(NumberBaseballGame game, Scanner in) {
        String isOnGoing = "1";

        System.out.print(InputView.prompt());
        String inputNumber = in.nextLine();

        BaseballGameResult result = game.calculate(inputNumber.split(""));
        System.out.println(ResultView.prompt(result.numberOfStrike, result.numberOfBall));

        if (result.numberOfStrike == 3) {
            System.out.println(GameOverView.prompt());

            isOnGoing = in.nextLine();
            game.gameStart();
        }

        return isOnGoing;
    }

}
