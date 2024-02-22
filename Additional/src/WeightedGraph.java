import java.util.ArrayList;
import java.util.HashSet;

public class WeightedGraph {
	
	ArrayList<Node> allNodes = new ArrayList<Node>();	
	
	void addNode(final int nodeVal) {
		Node node = new Node(nodeVal);
		allNodes.add(node);
	}
	
	void addWeightedEdge(final Node first, final Node second, final int edgeWeight) {
		first.weightedNeighbors.add(new Edge(second, edgeWeight));
	}
	
	void removeDirectedEdge(final Node first, final Node second) {
		for (Edge e : first.weightedNeighbors) 
			if (e.dest == second) {
				first.weightedNeighbors.remove(e);
				return;
			}	
	}
	
	HashSet<Node> getAllNodes() {
		HashSet<Node> hashset = new HashSet<Node>();
		for (int i = 0; i < allNodes.size(); i++) 
			hashset.add(allNodes.get(i));
		return hashset;
	}
	
	void printAllNodes() {
		HashSet<Node> hset = this.getAllNodes();
		for (Node n : hset) {
			System.out.print(n.val + ": ");
		
			for (int i = 0; i < n.weightedNeighbors.size(); i++) {
				Edge e = n.weightedNeighbors.get(i);
				System.out.print("(" + e.dest.val + ":" + e.weight + ") ");
			}
			
			System.out.println("");
		}
	}
}