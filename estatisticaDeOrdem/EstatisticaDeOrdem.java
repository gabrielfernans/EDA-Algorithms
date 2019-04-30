package ae1_4;

import java.util.Scanner;

public class EstatisticaDeOrdem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] seq = getIntArray(entrada);

		System.out.println(kEsimoElemento(seq));
	}
	
	public static int[] getIntArray(String[] entrada) {

		int[] out = new int[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			out[i] = Integer.parseInt(entrada[i]);
		}
		return out;
	}
	
	public static int kEsimoElemento(int[] seq) {
		
		int tamanho = max(seq); 		   	
		int[] contagem = new int[tamanho + 1];		
		contarFrequencia(seq, contagem, tamanho + 1); 
		
		return cumulativa(contagem, seq[0]); 
	}
	
	public static int max(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static void contarFrequencia(int[] array, int[] contagem, int tam) {
		
		for (int n = 0; n < tam; n++) {			// preencher o array de contagem com zeros
			contagem[n] = 0;
		}
		for (int j = 0; j < array.length; j++) {	// preencher contagem com frequencias
			contagem[array[j]] += 1;
		}
	}

	public static int cumulativa(int[] array, int k) {
		int soma = 0;
		for (int i = 0; i < array.length; i++) {
			soma += array[i];
			array[i] = soma;
		}
		return array[k];
	}

}
