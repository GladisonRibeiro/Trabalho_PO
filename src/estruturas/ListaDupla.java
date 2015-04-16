package estruturas;

import dados.Item;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;

	public ListaDupla() {
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public NoDupla getPrim() {
		return this.prim;
	}

	public NoDupla getUlt() {
		return this.ult;
	}

	public boolean ÈVazia() {
		return (this.prim == null);
	}

	public void inserirPrimeiro(Item elem) {
		NoDupla novoNo = new NoDupla(elem);
		if (this.ÈVazia())
			this.ult = novoNo;
		else {
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
		}
		this.prim = novoNo;
		this.quantNos++;
	}

	public void inserirUltimo(Item elem) {
		NoDupla novoNo = new NoDupla(elem);
		if (this.ÈVazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	public NoDupla pesquisarNo(int chave) {
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave))
			atual = atual.getProx();
		return atual;
	}

	public boolean removerNo(int chave) {
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProx();
		}
		if (atual == null)
			return false;
		else if (atual == this.prim) {
			this.prim = prim.getProx();
			if (this.prim == this.ult)
				this.ult = null;
			else
				this.prim.setAnt(null);
		} else if (atual == this.ult) {
			this.ult = this.ult.getAnt();
			this.ult.setProx(null);
		} else {
			atual.getProx().setAnt(atual.getAnt());
			atual.getAnt().setProx(atual.getProx());
		}
		this.quantNos--;
		return true;
	}

	public String toString() {
		String msg = "";
		NoDupla atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}

	public void clearListaDupla() {
		prim = null;
		ult = null;
		quantNos = 0;
	}

	// ///MÈtodos Para o Trabalho de PO////////
	public String ordena() {
		Long inicio =  System.nanoTime();
		String tempo = " Inicio : " + System.nanoTime()+"\n";
			
		///
		NoDupla[] vetor = quicksort();
		for (int i = 0; i < vetor.length; i++) {
				tempo += vetor[i].getInfo().getChave()+"; ";
		}
		///
		Long fim = System.nanoTime();
		tempo += "Tempo : " + (fim - inicio) + " _nanoTime";
		return tempo;
	}

	// / Inicio da Ganbiarra///
	private NoDupla[] transformaVetor() {
		NoDupla[] vetor = new NoDupla[quantNos-1];
		NoDupla aux = this.prim;
		
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i] == null)
				break;
			vetor[i] = aux;
			aux = aux.getProx();
			i++;
		}
		return vetor;
	}

	private void trocaNosDupla(NoDupla a, NoDupla b) {
		NoDupla aux = new NoDupla(a.getInfo());
		aux.setAnt(a.getAnt());
		aux.setProx(a.getProx());

		a.setAnt(b.getAnt());
		a.setProx(b.getProx());

		b.setAnt(aux.getAnt());
		b.setProx(aux.getProx());
	}

	// / Fim da Ganbiarra///

	// /algoritmo da professora (+/-)
	public NoDupla[] quicksort() {
		NoDupla[] vetor = transformaVetor();
		ordena(vetor, 0, vetor.length-1);
		return vetor;
	}

	private void ordena(NoDupla[] vetor, int esq, int dir) {
		int pivo, i = esq, j = dir;
		// Item temp;
		pivo = vetor[(i + j) / 2].getInfo().getChave();
		do {

			while ( (vetor[i].getInfo().getChave() < pivo) && (i < vetor.length) && (i > -1) )// 
				i++;

			while ( (vetor[j].getInfo().getChave() > pivo) && (j < vetor.length) && (j > -1) )// 
				j--;

			if (i <= j) {
				trocaNosDupla(vetor[i], vetor[j]);
				i++;
				j--;
			}
			
		} while (i <= j);
		if (esq < j)
			ordena(vetor, esq, j);
		if (dir > i)
			ordena(vetor, i, dir);
	}
	// / fim do algoritmo da professora
}
