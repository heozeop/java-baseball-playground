package baseball_v1;

public class ResultView {
    static String prompt(int strike, int ball) {
        if (ball < 1 && strike < 1)  {
            return "낫싱";
        }

        StringBuilder buffer = new StringBuilder();

        if (ball > 0) {
            buffer.append(String.format("%d 볼 ", ball));
        }

        if (strike > 0) {
            buffer.append(String.format("%d 스트라이크", strike));
        }

        return buffer.toString();
    }
}
