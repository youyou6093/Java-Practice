package class16Sampling;
import java.util.*;

//checked
public class MedianTracker {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();//right
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//left
    public MedianTracker() {

    }

    public void read(int value) {
        if(maxHeap.size() == 0 || value <= maxHeap.peek()) {
            maxHeap.offer(value);
        } else {
            minHeap.offer(value);
        }
        //re-balance
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double median() {
        if (maxHeap.size() == 0) {
            return null;
        }
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            return 0.5 * (minHeap.peek() + maxHeap.peek());
        }
    }
}

