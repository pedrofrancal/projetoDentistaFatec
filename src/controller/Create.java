package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*Elaborado por Pedro França
 *Com o proposito de salvar o arquivo em entrada.txt
 */

public class Create {
	/*
	 * Estrutura do txt Separaremos com ; e então na leitura/criação saberemos o que
	 * carregar na classe paciente nome; telefone; email; rg
	 */

	// Já incluido do create existe a possibilidade de atualizar o arquivo sem
	// perdas
	public void gravarTxt(Pacientes[] paciente) throws IOException {
		File arq = new File(System.getProperty("user.home") + "/Desktop", "entrada.txt");
		File dir = new File(System.getProperty("user.home") + "/Desktop");
		StringBuffer buffer = new StringBuffer();

		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			for (Pacientes p : paciente) {
				buffer.append(p.getNomecompleto() + ";");
//				buffer.append(p.getTelefone()+";");
				buffer.append(p.getEmail() + ";");
				buffer.append(p.getRg());
				buffer.append("\n");
			}
			String conteudo = buffer.toString();
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
