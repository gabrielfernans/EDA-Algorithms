import java.util.Arrays;
import java.util.Scanner;
/**
 * Implementation of the Merge Sort algorithm (step by step)
 * 
 * Time complexity O(NLogN)
 * Space complexity O(N)
 * 
 * @author Gabriel Fernandes - github.com/gabrielfernans
 *
 */
class MergeSort {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int[] array = getArrayIntegers(scan);
		mergeSort(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}

	private static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
		printArray(array, leftIndex, rightIndex);
		
		if (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, mid);
			mergeSort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);

			if (rightIndex - leftIndex < array.length-1) {
				printArray(array, leftIndex, rightIndex);
			}
		}
	}

	private static void merge(int[] array, int leftIndex, int mid, int rightIndex) {
		int[] aux = Arrays.copyOf(array, array.length);

		int i = leftIndex;
		int j = mid + 1;
		int currentIndex = leftIndex;

		while (i <= mid && j <= rightIndex) {
			if (aux[i] < aux[j]) {
				array[currentIndex] = aux[i];
				i++;	
			}
			
			else {
				array[currentIndex] = aux[j];
				j++;
			}
			currentIndex++;
		}

		while (i <= mid) {
			array[currentIndex] = aux[i];
			i++;
			currentIndex++;
		}

		while (j <= rightIndex) {
			array[currentIndex] = aux[j];
			j++;
			currentIndex++;
		}
	}

	private static int[] getArrayIntegers(Scanner scan) {
		String[] entry = scan.nextLine().split(" ");
		int[] array = new int[entry.length];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entry[i]);
		}
		return array;
	}

	private static void printArray(int[] array, int leftIndex, int rightIndex) {
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, leftIndex, rightIndex + 1)));
	}
}
