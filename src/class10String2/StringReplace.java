package class10String2;
import java.util.*;

//checked
public class StringReplace {
    public static void main( String[] args) {
        StringReplace x = new StringReplace();
        System.out.println(x.replace("aaa", "aa", "bbb"));
    }

    //checked
    public String replace(String input, String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        if (s.length() < t.length()) {
            return replaceLonger(input, source, target);
        } else {
            return replaceShorter(input, source, target);
        }
    }

    //checked
    public String replaceShorter(String input, char[] s, char[] t) {
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        for (; fast < array.length; fast++) {
            //the condition that we can replace
            if(fast <= array.length - s.length && match(array, s, fast)) {
                for (int i = 0; i < t.length; i++) {
                    array[slow++] = t[i];
                }
                //move to the last index of the match
                fast += s.length - 1;
            } else {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }

    //checked
    public String replaceLonger(String input, char[] s, char[] t) {
        List<Integer> matches = findAllmatches(input, s);
        int requiredLength = input.length() + (t.length - s.length) * matches.size();
        //prepare the new array
        char[] array = new char[requiredLength];
        for (int i = 0; i < input.length(); i++) {
            array[i] = input.charAt(i);
        }
        //start replacing
        int fast = input.length() - 1;
        int slow = array.length - 1;
        int indexInList = matches.size() - 1;
        while (fast >= 0) {
            //this is very important, fast equals the last index of the matched string
            if (indexInList >= 0 && fast == matches.get(indexInList) + s.length - 1) {
                //replace
                for (int i = t.length - 1; i >= 0; i--) {
                    array[slow--] = t[i];
                }
                fast -= s.length;
                indexInList--;
            } else {
                array[slow--] = array[fast--];
            }
        }
        return new String(array);
    }


    //checked
    private List<Integer> findAllmatches(String input, char[] s) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i <= input.length() - s.length; i++) {
            if (match(input, s, i)) {
                ret.add(i);
                i += s.length - 1;   //skip this index
            }
        }
        return ret;
    }


    //checked
    private boolean match(char[] input, char[] s, int index) {
        for (int i = index; i < index + s.length; i++) {
            if (input[i] != s[i - index]) {
                return false;
            }
        }
        return true;
    }

    //checked
    private boolean match(String input, char[] s, int index) {
        for (int i = index; i < index + s.length; i++) {
            if (input.charAt(i) != s[i - index]) {
                return false;
            }
        }
        return true;
    }

    //checked
    private void reverse(char[] array, int i , int j) {
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
