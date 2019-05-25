import java.util.ArrayList;
import java.util.Scanner;

public class quantidadeElementosMaioresBST {
	public static Node root = new Node(null);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string[] = sc.nextLine().split(" ");
		int numeroAlvo = sc.nextInt();
		sc.nextLine();
		sc.close();
		
		for (int i = 0; i < string.length; i++) {
			insereNaBST(Integer.parseInt(string[i]), getRoot());
		}
		
		int numNumerosMaiores = verificaNumerosMaiores(numeroAlvo, getRoot());
		
		System.out.println(preOrder().toString() + "\n" + numNumerosMaiores);
		//System.out.println(numNumerosMaiores);
	}

	private static ArrayList<Integer> preOrder() {
		ArrayList<Integer> lista =  new ArrayList<Integer>(size());
		preOrder(getRoot(), lista);
		return lista;
	}

	private static void preOrder(Node node, ArrayList<Integer> lista) {
		if (node.getValue() != null) {
			lista.add(node.getValue());
			preOrder(node.getLeft(), lista);
			preOrder(node.getRight(), lista);
		}
		
	}

	private static int verificaNumerosMaiores(int num, Node node) {
		int retorno = 0;
		if (node.getValue() != null) {
			if(node.getValue() > num) {
				retorno += 1 + size(node.getRight());
				retorno += verificaNumerosMaiores(num, node.getLeft());
			} else {
				retorno += verificaNumerosMaiores(num, node.getRight());
			}
		}
		return retorno;
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

	private static void insereNaBST(int num, Node node) {
		if (node.getValue() == null) {
			node.setValue(num);
			node.setLeft(new Node(null));
			node.setRight(new Node(null));
		} else if (num < node.getValue()){
			insereNaBST(num, node.getLeft());
		} else if (num > node.getValue()) {
			insereNaBST(num, node.getRight());
		}
	}

	private static Node getRoot() {
		return root;
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

