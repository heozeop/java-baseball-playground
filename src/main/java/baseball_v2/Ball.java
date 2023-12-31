package baseball_v2;

public class Ball {

    private final int position;
    private final int ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus compare(Ball compare) {
        if (ballNumber != compare.ballNumber) {
            return BallStatus.NOTHING;
        }

        if (position != compare.position) {
            return BallStatus.BALL;
        }

        return BallStatus.STRIKE;
    }
}
