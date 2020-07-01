package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*Elaborado por Pedro França
 *MergeSort usando um vetor de Strings
 *Como chamar: mergeSort(vetor, começo, fim)
 */

public class MergeSort {

	public void mergeSort(String[] vetor, int inicio, int fim) {
		if (inicio == fim) {
			return;
		}
		int meio = (inicio + fim) / 2;
		// arrumar o primeiro e o meio
		mergeSort(vetor, inicio, meio);
		mergeSort(vetor, meio + 1, fim);
		merge(vetor, inicio, meio, fim);
	}

	private void merge(String[] vetor, int inicio, int meio, int fim) {
		/*
		 * Primeiro vemos o tamanho total para juntar Juntamos todas as metades num
		 * vetor temporario Depois pegamos os dois proximos elementos e achamos a
		 * proxima posição com espaço
		 */
		int n = fim - inicio + 1;
		String[] temp = new String[n];
		int i1 = inicio;
		int i2 = meio + 1;
		int j = 0;

		// desde que nenhum i passe do fim, começa a mexer os pequenos dentro de b
		while (i1 <= meio && i2 <= fim) {
				String nome1, nome2;
				String[] vetTemp;
				vetTemp = vetor[i1].split(";");
				nome1 = vetTemp[0];

				vetTemp = vetor[i2].split(";");
				nome2 = vetTemp[0];
				if (nome1.compareTo(nome2) < 0) {
					temp[j] = vetor[i1];
					i1++;
				} else {
					temp[j] = vetor[i2];
					i2++;
				}
				j++;
		}
		// copiando qualquer coisa que falte da primeira metade
		while (i1 <= meio) {
			temp[j] = vetor[i1];
			i1++;
			j++;
		}

		// copiando qualquer coisa que falte da segunda metade
		while (i2 <= fim) {
			temp[j] = vetor[i2];
			i2++;
			j++;
		}

		// salvar as coisas no vetor principal
		for (j = 0; j < n; j++) {
			vetor[inicio + j] = temp[j];
		}
	}

	public void gravar(String[] vet) throws IOException {
		File arq = new File("C:\\Project\\mergesort.txt");
		File dir = new File("C:\\Project");

		StringBuffer buffer = new StringBuffer();

		for (String s : vet) {
			buffer.append(s);
			buffer.append("\n");
		}

		if (!dir.exists()) {
			dir.mkdir();
		}

		if (dir.exists() && dir.isDirectory()) {
			String conteudo = buffer.toString();
			FileWriter fileWriter = new FileWriter(arq);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretorio invalido");
		}
	}

}