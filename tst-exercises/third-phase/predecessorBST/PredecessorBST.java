import java.util.Arrays;
import java.util.Scanner;

class PredecessorBST {
	
	private static Node root;
	private static Scanner scan;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String[] values = scan.nextLine().split(" ");
		Integer element = scan.nextInt();
		
		for (int i = 0; i < values.length; i++) {
			insert(Integer.parseInt(values[i]));
		}
		System.out.println(Arrays.toString(predecessor(element)));
	}
	
	public static Integer[] predecessor(Integer element) {
		Integer[] auxValues = new Integer[size()];
		
		Node aux = search(element);
		int i = 0;
		
		if (aux != null) {
			auxValues[i++] = aux.getValue();
			
			if (aux.getLeft() == null) {
				aux = aux.getParent();
				
				while (aux != null) {
					auxValues[i++] = aux.getValue();
					
					if (aux.getValue() <= element) {
						break;
					}
					aux = aux.getParent();
				}
			}
			else {
				aux = aux.getLeft();
				
				while(aux != null) {
					auxValues[i++] = aux.getValue();
					aux = aux.getRight();
				}
			}
		}
		Integer[] output = new Integer[i];
		
		for (int j = 0; j < output.length; j++) {
			output[j] = auxValues[j];
		}
		return output;
	}
	
	public static Node search(Integer element) {
		Node aux = null;
		
		if (element != null && !isEmpty()) {
			aux = root;
			while (aux != null && aux.getValue().compareTo(element) != 0) {
				if (element.compareTo(aux.getValue()) > 0) {
					aux = aux.getRight();
				} 
				else if (element.compareTo(aux.getValue()) < 0) {
					aux = aux.getLeft();
				}
			}
		}
		return aux;
	}
	
	public static Node getRoot() {
		return root;
	}
	
	public static boolean isEmpty() {
		return root == null;
	}
	
	public static void insert(Integer value) {
		Node newNode = new Node(value);
		
		if (isEmpty()) {
			root = new Node(value);
		}
		
		else {
			insertNotEmpty(value, newNode);
		}
	}

	private static void insertNotEmpty(Integer value, Node newNode) {
		Node aux = root;
		
		while(aux != null) {
			if (value > aux.getValue()) {
				if (aux.getRight() == null) {
					newNode.setParent(aux);
					aux.setRight(newNode);
					break;
				}
				else {
					aux = aux.getRight();
				}
			}
			else if (value < aux.getValue()) {
				if(aux.getLeft() == null) {
					newNode.setParent(aux);
					aux.setLeft(newNode);
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
	
	private static int size() {
		return size(root);
	}
	
	private static int size(Node node) {
        if (node == null) {
        	return 0;
        }
        else {
        	return 1 + size(node.getLeft()) + size(node.getRight());
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