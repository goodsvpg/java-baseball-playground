package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitStringContainsCorrectValue() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void splitStringContainsExactlyCorrectValue() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("test chatAt() when IndexOutOfBoundsException throw")
    void testIndexOutOfBoundsExceptionUsingCharAt() {
        assertThatThrownBy(() -> { 
                            char wrong = "abc".charAt(4); 
                            assertThat(wrong).isEqualTo('c');
                        })
                        .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
