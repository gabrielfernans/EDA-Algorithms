import java.util.Arrays;
import java.util.Scanner;

/**
 * Implementation of the "Insere Ultimo" algorithm
 * 
 * Time complexity O(n)
 * Space complexity O(1)
 * 
 * @author Gabriel Fernandes - github.com/gabrielfernans
 *
 */
class InsereUltimo {
	
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int[] array = getArrayInteger(scan);
		insereUltimo(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}
	
	private static void insereUltimo(int[] array) {
		int i = array.length-1;
		
		while(i > 0 && array[i] < array[i - 1]) {
			swap(array, i, i - 1);
			i--;
		}
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	private static int[] getArrayInteger(Scanner scan) {
		String[] entry = scan.nextLine().split(" ");
		int[] array = new int[entry.length];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entry[i]);
		}
		return array;
	}

}
