import java.util.HashMap;
import java.util.Integer;
import java.util.ArrayList;

public class WeightedNode {

    private int data;
    boolean visited;
    HashMap<WeightedNode, Integer> neighbors;

    public WeightedNode(int data) {
        this.neighbors = new HashMap<WeightedNode, Integer>();
        this.data = data;
        visited = false;
    }

    public HashMap<WeightedNode, java.lang.Integer> getEdges() {
        return this.neighbors;
    }

    public void removeEdge(final WeightedNode node) {
        neighbors.remove(node);
    }

    public void addEdge(final WeightedNode node, final int edgeWeight) {
        neighbors.put(node, edgeWeight);
    }
}