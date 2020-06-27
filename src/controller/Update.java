package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*Elaborado por Pedro França
 *Feito com o intuito de atualizar um arquivo txt já existente
 */
public class Update {
	public void criarTxt(Pacientes[] pacientes) throws IOException {
		File dir = new File(System.getProperty("user.home") + "/Desktop");
		File arq = new File(System.getProperty("user.home") + "/Desktop", "entrada.txt");
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			String conteudo = text;
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		}else {
			throw new IOException("Diretorio invalido");
		}
	}
}
