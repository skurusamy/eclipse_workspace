import java.util.*;

public class DirectedNode {

    private int data;
    boolean visited;
    HashMap<DirectedNode, Integer> neighbors;

    public DirectedNode(int data) {
        this.neighbors = new HashMap<DirectedNode, Integer>();
        this.data = data;
        visited = false;
    }

    public ArrayList<DirectedNode> getEdges() {
        return this.neighbors;
    }

    public void removeEdge(final DirectedNode node) {
        neighbors.remove(node);
    }

    public void addEdge(final DirectedNode node) {
        neighbors.put(node, 0);
    }

    @Override
    public int hashCode() {
        return this.data.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        return this.data.equals(((DirectedNode)o.data);
    }
}