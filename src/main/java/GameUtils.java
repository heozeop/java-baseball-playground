import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameUtils {
    public static List<String> pickNRandom(List<String> list, int number) {
        List<String> copy = new ArrayList<>(list);

        Collections.shuffle(copy);

        if (number >= copy.size()) {
            return copy;
        }

        return copy.subList(0, number);
    }
}
