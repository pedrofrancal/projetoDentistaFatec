package controller;

/*Elaborado por Raizer Varela
 *Para utilizar chamar quickSort(vet, 0, vet.length-1)
 */

public class QuickSort {
	public static void quickSort(int[] vet, int esq, int dir) {
		if(esq < dir) { // até onde a recurssividade vai
			int j = separa(vet, esq, dir); // aqui é onde sera feita a separaçao do pivo, jogando os menores para esquerda e os maiores para direita
			quickSort(vet, esq, j-1); // chamada recurssiva passando da esquerda ate o j-
			quickSort(vet, j+1, dir);
		}
	}

	private static int separa(int[] vet, int esq, int dir) {
		int i = esq+1;
		int j = dir;
		int pivo = vet[esq];
		
		while(i <= j) {
			if(vet[i] <= pivo) i++;
			else if(vet[j] > pivo) j--;
			else if(i <= j) {
				troca(vet, i, j);
				i++;
				j--;
			}
		}
		troca(vet, esq, j);
		return j;
	}

	private static void troca(int[] vet, int i, int j) {
		int aux = vet[i];
		vet[i] = vet[j];
		vet[j] = aux;
	}
}
