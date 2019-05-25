import java.util.ArrayList;
import java.util.Scanner;

class QuantidadeElementosMaioresBST {
	private static Scanner scan;
	private static Node root = new Node(null);
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		String[] values = scan.nextLine().split(" ");
		int numeroAlvo = scan.nextInt();
		scan.nextLine();
		scan.close();
		
		for (int i = 0; i < values.length; i++) {
			insert(Integer.parseInt(values[i]), getRoot());
		}
		
		int num = biggerElements(numeroAlvo, getRoot());
		
		System.out.println(preOrder().toString() + "\n" + num);
	}
	
	private static ArrayList<Integer> preOrder() {
		ArrayList<Integer> list =  new ArrayList<Integer>(size());
		preOrder(getRoot(), list);
		return list;
	}
	
	private static void preOrder(Node node, ArrayList<Integer> list) {
		if (node.getValue() != null) {
			list.add(node.getValue());
			preOrder(node.getLeft(), list);
			preOrder(node.getRight(), list);
		}
	}
	
	private static int biggerElements(int num, Node node) {
		int output = 0;
		
		if (node.getValue() != null) {
			if(node.getValue() > num) {
				output += 1 + size(node.getRight());
				output += biggerElements(num, node.getLeft());
			} 
			else {
				output += biggerElements(num, node.getRight());
			}
		}
		return output;
	}
	
	public static Node getRoot() {
		return root;
	}
	
	public static boolean isEmpty() {
		return root == null;
	}
	
	public static void insert(Integer num, Node node) {
		if (node.getValue() == null) {
			node.setValue(num);
			node.setLeft(new Node(null));
			node.setRight(new Node(null));
		} 
		else if (num < node.getValue()) {
			insert(num, node.getLeft());
		} 
		else if (num > node.getValue()) {
			insert(num, node.getRight());
		}
	}
	
	private static int size() {
		return size(root);
	}
	
	private static int size(Node node) {
		int size = 0;
		
		if (node.getValue() != null) {
			size = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return size;
    }
}

class Node {
	private Integer value;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(Integer value) {
		this.value = value;
	}
	
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}

	public Integer getValue() {
		return value;
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

	public void setValue(Integer value) {
		this.value = value;
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
