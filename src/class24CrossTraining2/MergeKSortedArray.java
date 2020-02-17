package class24CrossTraining2;
import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;



public class MergeKSortedArray {
    static class Cell {
        int row;
        int col;
        int val;
        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }


    static class Comp implements Comparator<Cell>{
        @Override
        public int compare(Cell a, Cell b) {
            if (a.val == b.val) {
                return 0;
            } else {
                return a.val < b.val ? -1 : 1;
            }
        }
    }

    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comp());
        int len = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length > 0) {
                len += arrayOfArrays[i].length;
                pq.offer(new Cell(i, 0, arrayOfArrays[i][0]));
            }
        }
        int[] ret = new int[len];
        int index = 0;
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            ret[index++] = cur.val;
            cur.col++;
            if (cur.col < arrayOfArrays[cur.row].length) {
                cur.val = arrayOfArrays[cur.row][cur.col];
                pq.offer(cur);
            }
        }
        return ret;
    }
}

