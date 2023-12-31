import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    StringCalculator calculator;

    StringCalculatorTest() {
        this.calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 - 2 - 3:-4"}, delimiter = ':')
    void 문자열_계산(String inputString, int expected) {
        String[] target = inputString.split(" ");

        assertThat(calculator.calculate(target)).isEqualTo(expected);
    }
}