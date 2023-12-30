import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class NumberBaseballGameTest {

    int targetNumberLength = 3;
    NumberBaseballGame game = new NumberBaseballGame(targetNumberLength);

    @Test
    void 시작하면_게임상태는_ON_GOING() {
        assertThat(game.currentGameStatus()).isEqualTo(GameStatus.ON_GOING);
    }

    @Test
    void 랜덤_넘버_생성() {
        String[] source = game.getRandomNumberList();

        Set<String> set = new HashSet<>(Arrays.asList(source));

        assertThat(source.length).isEqualTo(set.size());
    }

    @Test
    void 스트라이크_확인() {
        String[] numbers = {"1", "2", "3"};
        String[] compare = {"1", "2", "3"};

        assertThat(game.calculateStrike(compare, numbers)).isEqualTo(3);
    }
}