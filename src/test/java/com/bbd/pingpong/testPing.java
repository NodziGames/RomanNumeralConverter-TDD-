package com.bbd.pingpong;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testPing {
    public RomanConverter converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new RomanConverter();
    }

    @DisplayName("Easy Tests")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({ "I, 1", "V, 5", "X, 10", "L, 50", "C, 100", "D, 500", "M, 1000"})
    public void basicTest(String word, int number) {
        assertEquals(number, converter.convert(word));
    }

    @DisplayName("Intermediate Tests")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({ "XIII, 13", "XXVI, 26", "CXII, 112", "MD, 1500", "LVII, 57"})
    public void intermediateTests(String word, int number) {
        assertEquals(number, converter.convert(word));
    }

    @DisplayName("Intermediate Tests")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({ "IX, 9", "CXLIV, 144", "CMXXXIV, 934"})
    public void complexTests(String word, int number) {
        assertEquals(number, converter.convert(word));
    }


    @Test
    @DisplayName("Empty String")
    public void ExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert(""));
    }

    @Test
    @DisplayName("Invalid Numeral")
    public void ExceptionTest2() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert("XIIV"));
    }
}