package class8hashtablestring1;
import java.util.*;


//checked
public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        char[] array = input.toCharArray();
        int slow = 0, fast = 0;
        for (; fast < array.length; fast++) {
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow); //slow is not included
    }
}
