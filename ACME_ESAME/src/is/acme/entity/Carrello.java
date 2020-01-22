package is.acme.entity;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<DettaglioProdotto> prodottiInCarrello;

	public Carrello() {
		this.prodottiInCarrello = new ArrayList<DettaglioProdotto>();
	}

	public void aggiungiProdotto(Prodotto prodotto, int quantita) throws ACME_Exception {
		if ((prodotto.getQuantita() - quantita) < 0)
			throw new ACME_Exception("Quantità non disponibile!");

		else {
			this.prodottiInCarrello.add(new DettaglioProdotto(prodotto, quantita));
			prodotto.setQuantita(prodotto.getQuantita() - quantita);
		}
	}
	
	public ArrayList<DettaglioProdotto> svuotaCarrello() {
		return prodottiInCarrello;
	}

}
