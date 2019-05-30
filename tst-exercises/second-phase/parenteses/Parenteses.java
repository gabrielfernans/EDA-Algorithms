import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Parenteses {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] entry = scan.nextLine().split("");

		LinkedList<String> sequenceList = new LinkedList<String>();
		
		for (String element : entry) {
			sequenceList.add(element);
		}

		if (validSequence(sequenceList)) {
			System.out.println("S");
		}
		
		else {
			System.out.println("N");
		}
		scan.close();
	}

	private static boolean validSequence(LinkedList<String> sequence) {
		if (sequence.size() % 2 != 0 || !sequence.peekFirst().equals("(")) {
			return false;
		}
		
		Stack<String> stack = new Stack<String>();
		boolean result = true;
		int i = 0;
		
		while (result && i < sequence.size()) {
			if (sequence.get(i).equals(")") && stack.isEmpty()) {
				result = false;
			}
			
			else if (sequence.get(i).equals("(")) {
				stack.push(sequence.get(i));
			}
			
			else {
				stack.pop();
			}
			i++;
		}
		return result && stack.isEmpty();
	}
}
