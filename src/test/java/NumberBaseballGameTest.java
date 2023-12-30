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

    @Test
    void 볼_확인() {
        String[] numbers = {"1", "2", "3"};
        String[] compare = {"1", "2", "3"};
        int numberOfStrike = 3;
        assertThat(game.calculateBall(numbers, compare, numberOfStrike)).isEqualTo(0);

        compare = new String[]{"2", "3", "1"};
        numberOfStrike = 0;
        assertThat(game.calculateBall(numbers, compare, numberOfStrike)).isEqualTo(3);

        compare = new String[]{"1", "3", "2"};
        numberOfStrike = 1;
        assertThat(game.calculateBall(numbers, compare, numberOfStrike)).isEqualTo(2);

        compare = new String[]{"1", "4", "2"};
        numberOfStrike = 1;
        assertThat(game.calculateBall(numbers, compare, numberOfStrike)).isEqualTo(1);
    }

    @Test
    void 스트라이크_볼_확인() {
        String[] numbers = {"1", "2", "3"};
        String[] compare = {"1", "2", "3"};

        BaseballGameResult data = game.calculate(numbers, compare);
        assertThat(data.numberOfStrike).isEqualTo(3);
        assertThat(data.numberOfBall).isEqualTo(0);

        compare = new String[]{"2", "3", "1"};
        data = game.calculate(numbers, compare);
        assertThat(data.numberOfStrike).isEqualTo(0);
        assertThat(data.numberOfBall).isEqualTo(3);

        compare = new String[]{"1", "3", "2"};
        data = game.calculate(numbers, compare);
        assertThat(data.numberOfStrike).isEqualTo(1);
        assertThat(data.numberOfBall).isEqualTo(2);

        compare = new String[]{"1", "4", "2"};
        data = game.calculate(numbers, compare);
        assertThat(data.numberOfStrike).isEqualTo(1);
        assertThat(data.numberOfBall).isEqualTo(1);
    }
}