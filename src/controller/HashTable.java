package controller;

//fiz utilizando a array list do java
//vai ter detecção de colisão
import java.util.ArrayList;

/*Elaborado por Pedro França
 *Tentativa de gerar uma tabela hash do 0
 */

//Mapear<String, Integer>mapear = new Mapear<>();
//mapear.add(oque, valor)


public class HashTable {
	//<> significa que o que está dentro pode ser de qualquer tipo
	private class NoHash<chave, valor>{
		chave chave;
		valor valor;
		
		//preparando para saber quem é o proximo
		NoHash<chave, valor> proximo;
		
		public NoHash(chave c, valor v) {
			this.chave = c;
			this.valor = v;
		}
	}
	
	//representar a tabela hash
	public class Mapear<chave, valor>{
		//vetor para salvar os encadeamentos
		private ArrayList<NoHash<chave, valor>> guardar;
		
		//saber quanto foi guardado
		private int numeroGuardado;
		
		//tamanho do vetor
		private int tamanho;
		
		public Mapear() {
			guardar = new ArrayList<>();
			numeroGuardado = 10;
			tamanho = 0;
			
			//limpar
			for(int i =0; i<numeroGuardado; i++) {
				guardar.add(null);
			}
		}
		
		public int tamanho() {
			return tamanho;
		}
		
		public boolean estaVazio() {
			//retorna verdadeiro se o tamanho for 0
			return tamanho()==0;
		}
		
		//implementar a função hash para achar posição e chave
		private int acharPos(chave c) {
			int hashCode = c.hashCode();
			int pos = hashCode % numeroGuardado;
			return pos;
		}
		
		//remover certa chave se necessario
		public valor remover(chave c) {
			//usar a função hash para achar a posição
			int pos = acharPos(c);
			//achar inicio do encadeamento
			NoHash<chave, valor> inicio = guardar.get(pos);
			//agora que achamos procuramos a chave
			NoHash<chave, valor> anterior = null;
			while(inicio != null) {
				//se achou
				if(inicio.chave.equals(c)) {
					break;
				}
				anterior = inicio;
				inicio = inicio.proximo;
			}
			//caso não exista a chave
			if(inicio == null) {
				return null;
			}
			tamanho--;
			//agora removemos
			if(anterior != null) {
				anterior.proximo = inicio.proximo;
			}else {
				guardar.set(pos, inicio.proximo);
			}
			return inicio.valor;
		}
		
		public valor pegar(chave c) {
			//achar o começo
			int pos = acharPos(c);
			NoHash<chave, valor> inicio = guardar.get(pos);
			
			//procurar chave
			while(inicio!=null) {
				if(inicio.chave.equals(c)) {
					return inicio.valor;
				}
				inicio = inicio.proximo;
			}
			//se não achou
			return null;
		}
		
		//adicionar um par
		public void adicionar(chave c, valor v) {
			//achar novamente o inicio
			int pos = acharPos(c);
			NoHash<chave, valor> inicio = guardar.get(pos);
			
			//ver se a chave está presente
			while(inicio != null) {
				if(inicio.chave.equals(c)) {
					inicio.valor = v;
					return;
				}
				inicio = inicio.proximo;
			}
			
			//inserir chave
			tamanho++;
			inicio = guardar.get(pos);
			NoHash<chave, valor> novoNo = new NoHash<chave, valor>(c, v);
			novoNo.proximo = inicio;
			guardar.set(pos, novoNo);
			
			//dobrar hash caso não tenha espaço
			if((1.0*tamanho)/numeroGuardado >= 0.7) {
				ArrayList<NoHash<chave, valor>> temporaria = guardar;
				guardar = new ArrayList<>();
				numeroGuardado*=2;
				tamanho = 0;
				for(int i = 0; i<numeroGuardado; i++) {
					guardar.add(null);
				}
				for(NoHash<chave, valor> no : temporaria) {
					while(no != null) {
						adicionar(no.chave, no.valor);
						no = no.proximo;
					}
				}
			}
		}
	}
}
