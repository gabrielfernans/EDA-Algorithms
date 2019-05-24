import java.util.Arrays;
import java.util.Scanner;

/**
 * Implementation of the "Insere Primeiro" algorithm
 * 
 * Time complexity O(n)
 * Space complexity O(1)
 * 
 * @author Gabriel Fernandes - github.com/gabrielfernans
 *
 */
class InserePrimeiro {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int[] array = getArrayInteger(scan);
		inserePrimeiro(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}
	
	private static void inserePrimeiro(int[] array) {
		int i = 0;
		
		while(i < array.length - 1 && array[i+1] < array[i]) {
			swap(array, i + 1, i);
			i++;
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
		
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entry[i]);
		}
		return array;
	}
	
}
