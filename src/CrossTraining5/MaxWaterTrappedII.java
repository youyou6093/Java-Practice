package CrossTraining5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxWaterTrappedII {
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int height;

        Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public int compareTo(Pair another) {
            if (this.height == another.height) {
                return 0;
            } else {
                return this.height < another.height ? -1 : 1;
            }
        }
    }

    private void processBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> pq, int rows, int cols) {
        for (int j = 0; j < cols; j++) {
            pq.offer(new Pair(0, j, matrix[0][j]));
            pq.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
            visited[0][j] = true;
            visited[rows - 1][j] = true;
        }
        for (int i = 1; i < rows; i++) {
            pq.offer(new Pair(i, 0, matrix[i][0]));
            pq.offer(new Pair(i, cols - 1, matrix[i][cols - 1]));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }
    }

    private List<Pair> allNeighbors(Pair cur, int[][] matrix, boolean[][] visited) {
        List<Pair> neis = new ArrayList<>();
        if (cur.x + 1 < matrix.length) {
            neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        if (cur.x - 1 >= 0) {
            neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
        }
        if (cur.y + 1 < matrix[0].length) {
            neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
        }
        if (cur.y - 1 >= 0) {
            neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
        }
        return neis;
    }

    public int maxTrapped(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows < 3 || cols < 3) {
            return 0;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[rows][cols];
        processBorder(matrix, visited, pq, rows, cols);
        int ret = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            List<Pair> neighbors = allNeighbors(cur, matrix, visited);
            for (Pair nei : neighbors) {
                if (visited[nei.x][nei.y]) {
                    continue;
                }
                visited[nei.x][nei.y] = true;
                ret += Math.max(0, cur.height - nei.height);
                nei.height = Math.max(cur.height, nei.height);
                pq.offer(nei);
            }
        }
        return ret;
    }
}
