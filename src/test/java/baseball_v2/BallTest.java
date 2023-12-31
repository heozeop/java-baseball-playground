package baseball_v2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    void 숫자만_같으면_볼() {
        Ball base = new Ball(1,2);
        Ball compare = new Ball(2, 2);

        assertThat(base.compare(compare).isBall()).isTrue();
    }

    @Test
    void 숫자와_포지션이_같으면_스트라이크() {
        Ball base = new Ball(1,2);
        Ball compare = new Ball(1, 2);

        assertThat(base.compare(compare).isStrike()).isTrue();
    }

    @Test
    void 숫자가_다르면_낫띵() {
        Ball base = new Ball(1,2);
        Ball compare = new Ball(3, 5);

        assertThat(base.compare(compare).isNothing()).isTrue();
    }
}
