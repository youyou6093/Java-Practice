package bfs;

import java.util.*;


public class KthSmallestSumInTwoSortedArrays {
    static class point {
        int i;
        int j;
        int val;
        point(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int kthSum(int[] A, int[] B, int k) {
        // Write your solution here
        int lengthA = A.length;
        int lengthB = B.length;
        Comparator<point> myComparator = new Comparator<point>() {
            @Override
            public int compare(point t1, point t2) {
                if (t1.val == t2.val) {
                    return 0;
                } else {
                    return t1.val < t2.val ? -1 : 1;
                }
            }
        };
        PriorityQueue<point> pQueue = new PriorityQueue<>(k, myComparator);
        pQueue.offer(new point(0, 0, A[0] + B[0]));
        boolean[][] visited = new boolean[lengthA][lengthB];
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            point cur = pQueue.poll();
            if (cur.i + 1 < lengthA && !visited[cur.i + 1][cur.j]) {
                pQueue.offer(new point(cur.i + 1, cur.j, A[cur.i + 1] + B[cur.j]));
                visited[cur.i + 1][cur.j] = true;
            }
            if (cur.j + 1 < lengthB && !visited[cur.i][cur.j + 1]) {
                pQueue.offer(new point(cur.i, cur.j + 1, A[cur.i] + B[cur.j + 1]));
                visited[cur.i][cur.j + 1] = true;
            }
        }
        return pQueue.poll().val;
    }
}
