package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogDesempenho {
	
	private double tempoInicial;
	private double tempoFinal;

	public void setTempoInicial(double tempoInicial) {
		this.tempoInicial = tempoInicial;
	}


	public void setTempoFinal(double tempoFinal) {
		this.tempoFinal = tempoFinal;
	}



	public void gerarLog(String nomeClasse) throws IOException {
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal/=Math.pow(10, 9);
		File arq = new File(System.getProperty("user.home") + "/Desktop", "log.txt");
		File dir = new File(System.getProperty("user.home") + "/Desktop");
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = nomeClasse + " levou "+tempoTotal+" segundos para executar\n";
			FileWriter fileWriter = new FileWriter(arq, existe);
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
