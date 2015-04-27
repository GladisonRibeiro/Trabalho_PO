package estruturas;

import dados.Item;
import dados.Registro;

public class ListaContig {
	private int fim;
	// private Item[] info;
	private Registro[] info;

	public ListaContig(int qte) {
		this.fim = 0;
		this.info = new Registro[qte];
	}

	public Item getInfo(int i) {
		return this.info[i];
	}

	public void setInfo(int i, Item elem) {
		this.info[i] = (Registro) elem;
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
			this.info[this.fim] = (Registro) elem;
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
			msg += this.info[i].toString() + "\n";
		}
		return msg;
	}
	public String[] toArrayString() {
		String[] msg = new String[this.fim];
		int i;
		for (i = 0; i < this.fim; i++) {
			msg[i] = this.info[i].toString();
		}
		return msg;
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

	public void zeraLista() {
		this.fim = 0;
	}

	// Inicio codigo da professora utilizando chave//
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
				this.info[j] = (Registro) temp;
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

	// Inicio do meu codigo utilizando cpf//
	public void quicksortRegistro() {
		ordenaRegistro(0, fim - 1);
	}

	private void ordenaRegistro(int esq, int dir) {
		int i = esq, j = dir;
		Registro pivo;
		Registro temp;
		pivo = info[(i + j) / 2];
		do {
			while (info[i].getCpf() < pivo.getCpf())
				//
				i++;

			while (info[j].getCpf() > pivo.getCpf())
				//
				j--;

			if (i <= j) {
				temp = this.info[i];
				this.info[i] = this.info[j];
				this.info[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j) {
			ordenaRegistro(esq, j);
		}
		if (dir > i) {
			ordenaRegistro(i, dir);
		}
	}
	
	// / fim do meu cÛdigo

	// /codigo Henrique + valor total de compras
	public String pesquisaBinaria(long cpf){
		
		String vendas = "";
		double valorTotal = 0;
		
		int i, meio, esq = 0, dir = this.fim-1;
		
		vendas += cpf;
		
		
		while(esq <= dir){
			
			meio = (esq+dir)/2;
			
			if(cpf == this.info[meio].getCpf()){
				vendas += "\n" + this.info[meio].toString();
				valorTotal += this.info[meio].getValor();
				
				//Bloco adicionado		
				i = 1;
				//Anda para a esquerda no vetor a partir do "meio", para encontrar todas as ocorrencias da busca nesta direcao
				while(meio != 0 && this.info[meio - i].getCpf() == cpf ){	
					vendas += "\n" + this.info[meio-i].toString();
					valorTotal += this.info[meio].getValor();
					if(meio-i == 0){
						break;
					}
					i++;
				}
				
				i = 1;
				//Anda para a direita no vetor a partir do "meio", para encontrar todas as ocorrencias da busca nesta direcao
				while(meio != this.info.length-1 && this.info[meio + i].getCpf() == cpf ){
					vendas += "\n" + this.info[meio+i].toString();
					valorTotal += this.info[meio].getValor();
					if(meio+i == this.info.length-1){
						break;
					}
					i++;
				}
				
				vendas +="\n\t\t Total de Compras = R$:"+valorTotal;
				valorTotal = 0;
				return vendas;
				//Fim do Bloco adicionado
				
			}
			else{
				if(cpf < this.info[meio].getCpf())
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		
		return null;
	}

}// fim bloco principal