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

    @Test
    void testPush() {
        minMaxStack.push(1);
        assertEquals(1, minMaxStack.peek());
    }

    @Test
    void testPop() {
        minMaxStack.push(1);
        int peekedValue = minMaxStack.peek();
        assertEquals(peekedValue, minMaxStack.pop());
    }

    @Test
    void testSize() {
        minMaxStack.push(1);
        minMaxStack.push(2);
        assertEquals(2, minMaxStack.size());
    }

    @Test
    void testPopOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    void testGetMinOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMin());
    }

    @Test
    void testGetMaxOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMax());
    }
}