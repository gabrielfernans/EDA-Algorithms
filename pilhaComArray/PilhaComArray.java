import java.util.Scanner;

class PilhaComArray {

	private int[] array;
	private int top;

	public PilhaComArray(int tamanho) {
		array = new int[tamanho];
		top = -1;
	}

	public void push(int element) {
		if (top < array.length - 1) {
			array[++top] = element;
		} 
		else {
			System.out.println("full");
		}
	}

	public int pop() {
		int result = -1;
		
		if (!isEmpty()) {
			top--;
			result = array[top + 1];
		}
		return result;
	}

	public int peak() {
		int result = -1;
		
		if (!isEmpty()) {
			result = array[top];
		}
		return result;
	}

	public String print() {
		String result = "empty";
		
		if (!isEmpty()) {
			result = "";
			
			for (int i = 0; i < top; i++) {
				result += array[i] + " ";
			}
			result += array[top] + "";
		}
		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		PilhaComArray stack = new PilhaComArray(size);
		String entry = "";
		
		while (!entry.equals("end")) {
			entry = scan.nextLine();
			
			if (entry.equals("pop")) {
				int i = stack.pop();
				
				if (i == -1) {
					System.out.println("empty");
				}
			}
			else if (entry.equals("peek")) {
				System.out.println(stack.peak());
			}
			else if (entry.equals("print")) {
				System.out.println(stack.print());
			}
			else {
				String[] op = entry.split(" ");
				
				if (op[0].equals("push")) {
					stack.push(Integer.parseInt(op[1]));
				}
			}
		}
		scan.close();
	}
}
