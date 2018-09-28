package class8hashtablestring1;
import java.util.*;

//checked
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

    public String deDup2(String input) {
        char[] array = input.toCharArray();
        int slow = -1;   //the top of the stack
        for (int fast = 0; fast < array.length; fast++) {
            if (slow == -1 || array[fast] != array[slow]) {  //stack is empty or current element!= top of the stack
                array[++slow] = array[fast];
            } else {
                //try to find the last element that I need to remove
                while (fast + 1 < array.length && array[fast + 1] == array[slow]) {
                    fast++;
                } //fast + 1 = array.length or fast + 1 != slow;
                slow--;
            }
        }
        return new String(array, 0, slow + 1);
    }
}
