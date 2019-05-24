package ae1_3;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveSelectionSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];
		
		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		sort(seq, 0, seq.length-1);	
		sc.close();
	}

	public static void sort(int[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex < rightIndex) {
			int minIndex = leftIndex;
			for (int i = leftIndex+1; i <= rightIndex; i++) {
				if (array[i] < array[minIndex]) {
					minIndex = i;
				}
			}
			swap(array, minIndex, leftIndex);
			System.out.println(Arrays.toString(array));
			sort(array, leftIndex+1, rightIndex);
		}	
	}

	public static void swap(int[] array, int minIndex, int i) {
		if (minIndex != i) {
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
	
}
