package estruturas;

import dados.Item;

public class NoDupla {
	private Item info;	// o tipo Item está declarado no capitulo 1
	private NoDupla prox;
	private NoDupla ant;

	public NoDupla (Item elem){
		this.info = elem;
		this.prox = null;
		this.ant = null;
	}
	public Item getInfo (){
		return this.info;
	}
	public NoDupla getProx(){
		return this.prox;
	}
	public NoDupla getAnt(){
		return this.ant;
	}
	public void setProx(NoDupla _no){
		this.prox = _no;
	}
	public void setAnt(NoDupla _no){
		this.ant = _no;
	}
}
