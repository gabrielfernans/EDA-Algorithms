import java.util.Scanner;

/**
 * Classe que representa a resolução da atividade "Elementos duplicados", que avalia uma entrada de N números e mostra
 * se existem elementos duplicados na entrada.
 * 
 * Função de custo: O tamanho da entrada será chamada de N, as linhas que possuem constantes se chamarão L e as constantes
 * serão representadas por C (cada constante tem custo 1).
 * 
 * @author Gabriel Fernandes da Costa - 118110739
 *
 */
class DuplicatedElements {
	private static Scanner sc;          
	public static void main(String[] args) {
		sc = new Scanner(System.in);                                       // L1 = C1
		String entry = sc.nextLine();                                      // L2 = C2
		
		String[] elements = entry.split(" "); 			           // L3 = N * C
		boolean duplicated = false;                                        // L4 = C3
		              
 		for (int i=0; i < elements.length; i++) {                          // L5 = CL1 + CL2 + CL3 + CL4
 			
 			for (int n=0; n < elements.length; n++) {                  // L6 = CL5 + CL6 + CL7 + CL8  
	
 				if(elements[i].equals(elements[n]) && i != n) {    // L7 = CL9 + CL10 + CL11 + CL12 + CL13
					duplicated = true;                         // L8 = CX (Constante ignorada)
				}
			}
		}
 		System.out.println(duplicated);                                    // L9 = C4
	} 
}
/*
 * Explicação da execução: 
 * 
 * Na linha L1 há uma constante C1.
 * 
 * Na linha L2 há uma constante C2.
 * 
 * Na linha L3 há o método split que percorre toda a entrada que é recebida e salva os elementos no array e, portanto,
 *    possui um custo representado por N * C.
 *    
 * Na linha L4 há uma constante C3.
 * 
 * Na linha L5 existem as constantes CL1, CL2 e CL3 que serão executadas N+1 vezes e a constante CL4 que será executada N vezes,
 *    onde N é o número de iterações do loop primário.
 *    
 * Na linha L6 existem as constantes CL5, CL6 e CL7 que serão executadas N+1 vezes e a constante CL8 que será executada N vezes,
 * 	  onde N é o número de iterações do loop secundário.
 * 
 * Na linha L7 existem as constantes CL9, CL10, CL11, CL12 e CL13 que se repetirão N*N vezes.
 * 
 * Na linha L8 há uma constante CX que será ignorada, pois não há garantia de que a atribuição ocorrerá na execução.
 * 
 * Na linha L9 há uma constante C4
 * 
 * 
 * Portanto, haverá no total uma função de custo representada pelo custo dos laços + o custo do método split + 
 * todas as constantes que, levando em consideração que cada constante C tem um custo de tamanho 1, valerá:
 * 
 * F(N) = (N*N) * 13CL + (N*C) + 4*C
 * F(N) ~= N^2
 */
