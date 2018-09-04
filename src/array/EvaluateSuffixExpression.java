package array;

import java.util.*;


public class EvaluateSuffixExpression {


    public int evaluate(String[] suffix) {
        return helper(suffix, 0, suffix.length - 1);
    }

    public int helper(String[] suffix, int start, int end) {
        if (start == end) {
            return Integer.parseInt(suffix[start]);
        }
        int left = helper(suffix, start, start);
        int right = helper(suffix, start + 1, end - 1);
        if (suffix[end].equals("+")) {
            return left + right;
        } else if (suffix[end].equals("-")) {
            return left - right;
        } else if (suffix[end].equals("*")) {
            return left * right;
        } else {
            return left / right;
        }
    }

    public int evaluate2(String[] suffix) {
        // Write your solution here
        if (suffix == null || suffix.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        while (index < suffix.length) {
            if (suffix[index].charAt(0) - '0' >= 0 && suffix[index].charAt(0) - '0' <= 9) {
                stack.offerFirst(Integer.parseInt(suffix[index]));
            } else {
                int a = stack.pollFirst();
                int b = stack.pollFirst();
                if (suffix[index].equals("+")) {
                    stack.offerFirst(a + b);
                } else if (suffix[index].equals("-")) {
                    stack.offerFirst(b - a);
                } else if (suffix[index].equals("*")) {
                    stack.offerFirst(a * b);
                } else {
                    stack.offerFirst(b / a);
                }

            }
            index ++;
        }
        return stack.pollFirst();
    }

}

