package class7hashtablestring1;
import java.util.*;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        char[] array = input.toCharArray();
        int i = 0, j = 0;
        while (j < array.length) {
            if (set.contains(array[j])) {
                j++;
            } else {
                array[i] = array[j];
                i++;
                j++;
            }
        }
        return new String(array, 0, i);
    }
}
