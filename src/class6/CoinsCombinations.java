package class6;
import java.util.*;

public class CoinsCombinations {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> sol = new ArrayList<>(Collections.nCopies(coins.length, 0));
        generate(ret, sol, coins, target, 0);
        return ret;
    }

    void generate(List<List<Integer>> ret, List<Integer> sol, int[] coins, int target, int level) {
        if (level == coins.length) {
            if (target == 0) {
                ret.add(new ArrayList<>(sol));
            }
            return;
        }
        for (int i = 0; i <= target / coins[level]; i++) {
            sol.set(level, i);
            generate(ret, sol, coins, target - i * coins[level], level + 1);
        }
    }
}
