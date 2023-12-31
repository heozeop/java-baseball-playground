package baseball_v2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void 볼들과_하나의_볼을_비교() {
        Ball strike = new Ball(1, 1);
        Ball ball = new Ball(2, 1);
        Ball nothing = new Ball(1,4);

        Balls balls = new Balls(new int[]{1, 2, 3});

        assertThat(balls.compare(strike).isStrike()).isTrue();
        assertThat(balls.compare(ball).isBall()).isTrue();
        assertThat(balls.compare(nothing).isNothing()).isTrue();
    }

    @Test
    void 볼들과_볼들_비교_3스트라이크() {
        Balls base = new Balls(new int[]{1,2,3});
        Balls threeStrike = new Balls(new int[]{1, 2, 3});

        BallsCompareResult result = base.compare(threeStrike);

        assertThat(result.strikes()).isEqualTo(3);
        assertThat(result.balls()).isEqualTo(0);
    }

    @Test
    void 볼들과_볼들_비교_1볼_1스트라이크() {
        Balls base = new Balls(new int[]{1,2,3});
        Balls threeStrike = new Balls(new int[]{1, 3, 5});

        BallsCompareResult result = base.compare(threeStrike);

        assertThat(result.strikes()).isEqualTo(1);
        assertThat(result.balls()).isEqualTo(1);
    }
    @Test
    void 볼들과_볼들_비교_낫띵() {
        Balls base = new Balls(new int[]{1,2,3});
        Balls threeStrike = new Balls(new int[]{4, 5, 6});

        BallsCompareResult result = base.compare(threeStrike);

        assertThat(result.strikes()).isEqualTo(0);
        assertThat(result.balls()).isEqualTo(0);
    }
}
