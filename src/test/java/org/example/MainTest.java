package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {

    @Test
    public void testMainRunDoesNotThrow() {
        Main main = new Main();
        assertDoesNotThrow(main::run); // перевіряємо, що нічого не ламається
    }
}
