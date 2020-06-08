package view;

/*
Menu principal
 */
import javax.swing.JOptionPane;

import controller.*;

import java.io.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"1 - OPÇÔES DE CADASTRO/CONSULTA\n" + "2 - ENVIAR NOTIFICAÇÃO\n" + "9 - FINALIZAR"));
			if (opc != 9) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("DIGITE A QUANTIA DE PACIENTES PARA MANIPULAR"));
				Pacientes[] cadastro = new Pacientes[x];
				switch (opc) {
				case 1:
					int opc1;
					Metodo_agen agenda = new Metodo_agen();
					Metodo_apaga apaga = new Metodo_apaga();
					do {
						opc1 = Integer.parseInt(JOptionPane.showInputDialog(
								"1 - fazer cadastro\n" + "2 - fazer agendamento " + "\n3 - mostrar horarios "
										+ "\n4 - apagar um agendamento \n" + "9 - Finaliza"));
						switch (opc1) {
						case 1:
							cadastro = agenda.Cadastro(cadastro);
							break;
						case 2:
							cadastro = agenda.Consulta(cadastro);
							break;
						case 3:
							agenda.DataHora(cadastro);
							break;
						case 4:
							cadastro = apaga.Apaga_um(cadastro);
							break;
						case 9:
							JOptionPane.showMessageDialog(null, "RETORNANDO");
							break;
						default:
							JOptionPane.showMessageDialog(null, "OPC INVÁLIDA");
						}
					} while (opc1 != 9);
					break;
				case 2:
					Notificar n = new Notificar();
					int opc2;
					do {
						opc2 = Integer.parseInt(JOptionPane.showInputDialog("1 - ENVIAR MANUALMENTE\n"
								+ "2 - ENVIAR CONSULTA PARA TODOS OS CLIENTES\n" + "9 - VOLTAR"));
						switch (opc2) {
						case 1:
							Mensagem m = new Mensagem();
							m.seuEmail = JOptionPane.showInputDialog("Entre com seu email");
							m.suaSenha = JOptionPane.showInputDialog("Entre com sua senha");
							m.emailRecebe = JOptionPane.showInputDialog("Entre com o email destinatario");
							m.assunto = JOptionPane.showInputDialog("Entre com o assunto");
							m.corpo = JOptionPane.showInputDialog("Entre com o corpo do email");
							n.EnviarEmail(m);
							break;
						case 2:
							n.MassNot(cadastro);
							break;
						case 9:
							JOptionPane.showMessageDialog(null, "VOLTANDO");
							break;
						default:
							JOptionPane.showMessageDialog(null, "OPC INVALIDA");
						}
					} while (opc2 != 9);
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "FINALIZANDO");
					break;
				default:
					JOptionPane.showMessageDialog(null, "OPC Invalida");
				}
			}
		} while (opc != 9);
	}
}
