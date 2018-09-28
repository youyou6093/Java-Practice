package class12Recursion2;
import java.util.*;
//checked
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(ret, sol, n);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> sol, int n) {
        if (sol.size() == n) {
            ret.add(new ArrayList<Integer>(sol));
            return;
        }
        //decide where to put the next
        for (int i = 0; i < n; i++) {
            //current result
            if (check(sol, i)) {
                sol.add(i);     //add new result
                dfs(ret, sol, n);  //continue recursion
                sol.remove(sol.size() - 1); //remove back
            }
        }
    }

    private boolean check(List<Integer> sol, int col) {
        int row = sol.size();
        //there is no column conflict
        for (int i = 0; i < row; i++) {
            if (sol.get(i) == col || Math.abs(sol.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}
