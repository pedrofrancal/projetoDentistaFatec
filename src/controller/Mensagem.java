package controller;

public class Mensagem {
	public String seuEmail;
	public String suaSenha;
	public String emailRecebe;
	public String assunto;
	public String corpo;

	public Mensagem() {
		this("", "", "", "", "");
	}

	Mensagem(String sE, String sS, String eR, String a, String c) {
		seuEmail = sE;
		suaSenha = sS;
		emailRecebe = eR;
		assunto = a;
		corpo = c;
	}
}
