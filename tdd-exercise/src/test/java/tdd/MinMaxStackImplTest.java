package tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack minMaxStack;

    @BeforeEach
    void beforeEach() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    void testIsEmptyOnCreation() {
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    void testPeekOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }
}