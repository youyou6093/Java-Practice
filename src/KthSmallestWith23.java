import java.util.*;

public class KthSmallestWith23 {
    public static void main(String[] args) {
        KthSmallestWith23 tester = new KthSmallestWith23();
        System.out.println(tester.kth(40));

    }

    static class point{
        int i;
        int j;
        int val;
        point(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public String toString() {
            return i + " "  + j + " " + val;
        }
    }

    public int kth(int k) {
        // Write your solution here
        Comparator<point> myComparator = new Comparator<point>() {
            @Override
            public int compare(point t1, point t2) {
                if (t1.val == t2.val) {
                    return 0;
                } else if (t1.val < t2.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        PriorityQueue<point> pQueue = new PriorityQueue<>(k, myComparator);
        HashSet<String> set =  new HashSet<>();
        set.add(new point(0, 0, (int) (Math.pow(2, 0) * Math.pow(3, 0))).toString());
        pQueue.offer(new point(0, 0, (int) (Math.pow(2, 0) * Math.pow(3, 0))));
        for (int i = 0; i < k -1; i++) {
            point cur = pQueue.poll();
            point curRight = new point(cur.i + 1, cur.j, (int)(Math.pow(2, cur.i + 1) * Math.pow(3, cur.j)));
            point curDown = new point(cur.i, cur.j + 1, (int)(Math.pow(2, cur.i) * Math.pow(3, cur.j + 1)));
            if (!set.contains(curRight.toString())) {
                pQueue.offer(curRight);
                set.add(curRight.toString());
            }
            if (!set.contains(curDown.toString())) {
                pQueue.offer(curDown);
                set.add(curDown.toString());
            }
        }
        return pQueue.poll().val;

    }
}
