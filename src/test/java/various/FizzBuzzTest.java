package various;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static various.FizzBuzz.Quiz.*;
import static various.FizzBuzz.processV1;
import static various.FizzBuzz.processV2;
import static various.FizzBuzz.Quiz;


class FizzBuzzTest {
    static List<Double> input = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 12.0, 0.0, 30.0, 31.0, 33.0, 55.0, 100.0);
    static List<Object> result = List.of(1.0, 2.0, FIZZ, 4.0, BUZZ, FIZZ, FIZZBUZZ, FIZZBUZZ, 31.0, FIZZ, BUZZ, BUZZ);

    @Test
    void fizzBuzzTest() {
        assertIterableEquals(result, processV1(input.size(), input));
        assertIterableEquals(result, processV2(input.size(), input));
        assertIterableEquals(processV1(input.size(), input), processV2(input.size(), input));
    }

}