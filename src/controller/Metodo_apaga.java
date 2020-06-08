package controller;

import java.io.*;
import javax.swing.*;

public class Metodo_apaga {

	public Pacientes[] Apaga_um(Pacientes[] cadastro) throws IOException {

		int i;

		// le todo o bloco de notas para achar o cpf
		String fileName = "Texto_PacientesConsulta.txt";

		BufferedReader ler = new BufferedReader(new FileReader(fileName));

		for (i = 0; i < cadastro.length; i++) {
			cadastro[i] = new Pacientes();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		int apaga = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do cpf para apagar a consulta:"));

		i = 0;
		String lido;
		while ((lido = ler.readLine()) != null || i < cadastro.length) {
			cadastro[i].nomecompleto = lido;
			cadastro[i].cpf = Integer.parseInt(lido);
			cadastro[i].email = lido;
			cadastro[i].data = lido;
			cadastro[i].hora = lido;
			cadastro[i].atividade = lido;
			if (cadastro[i].cpf != apaga) {
				writer.write(cadastro[i].nomecompleto);
				writer.write(String.valueOf(cadastro[i].cpf));
				writer.write(cadastro[i].email);
				writer.write(cadastro[i].data);
				writer.write(cadastro[i].hora);
				writer.write(cadastro[i].atividade);
			} else {
				Notificar n = new Notificar();
				Mensagem m = new Mensagem();
				m.emailRecebe = cadastro[i].email;
				m.assunto = "SUA CONSULTA";
				m.corpo = "SUA CONSULTA SOBRE: " + cadastro[i].atividade + " DO DIA " + cadastro[i].data
						+ " FOI CANCELADA";
				m.seuEmail = JOptionPane.showInputDialog("DIGITE SEU EMAIL");
				m.suaSenha = JOptionPane.showInputDialog("DIGITE SUA SENHA");
				n.EnviarEmail(m);
			}
			i++;
		}
		ler.close();

		writer.close();
		return cadastro;

	}

}
