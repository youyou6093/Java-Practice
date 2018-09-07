package class7hashtablestring1;
import java.util.*;


public class RemoveAdjacentRepeatedCharacterIV {
    public String deDup(String input) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty() || input.charAt(i) != stack.peekFirst()) {
                stack.offerFirst(input.charAt(i));
            } else {
                while (i < input.length() && input.charAt(i) == stack.peekFirst()) {
                    i++;
                }
                stack.pollFirst();
                i--;
            }
        }
        StringBuilder ret = new StringBuilder();
        while(!stack.isEmpty()) {
            ret.append(stack.pollLast());
        }
        return ret.toString();
    }
}
