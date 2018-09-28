package class10String2;

import java.util.*;

//checked
public class AllPermutations2 {
    public List<String> permutations(String set) {
        // Write your solution here
        char[] input = set.toCharArray();
        List<String> ret = new ArrayList<>();
        generate(ret, input, 0);
        return ret;
    }

    private void generate(List<String> ret, char[] input, int pos) {
        if (pos == input.length) {
            ret.add(new String(input));
            return;
        }
        HashSet<Character> used = new HashSet<>();
        for (int i = pos; i < input.length; i++) {
            if (used.add(input[i])) {
                swap(input, i, pos);
                generate(ret, input, pos + 1);
                swap(input, i, pos);
            }
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
