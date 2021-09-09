package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    final String[] OPERATOR_LIST = {"+", "-", "*", "/"};

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "4 * 10 + 23455 / 5, 4699"})
    void calculator(String input, int expect) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculator(input, expect);
        assertThat(result).isEqualTo(expect);
    }
}