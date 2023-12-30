public class BaseballGameResult {
    int numberOfStrike;
    int numberOfBall;

    BaseballGameResult(int numberOfStrike, int numberOfBall) {
        this.numberOfStrike = numberOfStrike;
        this.numberOfBall = numberOfBall;
    }

    int getNumberOfStrike() {
        return numberOfStrike;
    }

    int getNumberOfBall() {
        return numberOfBall;
    }
}
