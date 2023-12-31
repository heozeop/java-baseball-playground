package baseball_v2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class InputNumberValidatorTest {
    @Test
    void 입력이_숫자만_들어오는지_확인() {
        assertThat(InputNumberValidator.validate("123",3)).isTrue();
        assertThat(InputNumberValidator.validate("12a",3)).isFalse();
    }

    @Test
    void 입력이_1_9만_들어오는지_확인(){
        assertThat(InputNumberValidator.validate("103", 3)).isFalse();
    }

    @Test
    void 입력에_길이를_확인() {
        assertThat(InputNumberValidator.validate("123", 4)).isFalse();
        assertThat(InputNumberValidator.validate("123", 3)).isTrue();
    }
}
