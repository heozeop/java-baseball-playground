import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberBaseballGameTest {

    NumberBaseballGame game = new NumberBaseballGame();

    @Test
    void 시작하면_게임상태는_ON_GOING() {
        assertThat(game.currentGameStatus()).isEqualTo(GameStatus.ON_GOING);
    }

    @Test
    void 랜덤_넘버_생성() {
        assertThat(game.getRandomNumber()).isGreaterThanOrEqualTo(100).isLessThan(1000);
    }

    @Test
    void 스트라이크_확인() {
        String[] numbers = {"1", "2", "3"};
        String[] compare = {"1", "2", "3"};

        assertThat(game.calculateStrike(compare, numbers)).isEqualTo(3);
    }
}