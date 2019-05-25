import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class DireitaBFS {
	private static Scanner scan;
	private static Node root;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		String[] values = scan.nextLine().split(" ");
		
		for (int i = 0; i < values.length; i++) {
			insert(Integer.parseInt(values[i]));
		}
		System.out.println(bfs());
	}
	
	public static String bfs() {
		String output = "";
		
        if (!isEmpty()) {
            Deque<Node> queue = new LinkedList<Node>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
            
                Node num = queue.removeFirst();
                output += num.getValue() + " ";
            
                if (num.getRight() != null) {
                	queue.addLast(num.getRight());
                }
                
                if (num.getLeft() != null) {
                	queue.addLast(num.getLeft());
                }
            }
        }
        return (String) output.subSequence(0, output.length() - 1);
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
