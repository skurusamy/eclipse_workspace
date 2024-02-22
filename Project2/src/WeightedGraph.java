import java.util.HashMap;
import java.util.HashSet;


public class WeightedGraph {
	HashMap<String, Node> graphNodes;
	HashSet<Node> setOfNodes;
	
	public WeightedGraph() {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
	}
	
	public WeightedGraph(final String value) {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
		
		Node nodeToAdd = new Node(value, setOfNodes);
		
		graphNodes.put(value, nodeToAdd);
		setOfNodes.add(nodeToAdd);
	}
	
	public WeightedGraph(final String[] values) {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
		
		for (int i = 0; i < values.length; i++) {
			Node nodeToAdd = new Node(values[i], setOfNodes);
			graphNodes.put(values[i], nodeToAdd);
			setOfNodes.add(nodeToAdd);
		}
	}
	
	
	public void addNode(final String nodeVal) {
		Node nodeToAdd = new Node(nodeVal, setOfNodes);
		
		graphNodes.put(nodeVal, nodeToAdd);
		setOfNodes.add(nodeToAdd);
	}
	
	
	public void addWeightedEdge(final Node first, final Node second, final int edgeWeight) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			first.setNeighbor(second, edgeWeight);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	
	public void removeDirectedEdge(final Node first, final Node second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			first.removeNeighbor(second);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	
	public boolean directedEdgeExists(final Node first, final Node second) {
		return first.hasNeighbor(second);
	}
	
	
	public int distanceToNeighbor(final Node first, final Node second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			return first.distanceToNeighbor(second);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	
	public HashSet<Node> getAllNodes() {
		return setOfNodes;
	}
	
	
	public Node getNode(String value) {
		return graphNodes.get(value);
	}
}