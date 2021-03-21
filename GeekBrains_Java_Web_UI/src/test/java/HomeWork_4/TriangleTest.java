package HomeWork_4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assumptions.*;


public class TriangleTest {

    static final Logger log = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void setUp() {
        log.info("\tSTARTING TESTS ........");
    }

    @AfterAll
    static void tearDown() {
        log.info("\tFINISHING TESTS......GOODBYE!");
    }

    @DisplayName("Тест по проверке вычисления площади треугольника")
    @RepeatedTest(6)
    void testTriangle() {

        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        double doubleValue = Math.sqrt(a * a + b * b);
        int c = (int) doubleValue;

        assumeTrue(a > 2, () -> "Тест пропускается потому, что a <= 2: a =" + a);
        assumeTrue(b > 2, () -> "Тест пропускается потому, что b <= 2: b =" + b);
        assumeTrue(c > 2, () -> "Тест пропускается потому, что c <= 2: c =" + c);

        log.info("\t\t\tSTART TEST FOR TRIANGLE SQUARE CALCULATING");

        double actual_result = Triangle.triangleSquare(a, b, c);
        int p = (a + b + c);
        int s = p * (p - a) * (p - b) * (p - c);
        double expected_result = Math.sqrt(s);

        double expected_result2 = expected_result;

        expected_result2 = Math.round(expected_result2 * 100);
        expected_result2 = expected_result2 / 100;


        Assertions.assertEquals(expected_result, actual_result);

        log.info("\t\t\t " + "a = " + a + " b = " + b + " c = " + c + "   square = " + expected_result2);
        log.info("\t\t\tEND TEST FOR TRIANGLE SQUARE CALCULATING");
    }

    @ParameterizedTest(name = "Test №{index}- Test with following triangle sides = {arguments}")
    @DisplayName("Тест по проверке вычисления c данными из файла")
    @CsvFileSource(resources = "nums-data.csv", numLinesToSkip = 1)
    void testTriangleFromFile(int a, int b, int c) {

        log.info("\t\tSTART SQUARE CALCULATING FROM FILE");

        double actual_result = Triangle.triangleSquare(a, b, c);

        int p = (a + b + c);
        int s = p * (p - a) * (p - b) * (p - c);
        double expected_result = Math.sqrt(s);

        Assertions.assertEquals(expected_result, actual_result);

        log.info("\t\tSQUARE = " + expected_result);

        log.info("\t\tFINISHING CALCULATING FROM FILE");
    }
}
