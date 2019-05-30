import java.util.Arrays;
import java.util.Scanner;

/**
 * Implementation of the Selection Sort algorithm (step by step)
 * 
 * Time complexity O(n^2)
 * Space complexity O(1)
 * 
 * @author Gabriel Fernandes - github.com/gabrielfernans
 *
 */
class SelectionSort {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String[] entry = scan.nextLine().split(" ");
		
		int[] array = new int[entry.length];
		
		for(int i = 0; i < entry.length; i++) {
			array[i] = Integer.parseInt(entry[i]);
		}
		
		selectionSort(array);
		scan.close();
	}
	
	private static void selectionSort(int[] array) {
		int indexOfMinimum;
		
		for(int i = 0; i < array.length; i++) {
			indexOfMinimum = i;
			
			for(int j = i + 1; j < array.length; j ++) {
				if (array[j] < array[indexOfMinimum]) {
					indexOfMinimum = j;
				}
			}
			
			swap(array, indexOfMinimum, i);
			if(indexOfMinimum != i) {
				System.out.println(Arrays.toString(array));
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
