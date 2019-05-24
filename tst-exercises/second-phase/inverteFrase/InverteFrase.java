import java.util.Scanner;
import java.util.Stack;

class InverteFrase {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		String phrase = scan.nextLine();
		String aux = "";
		
		for (int i = 0; i < phrase.length(); i++) {
			if (Character.isSpaceChar(phrase.charAt(i))) {
				stack.push(aux);
				aux = "";
			} 
			else {
				aux += phrase.charAt(i);
			}
		}
		stack.push(aux);
		String result = "";
		
		while (!stack.isEmpty()){
			result += stack.pop() + " ";
		}
		result = result.trim();
		System.out.println(result);
		scan.close();
	}
}