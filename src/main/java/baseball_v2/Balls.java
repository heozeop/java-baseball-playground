package baseball_v2;

import java.util.ArrayList;

public class Balls {

    private final ArrayList<Ball> balls;
    private final int ballLength;

    public Balls(int[] numbers, int ballLength) {
        balls = new ArrayList<>();
        this.ballLength = ballLength;

        if(ballLength != numbers.length) {
            throw new IllegalArgumentException("number list의 길이가 맞지 않습니다.");
        }

        for(int i = 0; i < ballLength; ++i) {
            balls.add(new Ball(i + 1, numbers[i]));
        }
    }

    public BallStatus compare(Ball ballToCompare) {
        return balls.stream()
            .map(ball -> ball.compare(ballToCompare))
            .filter(status -> status != BallStatus.NOTHING)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    public BallsCompareResult compare(Balls ballsToCompare) {
        int numberOfStrike = 0;
        int numberOfBall = 0;

        for (Ball ball : balls) {
            BallStatus status = ballsToCompare.compare(ball);

            numberOfStrike += Boolean.compare(status.isStrike(), false);
            numberOfBall += Boolean.compare(status.isBall(), false);
        }

        return new BallsCompareResult(numberOfStrike, numberOfBall);
    }
}
