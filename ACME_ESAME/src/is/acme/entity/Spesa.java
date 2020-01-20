package is.acme.entity;

import java.util.*;

public class Spesa {

	private int ID;
	private Date data;
	private float costoTotale = 0.00f;
	private StatoSpedizione stato;
	private ArrayList<DettaglioProdotto> dettaglioProdotto;

	public Spesa(int ID, Date data, ArrayList<DettaglioProdotto> dettaglioProdotto) {

		this.ID = ID;
		this.data = data;
		this.stato = StatoSpedizione.ORDINATA;
		this.dettaglioProdotto = new ArrayList<DettaglioProdotto>(dettaglioProdotto);

		for(DettaglioProdotto dettaglioPrd : dettaglioProdotto) {
			this.costoTotale +=  ((dettaglioPrd.getQuantita()) * (dettaglioPrd.getProdotto().getPrezzo()));
		}
		
		

	}

	public Date getData() {
		return data;
	}


	public float getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(float costoTotale) {
		this.costoTotale = costoTotale;
	}

	public StatoSpedizione getStato() {
		return stato;
	}

	public void setStato(StatoSpedizione stato) {
		this.stato = stato;
	}

	public ArrayList<DettaglioProdotto> getDettaglioProdotto() {
		return dettaglioProdotto;
	}

	public int getID() {
		return ID;
	}



}
