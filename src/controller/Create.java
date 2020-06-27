package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*Elaborado por Pedro França
 *Com o proposito de salvar o arquivo em entrada.txt
 */

public class Create {
	/*Estrutura do txt
	 *Separaremos com ; e então na leitura/criação saberemos
	 *o que carregar na classe paciente
	 *nome; telefone; email; rg
	 */
	public void gravarTxt(Pacientes[] paciente) {
		File arq = new File(System.getProperty("user.home") + "/Desktop", "entrada.txt");
		StringBuffer buffer = new StringBuffer();
		for(Pacientes p : paciente) {
			buffer.append(p.getNomecompleto()+";");
			buffer.append(p.getTelefone()+";");
			buffer.append(p.getEmail()+";");
			buffer.append(p.getRg());
			buffer.append("\n");
		}
	}
}
