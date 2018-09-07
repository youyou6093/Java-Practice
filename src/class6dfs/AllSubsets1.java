package class6dfs;
import java.util.*;

public class AllSubsets1 {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> ret = new ArrayList<>();
        if (set == null) {
            return ret;
        }
        StringBuilder sol = new StringBuilder();
        findSet(ret, set, 0, sol);
        return ret;
    }


    void findSet(List<String> ret, String set, int level, StringBuilder sol) {
        if (level == set.length()) {
            ret.add(sol.toString());
            return;
        }
        findSet(ret, set, level + 1, sol);
        sol.append(set.charAt(level));
        findSet(ret, set, level + 1, sol);
        sol.deleteCharAt(sol.length() - 1);
    }
}
