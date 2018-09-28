package class7dfs;
import java.util.*;

public class ParenthesesPermutations {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }
        StringBuilder sol = new StringBuilder();
        generate(ret, sol, 0, 0, n);
        return ret;
    }

    void generate(List<String> ret, StringBuilder sol, int l, int r, int n) {
        if (l + r == 2 * n) {
            ret.add(sol.toString());
            return;
        }
        if (l < n) {
            sol.append('(');
            generate(ret, sol, l + 1, r , n);
            sol.deleteCharAt(sol.length() - 1);
        }
        if (r < l) {
            sol.append(')');
            generate(ret, sol, l, r + 1, n);
            sol.deleteCharAt(sol.length() - 1);
        }
    }
}
