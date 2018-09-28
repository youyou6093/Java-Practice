package class12Recursion2;

import java.util.*;
//checked

public class NQueensWithSets {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] cur = new int[n];
        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiagonals = new boolean[2 * n - 1];          //row + column = [0, 2 * n - 2];
        boolean[] usedReverse = new boolean[2 * n - 1];            //row - column = [- n + 1, n -1];
        helper(n, 0, cur, result, usedColumns, usedDiagonals, usedReverse);
        return result;
    }

    private void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedColumns,
                        boolean[] usedDiagonals, boolean[] usedReverse) {
        if (row == n) {
            result.add(toList(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, row, i, usedColumns, usedDiagonals, usedReverse)) {
                mark(n, row, i, usedColumns, usedDiagonals, usedReverse);
                cur[row] = i;
                helper(n, row + 1, cur, result, usedColumns, usedDiagonals, usedReverse);
                unMark(n, row, i, usedColumns, usedDiagonals, usedReverse);
            }
        }
    }


    private List<Integer> toList(int[] cur) {
        List<Integer> ret = new ArrayList<>();
        for (Integer x : cur) {
            ret.add(x);
        }
        return ret;
    }

    private boolean valid(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                          boolean[] usedReverse) {
        return !usedColumns[col] && !usedDiagonals[row + col] && !usedReverse[row - col + n - 1];
    }

    private void mark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                      boolean[] usedReverse) {
        usedColumns[col] = true;
        usedDiagonals[row + col] = true;
        usedReverse[row - col + n - 1] = true;
    }

    private void unMark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                      boolean[] usedReverse) {
        usedColumns[col] = false;
        usedDiagonals[row + col] = false;
        usedReverse[row - col + n - 1] = false;
    }
}
