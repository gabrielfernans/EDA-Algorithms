package ae1_4;

import java.util.Arrays;
import java.util.Scanner;

public class CountingNegativo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int max = Integer.parseInt(sc.nextLine());
		int min = Integer.parseInt(sc.nextLine());
		int[] seq = getIntArray(entrada);

		sort(seq, 0, seq.length-1, min, max);
		sc.close();
	}
	
	public static int[] getIntArray(String[] entrada) {
		int[] out = new int[entrada.length];
		
		for (int i = 0; i < entrada.length; i++) {
			out[i] = Integer.parseInt(entrada[i]);
		}
		return out;
	}
	
	public static void sort(int[] array, int leftIndex, int rightIndex, int min, int max) {
		if (leftIndex < rightIndex && rightIndex > -1) {

			int k = Math.abs(min) + Math.abs(max);
			int[] contagem = new int[k + 1];
			contarFrequencia(array, contagem, k + 1, min); 
			cumulativa(contagem);
			
			System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(contagem));

			int[] b = new int[rightIndex + 1];
			
			for (int i = rightIndex; i >= 0; i--) {
				b[contagem[array[i] + Math.abs(min)] - 1] = array[i];
				contagem[array[i] + Math.abs(min)] -= 1;
			}
			
			System.out.println(Arrays.toString(contagem));
			
			for (int i = 0; i < array.length; i++) {
				array[i] = b[i];
			}
			System.out.println(Arrays.toString(array));
		}
	}

	public static void contarFrequencia(int[] array, int[] contagem, int tam, int min) {
		for (int n = 0; n < tam; n++) {
			contagem[n] = 0;
		}
		
		for (int j = 0; j < array.length; j++) {
			
			if (array[j] < 0) {
				contagem[Math.abs(min) - Math.abs(array[j])] += 1;
			}
			
			else {
				contagem[Math.abs(min) + array[j]] += 1;
			}
			System.out.println(Arrays.toString(contagem));
		}
	}

	public static void cumulativa(int[] contagem) {
		int soma = 0;
		for (int i = 0; i < contagem.length; i++) {
			soma += contagem[i];
			contagem[i] = soma;
		}
	}
}
