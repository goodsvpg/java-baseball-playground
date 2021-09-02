package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size() {
        int actual = numbers.size();
        assertThat(actual).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsProvidedValueSource(int testNumber) {
        assertThat(numbers.contains(testNumber)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsProvidedCsvSource(int testNumber, boolean expected) {
        assertThat(numbers.contains(testNumber)).isEqualTo(expected);
    }
}