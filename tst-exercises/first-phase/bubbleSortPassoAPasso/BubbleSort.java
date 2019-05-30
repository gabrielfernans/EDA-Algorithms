import java.util.Scanner;

/**
 * Implementation of the Bubble Sort algorithm (step by step)
 * 
 * Time complexity O(n^2)
 * Space complexity O(1)
 * 
 * @author Gabriel Fernandes - github.com/gabrielfernans
 *
 */
class BubbleSort {
	
	private static Scanner scan;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String[] entry = scan.nextLine().split(" ");
		int[] arrayInteger = new int[entry.length];
		
		for(int i=0; i < entry.length; i++) {
			arrayInteger[i] = Integer.parseInt(entry[i]);
		}
		
		bubbleSort(arrayInteger);
		scan.close();
	}

	private static void bubbleSort(int[] array) {
		
		boolean flag;
		boolean sorted = sortedArray(array);
		
		if(sorted) {
			System.out.println(printArray(array));
		}
		
		else {
			while(!sorted) {
				flag = false;
				
				for(int i = 0; i < array.length - 1; i++) {
					if(array[i] > array[i+1]) {
						swap(array, i, i+1);
						flag = true;
					}
				}
				
				if(!flag) {
					sorted = true;
				}
				
				else {
					System.out.println(printArray(array));
				}		
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	private static String printArray(int[] array) {
		String aux = "";
		
		for(int i = 0; i < array.length - 1; i++)
			aux += array[i] + " ";
		
		aux += array[array.length - 1] + "";
		return aux;
	}

	private static boolean sortedArray(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
}
