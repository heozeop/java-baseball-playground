package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String value = "1,2";
        String[] splitValue = value.split(",");

        assertThat(splitValue).contains("1", "2");

        value = "1";
        splitValue = value.split(",");

        assertThat(splitValue).containsExactly("1");
    }

    @Test
    void stringWithParenthesis() {
        String target = "(1,2)";

        String subTarget = target.substring(1,4);

        assertThat(subTarget).isEqualTo("1,2");
    }

    @DisplayName("chatAt 에서 찾고자 하는 내용이 없는 경우 에러 확인")
    @Test
    void chatAtErrorTest() {
        String target = "abc";
        int targetLength = target.length();
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            target.charAt(targetLength + 1);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
