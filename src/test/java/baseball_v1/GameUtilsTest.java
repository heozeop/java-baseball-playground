package baseball_v1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball_v1.GameUtils;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameUtilsTest {

    @Test
    void 랜덤하게_n개_길이_추출() {
        List<String> source = Arrays.asList("1", "2", "3", "4");
        List<String> result = GameUtils.pickNRandom(source, 3);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 추출하려하는_수가_원본_길이보다_길면_셔플한_결과_리턴() {
        List<String> source = Arrays.asList("1", "2", "3", "4");
        List<String> result = GameUtils.pickNRandom(source, 7);
        assertThat(result.size()).isEqualTo(source.size());
    }
}