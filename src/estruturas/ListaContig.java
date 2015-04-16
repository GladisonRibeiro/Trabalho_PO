package estruturas;

import dados.*;

public class ListaContig {
	private int fim;
	private Item[] info; // o tipo Item est· declarado no capÌtulo 1

	public ListaContig(int qte) {
		this.fim = 0;
		this.info = new Item[qte];
	}

	public Item getInfo(int i) {
		return this.info[i];
	}

	public void setInfo(int i, Item elem) {
		this.info[i] = elem;
	}

	public int getFim() {
		return this.fim;
	}

	public void setFim(int _fim) {
		this.fim = _fim;
	}

	public boolean ÈVazia() {
		return (this.fim == 0);
	}

	public boolean ÈCheia() {
		return (this.fim == this.info.length);
	}

	public boolean inserirUltimo(Item elem) {
		if (ÈCheia()) {
			return false;
		} else {
			this.info[this.fim] = elem;
			this.fim++;
			return true;
		}
	}

	public int pesquisarNo(int chave) {
		int i = 0;
		while ((i < this.fim) && (this.info[i].getChave() != chave)) {
			i++;
		}
		return i;
	}

	public boolean removerNo(int chave) {
		int i = 0;
		int j;
		while ((i < this.fim) && (this.info[i].getChave() != chave)) {
			i++;
		}
		if (i == this.fim) {
			return false;
		} else {
			for (j = i; j < this.fim - 1; j++) {
				this.info[j] = this.info[j + 1];
			}
			this.fim--;
			return true;
		}
	}

	public String toString() {
		String msg = "";
		int i;
		for (i = 0; i < this.fim; i++) {
			msg += this.info[i].getChave() + "\n";
		}
		return msg;
	}

	// exercÌcio 01 n∫10
	public ListaContig removerMaior100() {
		if (this.ÈVazia()) {
			return null;
		} else {
			int i = 0;
			ListaContig nova = new ListaContig(this.fim);
			while (i < this.fim) {
				if (this.info[i].getChave() > 100) {
					nova.inserirUltimo(this.info[i]);
					for (int j = i; j < this.fim - 1; j++) {
						this.info[j] = this.info[j + 1];
					}
					this.fim--;
				} else {
					i++;
				}
			}
			return nova;
		}
	}

	// exercÌcio 01 n∫10
	public void eliminarRepetidos(int x) {
		if (!this.ÈVazia()) {
			int i = 0;
			while ((i < this.fim) && (this.info[i].getChave() != x)) {
				i++;
			}
			if (i != this.fim) {
				i++;
				while (i < this.fim) {
					if (this.info[i].getChave() == x) {
						for (int j = i; j < this.fim - 1; j++) {
							this.info[j] = this.info[j + 1];
						}
						this.fim--;
					} else {
						i++;
					}
				}
			}
		}
	}

	// Inicio Gambiarra
	
	public void zeraLista(){
		this.fim = 0;
	}

	// Fim da Gambiarra

	// Inicio codigo da professora//
	public Item[] quicksort() {
		ordena(0, fim - 1);
		return info;
	}

	private void ordena(int esq, int dir) {
		int pivo, i = esq, j = dir;
		Item temp;
		pivo = info[(i + j) / 2].getChave();
		do {

			while ((info[i].getChave() < pivo) && (i < info.length) && (i > -1))
				i++;

			while ((info[j].getChave() > pivo) && (j < info.length) && (j > -1))
				j--;

			if (i <= j) {
				temp = this.info[i];
				this.info[i] = this.info[j];
				this.info[j] = temp;
				i++;
				j--;
			}

		} while (i <= j);
		if (esq < j)
			ordena(esq, j);
		if (dir > i)
			ordena(i, dir);
	}
	// / fim do algoritmo da professora

}// fim bloco principal

