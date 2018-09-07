package class7hashtablestring1;
import java.util.*;

class WordFreq{
    String str;
    int count;
    public WordFreq(String str, int count) {
        this.str = str;
        this.count = count;
    }
}

//min heap
class Mycomparator implements Comparator<WordFreq> {
    @Override
    public int compare(WordFreq a, WordFreq b) {
        if (a.count == b.count) {
            return 0;
        } else {
            return a.count < b.count ? -1 : 1;
        }
    }
}

public class TopKWord {
    public String[] topKFrequent(String[] combo, int k) {
        HashMap<String, Integer> m = new HashMap<>();
        //complete the hast map
        for (String str : combo) {
            if (m.containsKey(str)) {
                int count = m.get(str);
                m.put(str, count + 1);
            } else {
                m.put(str, 1);
            }
        }
        //use max heap
        PriorityQueue<WordFreq> pq = new PriorityQueue<>(k, new Mycomparator());
        //the number of keys we visited
        int count2 = 0;
        for (String key : m.keySet()) {
            if(count2 < k) {
                pq.offer(new WordFreq(key, m.get(key)));
            } else {
                if (m.get(key) > pq.peek().count) {
                    pq.poll();
                    pq.offer(new WordFreq(key, m.get(key)));
                }
            }
            count2++;
        }
        if(count2 < k) {
            String[] ret = new String[count2];
            while (!pq.isEmpty()) {
                ret[--count2] = pq.poll().str;
            }
            return ret;
        } else {
            String[] ret = new String[k];
            while (!pq.isEmpty()) {
                ret[--k] = pq.poll().str;
            }
            return ret;
        }
    }
}
