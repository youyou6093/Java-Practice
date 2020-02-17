package CrossTraining5;


import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangluar {
    public int largest(int[] array) {
        Deque<Integer> stack = new LinkedList<>();
        int ret = 0;
        stack.push(-1);
        for (int i = 0; i < array.length; i++) {
            while (stack.peek() != -1 && array[i] <= array[stack.peek()]) {
                ret = Math.max(ret, array[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            ret = Math.max(ret, array[stack.pop()] * (array.length - stack.peek() - 1));
        }
        return ret;

    }
}

