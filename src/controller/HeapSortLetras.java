package controller;

/*Elaborado por Pedro França
 *Utilizando o compareTo para ordenar Strings
 */
public class HeapSortLetras {
	public static void HeapSort(String[] v) {
		constroiMaximaOrdem(v);
		int n = v.length;

		for (int i = v.length - 1; i > 0; i--) {
			swap(v, i, 0);
			ordenaDescendo(v, 0, --n);
		}
	}

	private static void constroiMaximaOrdem(String[] v) {
		for (int i = v.length / 2 - 1; i >= 0; i--)
			ordenaDescendo(v, i, v.length);
	}

	private static void ordenaDescendo(String[] vetor, int pos, int tamanhoDoVetor) {
		// obtém as posições dos filhos
		int max = 2 * pos + 1, right = max + 1;
		if (max < tamanhoDoVetor) {
			// verifica qual dos dois filhos possuem o maior valor
			if ((right < tamanhoDoVetor) && (vetor[max].compareTo(vetor[right])) < 0)
				max = right;
			// verifica se o filho com o mair valor tem um valor maior que o pai
			if (vetor[max].compareTo(vetor[pos]) > 0) {
				swap(vetor, max, pos);
				ordenaDescendo(vetor, max, tamanhoDoVetor);
			}
		}
	}

	// faz a troca de dos valores
	public static void swap(String[] v, int j, int aposJ) {
		String aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
	}
}