package de.friedenhagen.springbootsample;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GreetingControllerTest {

    @Test
    public void testGreeting() throws Exception {
        assertThat(new GreetingController().greeting("Mirko").getContent()).isEqualTo("Hello, Mirko!");
    }
}