package controller;

/*
 * Elaborado por Pedro França
 *Caso for preciso usar o heap para ordenar palavras
 */

public class HeapSortLetras {
	// usar para achar a posição do heap
	private static int pos = -1;

	// predefinir o tamanho do heap
	private static String[] heap = new String[40];

	private static void criarHeap(String palavra) {
		pos++;
		heap[pos] = palavra;
		int comparar = pos;

		String temporaria;

		int i = pos / 2;

		while (i >= 0) {
			// vai trocar se for menor que o guardado
			// compareTo compara as strings por exemplo
			// ab2 vem antes que ab3 e que ac3, então retorna -1
			// retorna negativo se a string vem primeiro
			if (heap[i].compareTo(heap[comparar]) > 0) {
				temporaria = heap[i];
				heap[i] = heap[comparar];
				heap[comparar] = temporaria;
				comparar = i;

				// continuar o heap
				i = i / 2;
			} else {
				break;
			}
		}
	}

	private static void ordenaHeap() {
		int esquerda;
		int direita;

		while (pos >= 0) {
			String temporaria;
			// pegando o primeiro elemento
			temporaria = heap[0];
			
			//só funciona se eu printo aqui
			System.out.print(temporaria + " "); 
			// colocando em ultimo
			heap[0] = heap[pos];

			pos--;

			int i = 0;
			int tamanho = pos;
			// iniciar a esquerda e direita
			esquerda = 1;
			direita = esquerda + 1;

			while (esquerda <= tamanho) {
				// verificar tamanhos e então trocar
				if (heap[i].compareTo(heap[esquerda]) <= 0 && heap[i].compareTo(heap[direita]) <= 0) {
					break;
				} else {
					if (heap[esquerda].compareTo(heap[direita]) < 0) {
						temporaria = heap[i];
						heap[i] = heap[esquerda];
						heap[esquerda] = temporaria;
						i = esquerda;
					} else {
						temporaria = heap[i];
						heap[i] = heap[direita];
						heap[direita] = temporaria;
						i = direita;
					}
				}
				// trocar esquerda e direita
				esquerda = 2 * esquerda;
				direita = esquerda + 1;
			}
		}
	}
	
	public static void ordenar(String palavras[], int tamanho) {
		//gerar heap
		
		
		for(int i = 0; i<tamanho; i++) {
			criarHeap(palavras[i]);
		}
		ordenaHeap();
	}
}
