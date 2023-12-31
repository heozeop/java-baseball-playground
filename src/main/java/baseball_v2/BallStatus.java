package baseball_v2;

public enum BallStatus {
    STRIKE, NOTHING, BALL;

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }
}
