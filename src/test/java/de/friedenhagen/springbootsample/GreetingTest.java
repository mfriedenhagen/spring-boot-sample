package de.friedenhagen.springbootsample;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingTest {
    private final Greeting sut = new Greeting(1, "Mirko");
    @Test
    public void testGetId() throws Exception {
        assertThat(sut.getId()).isEqualTo(1);
    }

    @Test
    public void testGetContent() throws Exception {
        assertThat(sut.getContent()).isEqualTo("Mirko");
    }
}