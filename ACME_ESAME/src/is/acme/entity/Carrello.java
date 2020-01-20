package is.acme.entity;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<DettaglioProdotto> prodottiInCarrello;

	public Carrello() {
		this.prodottiInCarrello = new ArrayList<DettaglioProdotto>();
	}

	public void aggiungiProdotto(Prodotto prodotto, int quantita) throws Exception {
		if ((prodotto.getQuantita() - quantita) < 0)
			throw new Exception("Quantià non disponibile!");

		else {
			this.prodottiInCarrello.add(new DettaglioProdotto(prodotto, quantita));
			prodotto.setQuantita(prodotto.getQuantita() - quantita);
		}
	}
	
	public ArrayList<DettaglioProdotto> svuotaCarrello() {
		return prodottiInCarrello;
	}

}
