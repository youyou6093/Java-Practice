package class10String2;
import java.util.*;

//checked

public class AllAnagrams {
    public static void main(String[] args) {
        AllAnagrams x = new AllAnagrams();
        System.out.println(x.allAnagrams("abc","abacbabc"));


    }

    public List<Integer> allAnagrams(String sh, String lo) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        if (lo.length() < sh.length()) return ret;

        //get the hash map that stores string short
        Integer count;
        for (int i = 0; i < sh.length(); i++) {
            count = map.get(sh.charAt(i));
            if (count == null) {
                count = 1;
            } else {
                count ++;
            }
            map.put(sh.charAt(i), count);
        }
        //------------


        int match = 0;

        //i is the last index of the window
        for (int i = 0; i < lo.length(); i++) {
            char tmp = lo.charAt(i);
            count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            //now i = sh.length, means the windows size is sh.length + 1, we need to shrink the window
            if (i >= sh.length()) {
                tmp = lo.charAt(i - sh.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                ret.add(i - sh.length() + 1);
            }
        }
        return  ret;
    }
}
