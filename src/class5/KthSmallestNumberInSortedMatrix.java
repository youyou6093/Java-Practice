package class5;
import java.util.*;

public class KthSmallestNumberInSortedMatrix {
    public static void main(String[] args) {
        KthSmallestNumberInSortedMatrix tester = new KthSmallestNumberInSortedMatrix();
        int[][] matrix = {{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
        tester.kthSmallest(matrix, 16);
    }

    class point{
        int row;
        int column;
        int val;
        point(int row, int column, int val) {
            this.row = row;
            this.column = column;
            this.val = val;
        }
    }

    class myComparator implements Comparator<point>{
        @Override
        public int compare(point t1, point t2){
            if (t1.val == t2.val) {
                return 0;
            } else {
                return t1.val < t2.val ? -1 : 1;
            }
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;

        PriorityQueue<point> pQueue = new PriorityQueue<>(k, new myComparator());
        pQueue.offer(new point(0, 0, matrix[0][0]));
        boolean[][] visited = new boolean[numOfRows][numOfColumns];
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            point cur = pQueue.poll();
            if (cur.row + 1 < numOfRows && !visited[cur.row + 1][cur.column]) {
                pQueue.offer(new point(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }
            if (cur.column + 1 < numOfColumns && !visited[cur.row][cur.column + 1]) {
                pQueue.offer(new point(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return pQueue.poll().val;

    }
}
