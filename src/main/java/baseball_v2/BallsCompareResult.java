package baseball_v2;

public record BallsCompareResult(int strikes, int balls) {
    boolean isGameOver(int numberLength) {
        return this.strikes == numberLength;
    }
}
