package controller;

import javax.swing.JOptionPane;

/*Elaborado por Pedro França
 *Tabela hash utilizando lista ligada
 *Utiliza-se vetores para simular a tabela 
 */

//só receber o nome na tabela
//ordenar ela pelo nome com merge

public class tabelaHash{
		private NoHash[] tabela;
		private int tamanho;

		public tabelaHash(int tamanho_tabela) {
			tabela = new NoHash[proxPrimo(tamanho_tabela)];
			tamanho = 0;
		}

		public boolean estaVazio() {
			return tamanho == 0;
		}

		public void esvaziar() {
			int l = tabela.length;
			tabela = new NoHash[l];
			tamanho = 0;
		}

		public int verTamanho() {
			return tamanho;
		}

		public void inserir(String nome) {
			tamanho++;
			int pos = retornaHash(nome);
			NoHash inserir = new NoHash(nome);
			if (tabela[pos] == null)
				tabela[pos] = inserir;
			else {
				inserir.prox = tabela[pos];
				tabela[pos] = inserir;
			}
		}

		public void remove(String nome) {
			int pos = retornaHash(nome);
			NoHash inicio = tabela[pos];
			NoHash fim = inicio;
			if (inicio.dado == nome) {
				tamanho--;
				tabela[pos] = inicio.prox;
				return;
			}
			while (fim.prox!= null && fim.prox.dado != nome)
				fim = fim.prox;
			if (fim.prox == null) {
				System.out.println("\nNão foi encontrado o elemento\n");
				return;
			}
			tamanho--;
			if (fim.prox.prox == null) {
				fim.prox = null;
				return;
			}
			fim.prox = fim.prox.prox;
			tabela[pos] = inicio;
		}

		private int retornaHash(String nome) {
			int hash = nome.hashCode();
			hash %= tabela.length;
			if (hash < 0)
				hash += tabela.length;
			return hash;
		}

		private int proxPrimo(int n) {
			if (n % 2 == 0)
				n++;
			for (; !ePrimo(n); n += 2)
				;

			return n;
		}

		private boolean ePrimo(int n) {
			if (n == 2 || n == 3)
				return true;
			if (n == 1 || n % 2 == 0)
				return false;
			for (int i = 3; i * i <= n; i += 2)
				if (n % i == 0)
					return false;
			return true;
		}

		public void mostrarTabela() {
			String texto = "";
			for (int i = 0; i < tabela.length; i++) {
				NoHash inicio = tabela[i];
				while (inicio != null) {
					texto+=(" | " + i + " | ");
					texto+=(inicio.dado + " | \n");
					inicio = inicio.prox;
				}				
			}
			JOptionPane.showMessageDialog(null,texto);
			
		}
	}
