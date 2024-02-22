import java.util.ArrayList;
import java.util.HashSet;

public class GridGraph {
	
	ArrayList<GridNode> allNodes = new ArrayList<GridNode>();
	
	void addGridNode(final int x, final int y, final int nodeVal) {
		GridNode gn = new GridNode(x, y, nodeVal);
		allNodes.add(gn);
	}
	
	void addUndirectedEdge(final GridNode first, final GridNode second) {
		if (first.paths.contains(second) || !isNeighbor(first,second))
			return;
		
		first.paths.add(second);
		second.paths.add(first);	
	}
	
	void removeUndirectedEdge(final GridNode first, final GridNode second) {
		if (!first.paths.contains(second))
			return;
		
		first.paths.remove(second);
		second.paths.remove(first);
	}
	
	HashSet<GridNode> getAllNodes() {
		HashSet<GridNode> hashset = new HashSet<GridNode>();
		for (int i = 0; i < allNodes.size(); i++) 
			hashset.add(allNodes.get(i));
		return hashset;
	}
	
	boolean isNeighbor(GridNode first, GridNode second) {
		if (first.x == second.x) {
			if (first.y == second.y + 1 || first.y == second.y - 1) {
				return true;
			}
		}
		else if (first.y == second.y) {
			if (first.x == second.x + 1 || first.x == second.x - 1) {
				return true;	
			}
		}
		
		return false;
	}
	

	
	void printAllNodes() {
		HashSet<GridNode> hset = this.getAllNodes();
		for (GridNode n : hset) {
			System.out.print("(" + n.x + "," + n.y + ")  :  ");
			
			for (int i = 0; i < n.paths.size(); i++) {
				GridNode e = n.paths.get(i);
				System.out.print("(" + e.x + "," + e.y + ") ");
			}
			
			System.out.println("");
		}
	}

}