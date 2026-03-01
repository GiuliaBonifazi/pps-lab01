package tdd.stack;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {
    private final Stack<Integer> mainStack = new Stack<>();
    private final Stack<Integer> maxNumsStack = new Stack<>();
    private final Stack<Integer> minNumsStack = new Stack<>();

    @Override
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    private void calculateOnPush(
        int justPushed,
        boolean shouldPush,
        Stack<Integer> stack) {
        if (shouldPush) {
            stack.push(justPushed);
        }
    }

    @Override
    public void push(int value) {
        if (isEmpty()) {
            minNumsStack.push(value);
            maxNumsStack.push(value);
        } else {
            calculateOnPush(value, minNumsStack.peek() >= value, minNumsStack);
            calculateOnPush(value, maxNumsStack.peek() <= value, maxNumsStack);
        }
        mainStack.push(value);
    }

    private void calculateOnPop(int popped, Stack<Integer> stack) {
        if (stack.peek() == popped) {
            stack.pop();
        }
    }

    private void handlePop(int popped) {
        calculateOnPop(popped, minNumsStack);
        calculateOnPop(popped, maxNumsStack);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int popped = mainStack.pop();
        handlePop(popped);
        return popped;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return mainStack.peek();
    }

    @Override
    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return minNumsStack.peek();
    }

    @Override
    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return maxNumsStack.peek();
    }

    @Override
    public int size() {
        return mainStack.size();
    }
}
