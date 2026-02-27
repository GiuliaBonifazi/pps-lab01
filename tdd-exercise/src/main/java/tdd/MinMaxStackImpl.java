package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {
    private final Stack<Integer> stack = new Stack<>();

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return stack.pop();
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return stack.peek();
    }

    @Override
    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return 0;
    }

    @Override
    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return 0;
    }

    @Override
    public int size() {
        return stack.size();
    }
}
