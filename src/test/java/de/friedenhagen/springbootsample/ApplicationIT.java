package de.friedenhagen.springbootsample;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationIT {

    private static ConfigurableApplicationContext context;

    @BeforeClass
    public static void startApplication() {
        context = SpringApplication.run(Application.class);
    }

    @AfterClass
    public static void stopApplication() {
        context.stop();
    }

    @Test
    public void testHome() throws IOException {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8080/", String.class);
        assertThat(result.getBody()).isEqualTo("Hello World!");
    }

    @Test
    public void testGreeting() throws IOException {
        final RestTemplate restTemplate = new RestTemplate();
        final Greeting first = restTemplate.getForEntity(
                "http://localhost:8080/greeting?name=Mirko", Greeting.class).getBody();
        assertThat(first.getContent()).isEqualTo("Hello, Mirko!");
        assertThat(first.getId()).isEqualTo(1);
        final Greeting second = restTemplate.getForEntity(
                "http://localhost:8080/greeting?name=Mirko", Greeting.class).getBody();
        assertThat(second.getId()).isEqualTo(2);
    }
}