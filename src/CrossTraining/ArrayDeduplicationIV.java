package CrossTraining;
import java.util.*;


public class ArrayDeduplicationIV {
    public int[] dedup(int[] array) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || array[i] != stack.peek()) {
                stack.push(array[i]);
            } else {
                int j = i;
                while (j + 1 < array.length && array[j + 1] == array[i]) {
                    j++;
                }        //j = array.length - 1 || array[j + 1] != array[i];
                stack.pop();
                i = j;
            }
        }
        int[] ret = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            ret[index++] = stack.pollLast();
        }
        return ret;
    }
}