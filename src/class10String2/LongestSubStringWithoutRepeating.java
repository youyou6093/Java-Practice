package class10String2;

import java.util.*;


//checked
public class LongestSubStringWithoutRepeating {
    public int longest(String input) {
        HashSet<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        int maxL = 0;
        while (fast < input.length()) {
            //Try to add fast
            if (!set.contains(input.charAt(fast))){
                set.add(input.charAt(fast));
                maxL = Math.max(maxL, fast - slow + 1);
                fast++;
            } else {
                set.remove(input.charAt(slow));
                slow++;
            }
        }
        return maxL;
    }
}
