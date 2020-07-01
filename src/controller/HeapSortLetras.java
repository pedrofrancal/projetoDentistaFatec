package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*Elaborado por Pedro França
 *Utilizando o compareTo para ordenar Strings
 */
public class HeapSortLetras {
	public void HeapSort(String[] v) {
		constroiMaximaOrdem(v);
		int n = v.length;

		for (int i = v.length - 1; i > 0; i--) {
			swap(v, i, 0);
			ordenaDescendo(v, 0, --n);
		}
	}

	private void constroiMaximaOrdem(String[] v) {
		for (int i = v.length / 2 - 1; i >= 0; i--)
			ordenaDescendo(v, i, v.length);
	}

	private void ordenaDescendo(String[] vetor, int pos, int tamanhoDoVetor) {
		// obtém as posições dos filhos
		int max = 2 * pos + 1, right = max + 1;
		if (max < tamanhoDoVetor) {
			String data1, data2;
			String[] vetTemp;
			vetTemp=vetor[max].split(";");
			data1 = vetTemp[5];
			vetTemp=vetor[right].split(";");
			data2 = vetTemp[5];
			
			System.out.println(data1+","+data2);
			// verifica qual dos dois filhos possuem o maior valor
			if ((right < tamanhoDoVetor) && (data1.compareTo(data2)) < 0)
				max = right;
			// verifica se o filho com o mair valor tem um valor maior que o pai
			if (data1.compareTo(data2) > 0) {
				swap(vetor, max, pos);
				ordenaDescendo(vetor, max, tamanhoDoVetor);
			}
		}
	}

	// faz a troca de dos valores
	private void swap(String[] v, int j, int aposJ) {
		String aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
	}
	
	public void gravar(String[] vet) throws IOException {
    	File arq = new File("C:\\Project\\heapsort.txt");
		File dir = new File("C:\\Project");
		
		StringBuffer buffer = new StringBuffer();
		
		for(String s : vet) {
			buffer.append(s);
			buffer.append("\n");
		}
		
		if(!dir.exists()) {
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