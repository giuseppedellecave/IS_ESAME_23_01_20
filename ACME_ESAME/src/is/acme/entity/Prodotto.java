package is.acme.entity;

public class Prodotto {

	private int codice;
	private String nome;
	private String descrizione;
	private float prezzo;
	private int quantita;
	
	public Prodotto(int codice, String nome, String descrizione, float prezzo, int quantita) {
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}

	public int getCodice() {
		return codice;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
