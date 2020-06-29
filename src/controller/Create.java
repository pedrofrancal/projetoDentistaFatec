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
	 * carregar na classe paciente nome; telefone; email; rg; data; tipo de consulta poderiamos até salvar
	 * como csv, mas para ficarmos dentro da proposta do trabalho utilizaremos o txt
	 */

	// Já incluido do create existe a possibilidade de atualizar o arquivo sem
	// perdas
	public void gravar(Pacientes[] paciente) throws IOException {
		StringBuffer buffer = new StringBuffer();

		for (Pacientes p : paciente) {
			buffer.append(p.getNomecompleto() + ";");
			buffer.append(p.getTelefone()+";");
			buffer.append(p.getEmail() + ";");
			buffer.append(p.getRg());
			buffer.append(p.getDataAgenda());
			buffer.append(p.getTipoDeAgendamento())
			buffer.append("\n");
		}
		
		atualizarTxt(buffer);

	}

	public void gravar(Pacientes paciente) throws IOException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(paciente.getNomecompleto() + ";");
		buffer.append(paciente.getTelefone()+";");
		buffer.append(paciente.getEmail() + ";");
		buffer.append(paciente.getRg());
		buffer.append(p.getDataAgenda());
		buffer.append(p.getTipoDeAgendamento())
		buffer.append("\n");
		
		atualizarTxt(buffer);
	}

	private void atualizarTxt(StringBuffer buffer) throws IOException{
		File arq = new File(System.getProperty("user.home") + "/Desktop", "entrada.txt");
		File dir = new File(System.getProperty("user.home") + "/Desktop");
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
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
