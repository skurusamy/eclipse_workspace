import java.util.*;
public class BST {
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	Node root;
	BST(){
		this.root = null;
	}
	Node insert(Node root, int ele) {
		Node n = new Node(ele,null,null);
		if(root == null) {
			root = n;
		}
		else if (ele > root.data) {
			root.right = insert(root.right,ele);
		}
		else if(ele < root.data) {
			root.left = insert(root.left,ele);
		}
		return root;
	}
	void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data+",");
			inorder(root.right);
		}
	}
	int search(Node root, int ele) {
		int val =-1;
		if(root == null) {
			return val;
		}
		if(root.data > ele) {
			val = search(root.left,ele);
		}
		else if(root.data < ele) {
			val = search(root.right,ele);
		}
		else {
			val = root.data;
		}
		return val;
	}
	int findMin(Node root) {
		Node curr = root;
		while(curr.left != null) {
			curr = curr.left;
		}
		return curr.data;
	}
	Node delete(Node root,int ele) {
		if(root == null) {
			return null;
		}
		/***deleting root only if root is present**/
		if(root.data == ele && root.left == null && root.right ==null ) {
			root = null;
		}
		//traverse through the tree to find the node to be deleted.
		Node curr = root;
		Node parent = null;
		while(curr.data != ele ) {
			parent = curr;
			if(curr.data > ele)
				curr = curr.left;
			else if(curr.data < ele)
				curr = curr.right;
			else
				break;
		}
		
		//Delete node with no child (curr is the node to be deleted)
		if(curr.left == null && curr.right ==null) {
		if(parent.left == curr) {
			parent.left = null;
		}
		else if(parent.right == curr) {
			parent.right = null;
		}
		}
		// Delete a node with one child
		
		if(curr.left == null && curr.right!=null)//node has right child
		{
			//check if its right or left child to the parent
			if(parent.left == curr)
				parent.left = curr.right;
			if(parent.right == curr)
				parent.right = curr.right;
		}
		else if(curr.left != null && curr.right==null)//node has left child
		{
			//check if its right or left child to the parent
			if(parent.left == curr)
				parent.left = curr.left;
			if(parent.right == curr)
				parent.right = curr.left;
		}
		//delete node with 2 children
		if(curr.left !=null && curr.right != null) {
			int suc = findMin(curr.right);
			curr.data  = suc;
			curr.right = delete(curr.right,suc);
		}
		return root;
	}
	
	void levelOrder(Node root) {
		System.out.println();// just for clear output 
		if(root == null) {
			return;
		}
		Node curr;
		List<Node> stack = new ArrayList<Node>();
		stack.add(root);
		while(!(stack.isEmpty())) {
			curr = stack.remove(0);
			System.out.print(curr.data+ ",");
			if(curr.left != null) {
				stack.add(curr.left);
			}
			if(curr.right != null) {
				stack.add(curr.right);
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		Node root = null;
		root = bst.insert(root,10);
		root = bst.insert(root,5);
		root = bst.insert(root,16);
		root = bst.insert(root,2);
		root = bst.insert(root,50);
		root = bst.insert(root,30);
		root = bst.insert(root,8);
		root = bst.insert(root,1);
		root = bst.insert(root,3);
		root = bst.insert(root, 7);
		//bst.inorder(root);
		/** search
		int search_output = bst.search(root,500);
		if(search_output == -1) {
			System.out.println("Element not Found");
		}
		else {
			System.out.println("Element found:"+search_output);
		}
		**/
		root = bst.delete(root, 5);
		bst.levelOrder(root);

	}

}
