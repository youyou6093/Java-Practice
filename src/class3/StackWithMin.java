package class3;


import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    private Deque<Integer> stack1 = new LinkedList<>();
    private Deque<Integer> stack2 = new LinkedList<>();

    public StackWithMin() {
        // write your solution here
    }

    public int pop() {
        if (stack1.isEmpty()) {
            return -1;
        }
        if (stack1.peekFirst() == stack2.peekFirst()) {
            stack2.pollFirst();
        }
        return stack1.pollFirst();
    }

    public void push(int element) {
        stack1.offerFirst(element);
        if (stack2.isEmpty() || element <= stack2.peekFirst()) {
            stack2.offerFirst(element);
        }
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peekFirst();
    }

    public int min() {
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.peekFirst();
    }
}