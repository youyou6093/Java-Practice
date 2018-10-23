package class24CrossTraining2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}

public class DeepCopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        HashMap<GraphNode, GraphNode> m =  new HashMap<>();
        List<GraphNode> ret = new ArrayList<>();
        for (GraphNode node : graph) {
            if (m.containsKey(node)) {
                ret.add(m.get(node));   //add the copy
            } else {
                GraphNode copy = new GraphNode(node.key);   //create copy
                dfs(node, copy, m);                         //dfs and copy
                ret.add(copy);
            }
        }
        return ret;
    }

    private void dfs(GraphNode node, GraphNode copy, HashMap<GraphNode, GraphNode> m) {
        m.put(node, copy);   //mark as visited
        for (GraphNode neighbor : node.neighbors) {
            if (!m.containsKey(neighbor)) {     //not visited
                GraphNode neighborCopy = new GraphNode(neighbor.key);
                copy.neighbors.add(neighborCopy);
                dfs(neighbor, neighborCopy, m);
            } else {
                copy.neighbors.add(m.get(neighbor));   //link
            }
        }
    }
}
