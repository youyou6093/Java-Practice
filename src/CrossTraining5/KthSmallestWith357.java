package CrossTraining5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//check
public class KthSmallestWith357 {
    public long kth(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> visted = new HashSet<>();
        pq.offer(3 * 5 * 7L);
        visted.add(3 * 5 * 7L);
        for (int i = 0; i < k - 1; i++) {
            long cur = pq.poll();
            if (visted.add(3 * cur)) {
                pq.offer(cur * 3);
            }
            if (visted.add(5 * cur)) {
                pq.offer(cur * 5);
            }
            if (visted.add(7 * cur)) {
                pq.offer(cur * 7);
            }
        }
        return pq.peek();
    }
}
