package com.granada.reference.btree;

class Node {
	public int data;
	public Node left=null;
	public Node right = null;
	public Node(int value) {
		this.data=value;
	}
}
public class LevelOrderTraversal {
	
	private int findHeight(Node root) {
		
		if(root == null) {
			return 0;
		}
		else {
			int leftHeight = 1+ findHeight(root.left);
			int rightHeight = 1 + findHeight(root.right);
			return Math.max(leftHeight, rightHeight);
		}
	}
	
	public void printLevelOrder(Node root) {
		
		int heightOfTheTree = findHeight(root);
		System.out.println("height of the tree = " + heightOfTheTree);
		for(int i=1;i<=heightOfTheTree;i++) {
			printGivenLevel(root,i);
			System.out.println();
		}
	}
	
	private void printGivenLevel(Node root, int level) {
		
		if(root == null) {
			return;
		}
		else if (level == 1) {
			System.out.print(root.data + " ");
		}
		else if(level >1) {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
public static void main(String[] args) {
	
	Node root = new Node(5);
	root.left = new Node(2);
	root.left.left = new Node(1);
	root.left.right = new Node(15);
	root.right = new Node(6);
	root.right.right = new Node(7);
	root.right.left = new Node(4);
	root.right.left.left = new Node(3);
	root.right.left.right = new Node(9);
	
	
	new LevelOrderTraversal().printLevelOrder(root);
}
}
