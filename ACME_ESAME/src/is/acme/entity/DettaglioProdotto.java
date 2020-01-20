package is.acme.entity;

public class DettaglioProdotto {

	private Prodotto prodotto; 
	private int quantita;

	public DettaglioProdotto(Prodotto prodotto, int quantita) {

		this.prodotto = prodotto;
		this.quantita = quantita;

	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}
