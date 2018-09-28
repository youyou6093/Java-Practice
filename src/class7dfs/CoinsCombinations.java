package class7dfs;
import java.util.*;

public class CoinsCombinations {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> ret = new ArrayList<>();
        Integer[] sol = new Integer[coins.length];
        generate(ret, sol, coins, target, 0);
        return ret;
    }

    void generate(List<List<Integer>> ret, Integer[] sol, int[] coins, int target, int level) {
        if (level == coins.length - 1) {
            if (target % coins[level] == 0) {
                sol[level] = target / coins[level];
                ret.add(new ArrayList<Integer>(Arrays.asList(sol)));
            }
            return;
        }
        for (int i = 0; i <= target / coins[level]; i++) {
            sol[level] = i;
            generate(ret, sol, coins, target - i * coins[level], level + 1);
        }
    }
}
