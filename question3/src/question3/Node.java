package question3;
import java.util.*;
public class Node {
	public String val;
	public ArrayList<Node> neighbors;
	public Node(final String nodeVal) {
		val = nodeVal;
		neighbors = new ArrayList<Node>();
	}
	
	public String toString() {
		return val;
	}
}