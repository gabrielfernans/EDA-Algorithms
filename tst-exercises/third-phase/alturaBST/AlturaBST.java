import java.util.Scanner;

class AlturaBST {
	private static Scanner scan;
	private static Node root;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		
		for (int i = 0; i < input.length; i++) {
			insert(Integer.parseInt(input[i]));
		}
		System.out.println(height(root));
	}
	
	public static Node getRoot() {
		return root;
	}
	
	public static boolean isEmpty() {
		return root == null;
	}
	
	public static int height(Node node) {
		int result = -1;
		
		if (node != null) {
			int leftHeight = height(node.getLeft());
			int rightHeight = height(node.getRight());
			
			if (leftHeight > rightHeight) {
				result = leftHeight + 1;
			}
			
			else {
				result = rightHeight + 1; 
			}
			
		}
		return result;
	}
	
	public static void insert(Integer value) {
		Node newNode = new Node(value);
		
		if (isEmpty()) {
			root = newNode;
		}
		
		else {
			insertNotEmpty(value, newNode);
		}
	}
	
	public static void insertNotEmpty(Integer value, Node node) {
		Node aux = root;
		
		while(aux != null) {
			if (value > aux.getValue()) {
				if (aux.getRight() == null) {
					node.setParent(aux);
					aux.setRight(node);
					break;
				}	
				else {
					aux = aux.getRight();
				}
			}
			else if (value < aux.getValue()) {
				if (aux.getLeft() == null) {
					node.setParent(aux);
					aux.setLeft(node);
					break;
				}	
				else {
					aux = aux.getLeft();
				}
			}
			else if (value == aux.getValue()) {
				break;
			}
		}
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