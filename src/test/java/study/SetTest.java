package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
        numbers.add(4);
    }

    @Test
    void size() {
        int actual = numbers.size();
        assertThat(actual).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int testNumber) {
        assertThat(numbers.contains(testNumber)).isTrue();
    }

    
}