package is.acme.control;

import java.util.ArrayList;

import is.acme.entity.*;

public class GestoreImpiegati {

	private ArrayList<Prodotto> listaProdotti;

	public GestoreImpiegati() {
		this.listaProdotti = new ArrayList<Prodotto>();
	}

	public void creaProdotto (int codice, String nome, String descrizione, float prezzo, int quantita) {
		this.listaProdotti.add(new Prodotto(codice, nome, descrizione, prezzo, quantita));
	}

	public ArrayList<Prodotto> getListaProdotti()throws ACME_Exception{
		ArrayList<Prodotto> ris = new ArrayList<Prodotto>();

		boolean found = false;

		for(Prodotto prd : listaProdotti)
			if(prd.getQuantita() > 0) {
				ris.add(prd);
				found = true;
			}

		if(!found)
			throw new ACME_Exception("Nessun Prodotto Disponibile!"); 
		return ris;
	}

	public ArrayList<Report> generaReport(int N, ArrayList<Cliente> listaClienti) {
		boolean found = false;
		ArrayList<Report> res = new ArrayList<Report>();

		for(Cliente cliente : listaClienti) {
			if(cliente.getListaSpese().size() >= N) {
				found = true;
				res.add(new Report(cliente, cliente.getListaSpese().size(), cliente.getCostoComplessivoSpese()));
			}

		}
		if(!found) {
			System.out.println("REPORT VUOTO\n\n");
		}
		return res;
	}
}
