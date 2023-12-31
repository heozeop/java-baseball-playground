package baseball_v2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    public static final int NUMBER_LENGTH = 3;

    @Test
    void 랜덤_숫자는_주어진_자리수() {
        assertThat(
            RandomNumberGenerator.generate(NUMBER_LENGTH).length
        ).isEqualTo(NUMBER_LENGTH);
    }

    @Test
    void 랜덤_숫자는_1자리에서_9자리까지() {
        assertThat(RandomNumberGenerator.generate(10).length).isEqualTo(9);
        assertThat(RandomNumberGenerator.generate(9).length).isEqualTo(9);
        assertThat(RandomNumberGenerator.generate(1).length).isEqualTo(1);
        assertThat(RandomNumberGenerator.generate(0).length).isEqualTo(1);
    }

    @Test
    void 랜덤_숫자는_각_자리_수가_다름() {
        int[] numberList = RandomNumberGenerator.generate(NUMBER_LENGTH);
        HashSet<Integer> numberSet = new HashSet<>(Arrays.stream(numberList).boxed().toList());

        assertThat(numberList.length).isEqualTo(numberSet.size());
    }
}
