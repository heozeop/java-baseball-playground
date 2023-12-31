package baseball_v2;

public class PromptManager {
    public static String inputPrompt() {
        return "숫자를 입력해 주세요 : ";
    }

    public static String outputPrompt(BallsCompareResult result) {
        int strikes = result.strikes();
        int balls = result.balls();

        if (strikes < 1 && balls < 1) {
            return "낫싱";
        }

        StringBuilder builder = new StringBuilder();
        if(balls > 0) {
            builder.append(String.format("%d볼 ", balls));
        }

        if (strikes > 0) {
            builder.append(String.format("%d스트라이크", strikes));
        }

        return builder.toString();
    }

    public static String gameOverPrompt() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
