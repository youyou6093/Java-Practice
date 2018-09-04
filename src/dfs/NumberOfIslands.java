package dfs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count ++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][]grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int m = grid.length, n = grid[0].length;
        int[][] move = new int[][] {{0,-1}, {0, 1}, {1,0}, {-1,0}};
        for (int i = 0; i < move.length; i++) {
            int newR = r + move[i][0];
            int newC = c + move[i][1];
            if (newR >= 0 && newR < m && newC >= 0 && newC < n && !visited[newR][newC] && grid[newR][newC] == '1') {
                dfs(grid, visited, newR, newC);
            }
        }
    }
}
