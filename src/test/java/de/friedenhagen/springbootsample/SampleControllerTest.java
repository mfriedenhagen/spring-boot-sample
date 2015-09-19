package de.friedenhagen.springbootsample;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleControllerTest {
    @Test
    public void testHome() {
        assertThat(new SampleController().home()).isEqualTo("Hello World!");
    }
}