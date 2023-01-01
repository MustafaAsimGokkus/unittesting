package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
/*


 */

public class StringTest {

    private String str;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initialized conenction to database");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Closed conenction to database");
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Initialize test data for " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("Clean up test data for " + info.getDisplayName());
    }

    @Test
    void length_basic() {
        int actualLength = "abcdefg".length();
        int expectedLength = 7;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    @DisplayName("Throw exception when string is null")
    void length_exception() {
        String str = null;
        // int actualLength = str.length();
        assertThrows(NullPointerException.class, () -> {
            str.length();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"asvf", " ", "sdf", "", "ds", "gf"})
    void length_greater_than_zero_using_parameterized_test(String str) {
        assertTrue(str.length() > 0);
    }

    @ParameterizedTest(name = "{0} to uppercase is {1}")
    @CsvSource(value = {"abcd,ABCD", "abc, ABC", "'',''", "ab,AB", " def, DEF"})
    void toUppercase(String word, String capitalWord) {
        assertEquals(capitalWord, word.toUpperCase());
    }

    @ParameterizedTest(name = "{1} length is {0}")
    @CsvSource(value = {"4,ABCD", "3, ABC", "0,''", "2,AB", " 4, DEFG"})
    void stringLength(int length, String word) {
        assertEquals(length, word.length());
    }

    @Test
    void performanceTest() {
        assertTimeout(Duration.ofSeconds(2), () -> {
                    for (int i = 0; i < 1_000_000; i++) {
                        int j = i;
                        System.out.println(j);
                    }
                }
        );
    }

    @Nested
    @DisplayName("For an empty string")
    class EmptyStringTests {
        @BeforeEach
        void setToEmpty() {
            str = "";
        }
    @Test
        void lengthIsZero(){
            assertEquals(0,str.length());
   }
        @Test
        void uppercaseIsEMpty(){
            assertEquals("",str.toUpperCase());
        }
    }


    @Nested
    @DisplayName("For an empty string")
    class LargeStringTests {}
    @BeforeEach
    void setToLargeString() {
        str = "Nitelikli is iletin nitel isi ilk iletin";
    }

    @Test
    void test(){

    }
}

