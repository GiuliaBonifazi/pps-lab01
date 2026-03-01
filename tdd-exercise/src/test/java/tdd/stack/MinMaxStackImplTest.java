package tdd.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    @BeforeEach
    void setUp() {}
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
        int pushed = 1;
        minMaxStack.push(pushed);
        assertEquals(pushed, minMaxStack.peek());
    }

    @Test
    void testPeek() {
        int pushed = 4;
        minMaxStack.push(pushed);
        assertEquals(pushed, minMaxStack.peek());
    }

    @Test
    void testPop() {
        int pushed = 1;
        minMaxStack.push(pushed);
        assertEquals(pushed, minMaxStack.pop());
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

    private void pushArray(int[] array) {
        for (int element : array) {
            minMaxStack.push(element);
        }
    }

    @Test
    void testGetMax() {
        int[] stackNumbers = {2, 3, 4, 5, 6, 9, 7};
        pushArray(stackNumbers);
        assertEquals(9, minMaxStack.getMax());
    }

    @Test
    void testGetMin() {
        int[] stackNumbers = {2, 3, 4, 5, 6, 9, 7, 1};
        pushArray(stackNumbers);
        assertEquals(1, minMaxStack.getMin());
    }

    @Test
    void testPopMinThenMin() {
        int[] stackNumbers = {2, 3, 4, 5, 6, 9, 7, 1};
        pushArray(stackNumbers);
        minMaxStack.pop();
        assertEquals(2, minMaxStack.getMin());
    }

    @Test
    void testPopMaxThenMax() {
        int[] stackNumbers = {2, 3, 4, 5, 6, 9};
        pushArray(stackNumbers);
        minMaxStack.pop();
        assertEquals(6, minMaxStack.getMax());
    }
}