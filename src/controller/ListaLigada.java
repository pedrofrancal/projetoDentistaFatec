package controller;

/*Elaborado por Pedro Fran�a
 *Classe para implementa��o de uma lista ligada
 */

public class ListaLigada {
	private static int contador;
	private No inicio;

	// construtor
	public ListaLigada() {
		this.inicio = null;
	}

	// adicionar o elemento especificado para o fim da lista
	public void adicionar(Pacientes item) {
		// se vazio, temos que adicionar onde se inicia a lista
		if (inicio == null) {
			inicio = new No(item);
		}

		No temporario = new No(item);
		No agora = inicio;

		if (agora != null) {
			// come�ar um loop pelo inicio, achar o fim da lista e adicionar
			while (agora.getNext() != null) {
				agora = agora.getNext();
			}

			// adicionando o ultimo "proximo" para nosso no
			agora.setNext(temporario);
		}
		aumentarQuantia();
	}

	private void aumentarQuantia() {
		contador++;
	}

	private static int verQuantia() {
		return contador;
	}

	private void diminuirQuantia() {
		contador--;
	}

	public void adicionar(Pacientes item, int pos) {
		No temporario = new No(item);
		No agora = inicio;

		if (agora.getNext() != null) {
			// para simplifica��o, adicionamos para a posi��o desejada ou o ultimo lugar
			// ele para no primeiro das duas situa��es
			for (int i = 0; i < pos && agora.getNext() != null; i++) {
				agora = agora.getNext();
			}
		}

		// arrumar qual � o proximo real
		temporario.setNext(agora.getNext());
		// e agora arrumar o atual
		agora.setNext(temporario);
		aumentarQuantia();
		ordenar();
	}

	public Pacientes get(int pos) {
		
		// retornar a posi��o exata
		// para isso temos que validar se a pos � >0
		if (pos < 0) {
			return null;
		}
		No agora = null;
		if (inicio != null) {
			agora = inicio;
			for (int i = 0; i < pos; i++) {
				if (agora.getNext() == null) {
					return null;
				}
				agora = agora.getNext();
			}
			return agora.getDado();
		}
		// na teoria esse return n�o vai ser utilizado, mas estava dando erro
		return null;
	}

	// verifica pelo nome do paciente e retorna a posi��o
	// pode causar falhas com nomes iguais
	public Pacientes procurar(String nome) {
		No agora = inicio;
		if (inicio != null) {
			while (agora.getDado().getNomecompleto() != nome || agora.getNext() == null) {
				agora = agora.getNext();

			}
		}

		return agora.getDado();
	}

	public void ordenar() {
		quickSort(0, verQuantia());
	}

	// quickSort recursivo
	private void quickSort(int inicio, int fim) {
		if (inicio < fim) {
			int pivo = particionar(inicio, fim);
			quickSort(inicio, pivo - 1);
			quickSort(pivo + 1, fim);
		}
	}

	// quebrar em parti��es para pesquisar
	private int particionar(int inicio, int fim) {
		int i = inicio;
		for (int j = inicio; j < fim; j++) {
			if (achar(j).getDado().getNomecompleto().compareTo(achar(fim).getDado().getNomecompleto()) < 0) {
				trocar(i + 1, j);
			}

		}
		trocar(i, fim);
		return i;
	}

	// usar auxiliares para trocar posi��o
	private void trocar(int i, int j) {
		No auxi = achar(i);
		Pacientes pacientei = auxi.getDado();
		No auxj = achar(j);
		Pacientes pacientej = auxj.getDado();
		auxj.setDado(pacientej);
		auxi.setDado(pacientei);
	}

	// passa por todas as posi��es em busca do numero na lista
	private No achar(int pos) {
		No aux = this.inicio;
		int i = 0;
		do {
			aux = aux.getNext();
			i++;
		}while(i<pos);
		return aux;
	}

	public void remover(String nome) {
		No agora = this.inicio;
		if (inicio.getNext() == null) {
			inicio = null;
		}
		if (inicio != null) {
			if (agora.getDado().getNomecompleto().equals(nome)) {
				inicio = inicio.getNext().getNext();
			} else {
				while (!agora.getNext().getDado().getNomecompleto().equals(nome)) {
					agora = agora.getNext();
				}
				agora.setNext(agora.getNext().getNext());
			}

		}
		// agora que voltamos 1 do fim temos que tirar do contador
		diminuirQuantia();
		ordenar();
	}

	public int tamanho() {
		return verQuantia();
	}

	@Override
	public String toString() {
		// aqui provavelmente n�o vamos usar, mas quero uma forma de imprimir a lista em
		// texto
		// ent�o vou fazer dentro da lista uma forma de imprimir ela mais simples
		String saida = "";

		if (inicio != null) {
			No agora = inicio.getNext();
			while (agora != null) {
				saida += "[" + agora.getDado().toString() + "]";
				agora = agora.getNext();
			}
		}
		return saida;
		// podemos usar o split para ler os dados;
	}

	private class No {
		// ver quem � o proximo na lista
		No proximo;

		// o proximo a ser adicionado, poderia ser um Object, mas para simplifica��o do
		// trabalho
		// escolhi ser a classe Pacientes
		Pacientes dado;

		// construtor
		public No(Pacientes dadoAdicionar) {
			proximo = null;
			dado = dadoAdicionar;
		}

		// outro no para especificarmos o que apontar se necessario
		// o supresswarnings � s� para n�o aparecer erros por n�o ser utilizado
		@SuppressWarnings("unused")
		public No(Pacientes dadoAdicionar, No proximoDado) {
			proximo = proximoDado;
			dado = dadoAdicionar;
		}

		public Pacientes getDado() {
			return dado;
		}

		public void setDado(Pacientes dadoAdicionar) {
			dado = dadoAdicionar;
		}

		public No getNext() {
			return proximo;
		}

		public void setNext(No proximoValor) {
			proximo = proximoValor;
		}

	}
}