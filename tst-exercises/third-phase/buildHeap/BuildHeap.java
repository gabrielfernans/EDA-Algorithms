import java.util.Arrays;
import java.util.Scanner;

class BuildHeap {
	private static Scanner scan;
	private static int index;
	private static int[] heap;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		String[] values = scan.nextLine().split(" ");
		int[] intValues = new int[values.length];
		
		for (int i = 0; i < values.length; i++) {
			intValues[i] = Integer.parseInt(values[i]);
		}
		
		System.out.println(Arrays.toString(buildHeap(intValues)));
	}
	
	private static int[] buildHeap(int[] array) {
		heap = array;
		index = array.length - 1;
		
		for (int i = parent(index); i >= 0; i--) {
			heapify(i);
		}
		return heap;
	}
	
	private static void heapify(int position) {
		int max = maxIndex(position, left(position), right(position));

		if (max != position) {
			swap(heap, position, max);
			heapify(max);
		}
	}
	
	private static int maxIndex(int position, int left, int right) {
		int pos = position;
		
		if (left < size()) {
			pos = (heap[position] > heap[left]) ? position : left;
		}
			
		if (right < size()) {
			pos = (heap[pos]> heap[right]) ? pos : right;
		}
		return pos;
	}
	
	private static int size() {
		return index + 1;
	}

	private static int parent (int pos) {
		return (pos + 1) / 2;
	}
	
	private static int left (int pos) {
		return (pos * 2 + 1);
	}
	
	private static int right (int pos) {
		return (pos * 2 + 1) + 1;
	}
	
	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
