package view;

import controller.tabelaHash;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


				// TODO Auto-generated method stub
				tabelaHash h = new tabelaHash(1);
//				tabelaHash hash = new tabelaHash(10);
				h.inserir("pedro");
				h.inserir("teste");
				h.inserir("pedro");
				System.out.println(h.estaVazio());

	}

}
