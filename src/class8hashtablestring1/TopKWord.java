package class8hashtablestring1;
import java.util.*;

//checked


//min heap
class Mycomparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        return a.getValue().compareTo(b.getValue());
    }
}

public class TopKWord {
    public String[] topKFrequent(String[] combo, int k) {
        HashMap<String, Integer> m = new HashMap<>();
        //complete the hast map
        for (String str : combo) {
            Integer freq = m.get(str);
            if (freq == null) {
                m.put(str, 1);
            } else {
                m.put(str, freq + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, new Mycomparator());
        //the number of keys we visited
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }
        String[] ret = new String[pq.size()];
        int index = ret.length - 1;

        while (!pq.isEmpty()) {
            ret[index--] = pq.poll().getKey();
        }
        return ret;


    }
}
