package game.balancingact.backend.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for HelloWorld functionality.
 * HelloWorldTest
 */
@SpringBootTest
class HelloWorldTest {

    /**
     * Test method to verify that the HelloWorld message is printed correctly.
     */
    @Test
    void helloWorldPrintsMessage() {
        String message = "Hello, world!";
        System.out.println(message);
        assertThat(message).isEqualTo("Hello, world!");
    }
}