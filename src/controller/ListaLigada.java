package controller;

/*Elaborado por Pedro França
 *Classe para implementação de uma lista ligada
 */

public class ListaLigada{
	private static int contador;
	private No inicio;
	
	//construtor
	public ListaLigada(){
		super();
	}
	
	//adicionar o elemento especificado para o fim da lista
	public void adicionar(Pacientes item) {
		//se vazio, temos que adicionar onde se inicia a lista
		if(inicio == null) {
			inicio = new No(item);
		}
		
		No temporario = new No(item);
		No agora = inicio;
		
		if(agora != null) {
			//começar um loop pelo inicio, achar o fim da lsita e adicionar
			while(agora.getNext()!=null) {
				agora = agora.getNext();
			}
			
			//adicionando o ultimo "proximo" para nosso no
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
		
		if(agora.getNext()!=null) {
			//para simplificação, adicionamos para a posição desejada ou o ultimo lugar
			//ele para no primeiro das duas situações
			for(int i = 0; i<pos && agora.getNext()!=null; i++) {
				agora = agora.getNext();
			}
		}
		
		//arrumar qual é o proximo real
		temporario.setNext(agora.getNext());
		//e agora arrumar o atual
		agora.setNext(temporario);
		
		aumentarQuantia();
	}
	
	public Pacientes get(int pos) {
		//retornar a posição exata
		//para isso temos que validar se a pos é >0
		if(pos < 0) {
			return null;
		}
		No agora = null;
		if(inicio != null) {
			agora = inicio.getNext();
			for(int i = 0; i < pos; i++) {
				if(agora.getNext() == null) {
					return null;
				}
				agora = agora.getNext();
			}
			return agora.getDado();
		}
		//na teoria esse return não vai ser utilizado, mas estava dando erro
		return agora.getDado();
	}
	
	//verifica pelo nome do paciente e retorna a posição
	//pode causar falhas com nomes iguais
	public int remover(String nome) {
		No agora = inicio;
		int pos=0;
		
		if(inicio != null) {
			while(agora.getDado().getNomecompleto()!=nome||agora.getNext()==null) {
				agora = agora.getNext();
				pos++;
			}
		}
		
		return pos;
	}
	
	public boolean remover(int pos) {
		//aqui vemos se é maior que a contagem
		//vamos usar verdadeiro e falso pra ver se foi possivel deletar
		if (pos < 1 || pos > tamanho()) {
			return false;
		}
		
		No agora = inicio;
		if(inicio != null) {
			for(int i = 0; i<pos; i++) {
				if(agora.getNext() == null) {
					return false;
				}
				agora = agora.getNext();
			}
			agora.setNext(agora.getNext().getNext());
		}
		//agora que voltamos 1 do fim temos que tirar do contador
		diminuirQuantia();
		return true;
	}
	
	public int tamanho() {
		return verQuantia();
	}
	
	public String toString() {
		//aqui provavelmente não vamos usar, mas quero uma forma de imprimir a lista em texto
		//então vou fazer dentro da lista uma forma de imprimir ela mais simples
		String saida = "";
		
		if(inicio != null) {
			No agora = inicio.getNext();
			while(agora!=null) {
				saida+="["+agora.getDado().toString()+"]";
				agora = agora.getNext();
			}
		}
		return saida;
		//podemos usar o split para ler os dados;
	}

	private class No{
		//ver quem é o proximo na lista
		No proximo;
		
		//o proximo a ser adicionado, poderia ser um Object, mas para simplificação do trabalho
		//escolhi ser a classe Pacientes
		Pacientes dado;
		
		//construtor
		@SuppressWarnings("unused")
		public No(Pacientes dadoAdicionar) {
			proximo = null;
			dado = dadoAdicionar;
		}
		
		//outro no para especificarmos o que apontar se necessario
		//o supresswarnings é só para não aparecer erros por não ser utilizado
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
		
		public No getNext(){
			return proximo;
		}
		
		public void setNext(No proximoValor) {
			proximo = proximoValor;
		}
		
	}
}