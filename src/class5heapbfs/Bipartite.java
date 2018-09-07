package class5heapbfs;
import java.util.*;
import graph.GraphNode;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        Deque<GraphNode> queue = new LinkedList<>();
        HashMap<GraphNode, Integer> set = new HashMap<>();
        if (graph.isEmpty()) {
            return true;
        }
        for (int i = 0; i < graph.size(); i++) {
            if (set.containsKey(graph.get(i)) ) {
                continue;
            }
            set.put(graph.get(i), -1);
            queue.offerLast(graph.get(i));
            while (!queue.isEmpty()) {
                GraphNode cur = queue.pollFirst();
                for (int j = 0; j < cur.neighbors.size(); j++) {
                    if (set.containsKey(cur.neighbors.get(j))) {
                        if (set.get(cur.neighbors.get(j)) == set.get(cur)) {
                            return false;
                        }
                    } else {
                        queue.offerLast(cur.neighbors.get(j));
                        set.put(cur.neighbors.get(j), -set.get(cur));
                    }
                }
            }
        }
        return true;

    }
}
