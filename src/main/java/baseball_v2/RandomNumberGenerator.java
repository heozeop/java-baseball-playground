package baseball_v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public static final Integer[] INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static int[] generate(int numberLength) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(INTEGERS));

        Collections.shuffle(numbers);

        return numbers.subList(0, Math.max(Math.min(numberLength, 9), 1)).stream().mapToInt(i -> i).toArray();
    }
}
