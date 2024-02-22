import java.util.Vector;

public class GridNode {
	
	GridNode(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
		this.paths = new Vector<GridNode>();
	}
	
	int x, y, val;
	Vector<GridNode> paths;
}