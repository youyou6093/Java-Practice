package class7dfs;
import java.util.*;

public class AllPermutationsI {
    public List<String> permutations(String set) {
        // Write your solution here
        char[] mySet = set.toCharArray();
        List<String> ret = new ArrayList<>();
        permutate(mySet, ret, 0);
        return ret;
    }

    void permutate (char[] set, List<String> ret, int pos) {
        if (pos == set.length) {
            ret.add(new String(set));
            return;
        }
        for (int i = pos; i < set.length; i++) {
            swap(set, i, pos);
            permutate(set, ret, pos + 1);
            swap(set, i, pos);
        }
    }

    void swap(char[] set, int i, int j) {
        char temp = set[i];
        set[i] = set[j];
        set[j] = temp;
    }
}
