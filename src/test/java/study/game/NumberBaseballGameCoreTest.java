package study.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballGameCoreTest {
    private NumberBaseballGameCore numberBaseballGameCore = new NumberBaseballGameCore();

    @ParameterizedTest 
    @CsvSource(value = {"12, false", "123, true", "12345, false"})
    public void testIsValidLength(String input, boolean expect) {
        boolean result = numberBaseballGameCore.isValidLength(input);
        assertThat(result).isEqualTo(expect);

    }

    @ParameterizedTest 
    @CsvSource(value = {"012, false", "123, true", "1a^, false"})
    public void testIsvalidNumber(String input, boolean expect) {
        boolean result = numberBaseballGameCore.isValidNumber(input);
        assertThat(result).isEqualTo(expect);
    }
}