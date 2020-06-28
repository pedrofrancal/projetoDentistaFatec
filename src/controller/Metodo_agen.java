package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Metodo_agen {

    public Pacientes[] Cadastro(Pacientes[] cadastro) throws IOException {

        int i;
        String fileName = "Texto_Pacientes.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (i = 0; i < cadastro.length; i++) {
            cadastro[i] = new Pacientes();
        }

        for (i = 0; i < cadastro.length; i++) {
            cadastro[i].nomecompleto = JOptionPane.showInputDialog("Entre com o nome do paciente:");
            writer.write(cadastro[i].nomecompleto);
            writer.newLine();

            cadastro[i].cpf = Integer.parseInt(JOptionPane.showInputDialog("Entre com o cpf:"));
            writer.write(Integer.toString(cadastro[i].cpf));
            writer.newLine();

            cadastro[i].email = JOptionPane.showInputDialog("Entre com o email:");
            writer.write(cadastro[i].email);
            writer.newLine();

            cadastro[i].data = "VAZIO";
            writer.write(cadastro[i].data);
            writer.newLine();

            cadastro[i].hora = "VAZIO";
            writer.write(cadastro[i].hora);
            writer.newLine();

            cadastro[i].atividade = "VAZIO";
            writer.write(cadastro[i].atividade);
            writer.newLine();

            System.out.println("Cadastro realizado ");

        }

        writer.close();

        return cadastro;

    }

    //---------------- agendamento -----------------------
    public Pacientes[] Consulta(Pacientes[] cadastro) throws IOException {

        int i;

        //le todo o bloco de notas para achar o cpf
        String fileName = "Texto_PacientesConsulta.txt";

        BufferedReader ler = new BufferedReader(new FileReader(fileName));

        for (i = 0; i < cadastro.length; i++) {
            cadastro[i] = new Pacientes();
        }

        for (i = 0; i < cadastro.length; i++) {
            cadastro[i].nomecompleto = ler.readLine();
            cadastro[i].cpf = Integer.parseInt(ler.readLine());
            cadastro[i].email = ler.readLine();
            cadastro[i].data = ler.readLine();
            cadastro[i].hora = ler.readLine();
            cadastro[i].atividade = ler.readLine();
        }

        ler.close();

        int numero_cpf;
        numero_cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do cpf:"));

        //add a consulta no cpf
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        //reescreve para o txt
        for (i = 0; i < cadastro.length; i++) {
            if (cadastro[i].cpf == numero_cpf) {
                writer.write(cadastro[i].nomecompleto);
                writer.newLine();

                writer.write(Integer.toString(cadastro[i].cpf));
                writer.newLine();

                writer.write(cadastro[i].email);
                writer.newLine();

                cadastro[i].data = JOptionPane.showInputDialog("Entre com a data (dd/mm/aaaa");
                writer.write(cadastro[i].data);
                writer.newLine();

                cadastro[i].hora = JOptionPane.showInputDialog("Entre com a data (hh/mm");
                writer.write(cadastro[i].hora);
                writer.newLine();

                cadastro[i].atividade = JOptionPane.showInputDialog("Entre com a descricao da consulta:");
                writer.write(cadastro[i].atividade);
                writer.newLine();
            } else {
                writer.write(cadastro[i].nomecompleto);
                writer.newLine();

                writer.write(Integer.toString(cadastro[i].cpf));
                writer.newLine();

                writer.write(cadastro[i].email);
                writer.newLine();

                writer.write(cadastro[i].data);
                writer.newLine();

                writer.write(cadastro[i].hora);
                writer.newLine();

                writer.write(cadastro[i].atividade);
                writer.newLine();

            }

        }

        writer.close();

        return cadastro;

    }

    //---------------- mostrar ----------------------------
    public void DataHora(Pacientes[] cadastro) {
        for (int i = 0; i < cadastro.length; i++) {
            System.out.println("O PACIENTE " + cadastro[i].nomecompleto + " TERÁ UMA CONSULTA DE "
                    + cadastro[i].atividade + "NO DIA " + cadastro[i].data + " ÀS " + cadastro[i].hora + " HORAS");
        }
    }

}
