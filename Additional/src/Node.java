import java.util.Vector;

public class Node {
	
		public Node(int val) {
			this.val = val;
			this.neighbors = new Vector<Node>();
			this.weightedNeighbors = new Vector<Edge>();
		}
		
		int val;
		Vector<Node> neighbors;	
		Vector<Edge> weightedNeighbors;
}