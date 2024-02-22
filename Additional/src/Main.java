import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		/// Question 3
				
		Graph g = createLinkedList_3(100);
//		BFTRecLinkedList(g); !! crashes bc runs out of stack space !!
		BFTIterLinkedList(g);
		
		
		/// Question 4 
		
		DirectedGraph directed = createRandomDAGIter(1000);
		TopSort topsort = new TopSort();
		
		topsort.Kahns(directed);
		topsort.mDFS(directed);
		

		/// Question 5
		
		WeightedGraph wgRandom = createRandomCompleteWeightedGraph(100);
		WeightedGraph wgLinked = createLinkedList(100);

		dijkstras(wgRandom.allNodes.get(0));
		dijkstras(wgLinked.allNodes.get(0));


		/// Question 6
		
		GridGraph gg = createRandomGridGraph(100);
		
		astar(gg.allNodes.get(0), gg.allNodes.get(999));
	}
	
	
	/// Question 3
	
	static Graph createRandomUnweightedGraphIter(int n) {
		Graph g = new Graph();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) 
			g.addNode(new Node(i).val);
		
		for (int i = 0; i < n; i++) {
			if (random.nextInt(2) == 0) {
				int r = random.nextInt(n);
				g.addUndirectedEdge(g.allNodes.get(i), g.allNodes.get(r));
			}
		}	
		return g;
	}
	
	static Graph createLinkedList_3(int n) {
		Graph g = new Graph();
		
		for (int i = 0; i < n; i++) {
			g.addNode(i);
			if (i == 0)
				continue;
			g.addUndirectedEdge(g.allNodes.get(i), g.allNodes.get(i-1));	
		}		
		return g;
	}
	
	static ArrayList<Node> BFTRecLinkedList(final Graph graph) {
		GraphSearch search = new GraphSearch();
		return search.BFTRec(graph);
	}
	
	static ArrayList<Node> BFTIterLinkedList(final Graph graph) {
		GraphSearch search = new GraphSearch();
		return search.BFTIter(graph);
	}
	
	
	/// Question 4
	
	static DirectedGraph createRandomDAGIter(final int n) {
		DirectedGraph g = new DirectedGraph();
		Random random = new Random();
		for (int i = 0; i < n; i++) 
			g.addNode(i);
		
		for (int i = 0; i < n-1; i++) {
			int r = random.nextInt(n - i - 1) + i + 1;
			g.addDirectedEdge(g.allNodes.get(i), g.allNodes.get(r));	
		}
		return g;
	}
	
	
	/// Question 5
	
	static WeightedGraph createRandomCompleteWeightedGraph(final int n) {
		WeightedGraph w = new WeightedGraph();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) 
			w.addNode(i);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				w.addWeightedEdge(w.allNodes.get(i), w.allNodes.get(j), random.nextInt(100));
			}
		}
		return w;
	}
	
	static WeightedGraph createLinkedList(final int n) {
		WeightedGraph w = new WeightedGraph();
		
		for (int i = 0; i < n; i++) 
			w.addNode(i);
		
		for (int i = 0; i < n - 1; i++) 
			w.addWeightedEdge(w.allNodes.get(i), w.allNodes.get(i+1), 1);
		
		return w;
	}
	
	static HashMap<Node, Integer> dijkstras(final Node start) {
		HashMap<Node, Integer> output = new HashMap<Node, Integer>();
		ArrayList<Node> finalized = new ArrayList<Node>();
		
		int infinity = Integer.MAX_VALUE;

		output.put(start, 0);
		for (Edge e : start.weightedNeighbors) 
			output.put(e.dest, infinity);
		
		
		for (Node curr = start; curr!= null; curr = minDistance(output, finalized)) {
			
			finalized.add(curr);
			
			for (Edge e : curr.weightedNeighbors) {  // checks neighbors that aren't finalized to update their min height
				if (!finalized.contains(e.dest)) {
					if (!output.containsKey(e.dest))
						output.put(e.dest, infinity);
					int d = output.get(curr) + e.weight;
					if (d < output.get(e.dest)) 
						output.replace(e.dest, d);	
				}
			}	
		}
		
		return output;
	}
	
	// returns null if no other min distance found
	static Node minDistance(HashMap<Node, Integer> hmap, ArrayList<Node> finalized) {	
		int dist = Integer.MAX_VALUE;
		Node minNode = null;
		for (Node n : hmap.keySet()) {
			if (hmap.get(n) < dist && !finalized.contains(n)) {
				dist = hmap.get(n);
				minNode = n;
			}
		}
		return minNode;
	}
	
	
	/// Question 6
	
	static GridGraph createRandomGridGraph(int n) {
		GridGraph g = new GridGraph();
		Random random = new Random();
		
		for (int i = 0, val = 0; i < n; i++, val++) {
			for (int j = 0; j < n; j++) {
				g.addGridNode(i, j, val);
			}
		}		
		
		for (int i = 0; i < g.allNodes.size(); i++) {		// goes through the graph and checks for left and top neighbors only (if possible)
			GridNode curr = g.allNodes.get(i);
			boolean left = ((i + 1) % n == 0) ? false : true;
			boolean up = (i + n) >= n*n ? false : true;
			
			if (left && up) {
				if (random.nextBoolean()) {
					g.addUndirectedEdge(curr, g.allNodes.get(i + n));
				}
				if (random.nextBoolean()) {
					g.addUndirectedEdge(curr, g.allNodes.get(i + 1));
				}
			}
			else if (left) {
				if (random.nextBoolean()) {
					g.addUndirectedEdge(curr, g.allNodes.get(i + 1));
				}
			}
			else if (up) {
				if (random.nextBoolean()) {
					g.addUndirectedEdge(curr, g.allNodes.get(i + n));
				}
			}
		}
		
		return g;
	}
	
	static ArrayList<GridNode> astar(final GridNode sourceNode, final GridNode destNode) {
		ArrayList<GridNode> finalized = new ArrayList<GridNode>();
		HashMap<GridNode, int[]> map = new HashMap<GridNode, int[]>();
		HashMap<GridNode, GridNode> sources = new HashMap<GridNode, GridNode>();
		
		boolean found = false;
		int infinity = Integer.MAX_VALUE;
		int distance = manhattan(sourceNode, destNode);
		map.put(sourceNode, new int[] {0, distance});
		
		GridNode curr = sourceNode;
		
		while (curr != null) {
			finalized.add(curr);
			
			if (curr == destNode) {
				found = true;
				break;
			}
			
			for (GridNode gr : curr.paths) {	// iterates neighbors, if not finalized, (re)calculates g
				if (!map.containsKey(gr)) {
					map.put(gr, new int[] {infinity, manhattan(gr, destNode)});
					sources.put(gr, null);
				}
				if (!finalized.contains(gr)) {
					distance = map.get(curr)[0] + 1;
					if (distance < map.get(gr)[0]) {
						map.get(gr)[0] = distance;
						sources.replace(gr, curr);
					}
				}
			}
			
			GridNode comp = curr;
			int min = Integer.MAX_VALUE;
			for (GridNode n : map.keySet()) {
				if (!finalized.contains(n)) { 	// finds next min path node not finalized
					int[] dists = map.get(n);
					if (dists[0] + dists[1] < min) {
						curr = n;
						min = dists[0] + dists[1];
					}
				}
			}	
			if (comp == curr) // if all nodes finalized 
				break;
		}
		
		if (!found) 
			return new ArrayList<GridNode>();
		
		Stack<GridNode> stack = new Stack<GridNode>();	// retraces steps to find direct path
		stack.push(destNode);
		GridNode source = sources.get(destNode);
		while(source != sourceNode) {
			stack.push(source);
			source = sources.get(source);
		}
		stack.push(sourceNode);
		
		ArrayList<GridNode> path = new ArrayList<GridNode>();
		
		int n = stack.size();
		for (int i = 0; i < n; i++)
			path.add(stack.pop());
		
		return path;
	}
	
	static int manhattan(GridNode a, GridNode b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	
	/// Question 7 (Extra Credit)  -- incremented in respective methods
	
	static int dijkstrasFinalized = 0;
	static int astarFinalized = 0;

}
