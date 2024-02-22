import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class TopSort {
	
	ArrayList<Node> Kahns(final DirectedGraph graph) {
		HashMap<Node, Integer> hmap = new HashMap<Node, Integer>();
		ArrayList<Node> output = new ArrayList<Node>();
		Queue<Node> queue = new LinkedList<Node>();

		for (int i = 0; i < graph.allNodes.size(); i++) 
			hmap.put(graph.allNodes.get(i), 0);
		
		for (int i = 0; i < graph.allNodes.size(); i ++) {
			Vector<Node> temp = graph.allNodes.get(i).neighbors;
			for (Node node : temp) {
				hmap.replace(node, hmap.get(node) + 1);
			}
		}
		
		for (Node node : hmap.keySet()) {
			if (hmap.get(node) == 0) 
				queue.add(node);	
		}
		
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			output.add(node);
			hmap.replace(node, -1);
			
			Vector<Node> adjTemp = graph.allNodes.get(node.val).neighbors;
			for (Node adj : adjTemp) {
				hmap.replace(adj, hmap.get(adj) - 1);
				if (hmap.get(adj) == 0)
					queue.add(adj);
			}
		}
		return output;
	}
	
	ArrayList<Node> mDFS(final DirectedGraph graph) {
		ArrayList<Node> output = new ArrayList<Node>();
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> visited = new LinkedList<Node>();
		
		for (Node v: graph.allNodes) {
			if (!visited.contains(v))
				mDFSHelper(v, stack, visited);
		}
		
		int size = stack.size();
		for (int i = 0; i < size; i++) 
			output.add(stack.pop());
		return output;
	}
	
	void mDFSHelper(Node v, Stack<Node> stack, Queue<Node> visited) {
		visited.add(v);
		for (Node n : v.neighbors) {
			if (!visited.contains(n)) 
				mDFSHelper(n, stack, visited);
		}
		stack.add(v);
	}
	
	
	
	
}