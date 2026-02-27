package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {
    private final Stack<Integer> stack = new Stack<>();

    @Override
    public void push(int value) {

    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return -1;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
