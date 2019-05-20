package tst;

import java.util.Scanner;

class AlturaBST {
	private static Scanner scan;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int[] array = getIntArray(scan);
		
		BST tree = new BST();
		for (int element : array) {
			tree.insert(element);
		}
		System.out.println(tree.height());
		scan.close();
	}
	
	private static int[] getIntArray(Scanner scan) {
		String[] input = scan.nextLine().split(" ");
		int[] array = new int[input.length];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		return array;
	}
}

class BST {
	private Node root;
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void insert(int value) {
		if (isEmpty()) {
			this.root = new Node(value);
		}
		else {
			this.root.insert(value);
		}
	}
	
	public int height() {
		return this.height(root);
	}

	private int height(Node node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
		return result;
	}

	public Node getRoot() {
		return root;
	}
	
}

class Node {
	
	private int value;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
	}

	public void insert(int value) {
		if (value > this.value) {
			if (this.right == null) {
				Node newNode = new Node(value);
				this.right = newNode;
				newNode.parent = this;
			}
			else {
				this.right.insert(value);
			}
		}
		
		else if (value < this.value) {
			if (this.left == null) {
				Node newNode = new Node(value);
				this.left = newNode;
				newNode.parent = this;
			}
			else {
				this.left.insert(value);
			}
		}
	}
	
	public boolean isEmpty() {
		return this.value == 0;
	}
	public Node getParent() {
		return parent;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
