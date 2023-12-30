package study;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
