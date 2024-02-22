import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {
	
	ArrayList<Node> DFSRec(final Node start, final Node end) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(start);
		
		ArrayList<Node> searched = new ArrayList<Node>();
		DFSRecHelper(searched, stack, end);
		
		if (!searched.contains(end)) //checks if end was found
			return null;
		
		return searched;
	}

	void DFSRecHelper(ArrayList<Node> nodesVisited, Stack<Node> stack, final Node end) {	
		if (stack.isEmpty()) 
			return;
		
		Node node = stack.pop();
		nodesVisited.add(node);
		// push node neighbor on stack, and recursive call
		for (int i = 0; i < node.neighbors.size(); i++) {
			if (!nodesVisited.contains(node.neighbors.get(i))) {
				stack.push(node.neighbors.get(i));
				DFSRecHelper(nodesVisited, stack, end);
			}
			if (nodesVisited.contains(end))		// checks if end found after each iteration
				return;
		}	
		return;
	}
	
	ArrayList<Node> DFSIter(final Node start, final Node end) {
		ArrayList<Node> visited = new ArrayList<Node>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(start);
		
		while(!stack.isEmpty()) {	// pop node off, push neighbors on, return if end found
			Node rem = stack.pop();
			visited.add(rem);
			if (rem == end) 
				return visited;
			for (int i = 0; i < rem.neighbors.size(); i++) {
				if (!visited.contains(rem.neighbors.get(i)))
					stack.push(rem.neighbors.get(i));
			}
		}
		return null; // if stack is empty and end not found
	}
	
	ArrayList<Node> BFTRec(final Graph graph) {
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<Node> traversal = new ArrayList<Node>();
		Iterator<Node> iter = graph.allNodes.iterator();
		
		return BFTRecHelper(iter, queue, traversal);
	}
	
	ArrayList<Node> BFTRecHelper(Iterator<Node> iter, Queue<Node> queue, ArrayList<Node> traversal) {

		if (queue.isEmpty()) {		// if queue is empty, check next node
			if (iter.hasNext()) {
				Node n = iter.next();
				if (!traversal.contains(n)) { // if not visited, add and continue
					traversal.add(n);
					queue.add(n);
				}
				else 			// if visited, recursively call BFT until all nodes checked
					BFTRecHelper(iter, queue, traversal);
			}
		}
		
		if (queue.isEmpty()) // checks again if queue empty, in case all nodes checked & still empty
			return traversal;

		Node curr = queue.remove();  // adds nodes neighbors to traverse & queue
		for (int i = 0; i < curr.neighbors.size(); i++) {
			Node currN = curr.neighbors.get(i);
			if (!traversal.contains(currN)) {
				traversal.add(currN);
				queue.add(currN);
			}
		}
		
		return BFTRecHelper(iter, queue, traversal);
	}
	
	ArrayList<Node> BFTIter(final Graph graph) {
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<Node> traversal = new ArrayList<Node>();
		
		for (Node node : graph.allNodes) {  // iterate through all nodes
			if (!traversal.contains(node)) {	// if not visited, add it and neighbors to queue
				traversal.add(node);
				queue.add(node);
				while (!queue.isEmpty()) {
					Node curr = queue.remove();
					for (int i = 0; i < curr.neighbors.size(); i++) {
						Node currN = curr.neighbors.get(i);
						if (!traversal.contains(currN)) {
							traversal.add(currN);
							queue.add(currN);
						}
					}
				}
			}
		}	
		return traversal;
	}
	
	void printGraphSearch(ArrayList<Node> search) {
		for (Node n : search) 
			System.out.print(n.val + " ");
		System.out.println();
	}
}