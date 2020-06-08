package controller;

public class Pacientes {

    String nomecompleto;
    int cpf;
    String email;

    String data;
    String hora;
    String atividade; //eh oq ele vai fazer la

    // construtor	 
    Pacientes() {
        this("", 0, "", "", "", "");
    }

    Pacientes(String nome_completo, int num_cpf, String email_pac, String data_con, String hora_con, String atividade_con) {
        nomecompleto = nome_completo;
        cpf = num_cpf;
        email = email_pac;
        data = data_con;
        hora = hora_con;
        atividade = atividade_con;

    }
}
