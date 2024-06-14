package com.concatenate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {

    private final StringProcessor processor = new StringProcessor();

    @Test
    public void testRemoveConsecutiveChars() {
        String input = "aabcccbbad";
        String expectedOutput = "d";
        String actualOutput = processor.removeConsecutiveChars(input);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testReplaceConsecutiveChars() {
        String input = "abcccbad";
        String expectedOutput = "d";
        String actualOutput = processor.replaceConsecutiveChars(input);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

}
