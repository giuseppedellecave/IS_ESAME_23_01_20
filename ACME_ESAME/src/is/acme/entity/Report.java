package is.acme.entity;

public class Report {

	private int numeroSpese;
	private Cliente cliente;
	private float spesaTotale;

	public Report(Cliente cliente, int numeroSpese, float spesaTotale) {
		this.cliente = cliente;
		this.numeroSpese = numeroSpese;
		this.spesaTotale = spesaTotale;
	}

	public String toString(){
		return "REPORT CLIENTE " + this.cliente.getNomeUtente() 
		+"\nNUMERO SPESE = " + this.numeroSpese
		+ "\nCOSTO COMPLESSIVO =  " + this.spesaTotale 
		+ "\n\n"
		;
	}
	
	public boolean equals(Object o) {
		Report r = (Report) o;
		if(this.numeroSpese == r.getNumeroSpese() && 
				this.spesaTotale == r.getSpesaTotale() && 
				this.cliente.equals(r.getCliente()))
			return true;
		else
			return false;
	}
	
	public int getNumeroSpese() {
		return numeroSpese;
	}

	public void setNumeroSpese(int numeroSpese) {
		this.numeroSpese = numeroSpese;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getSpesaTotale() {
		return spesaTotale;
	}

	public void setSpesaTotale(float spesaTotale) {
		this.spesaTotale = spesaTotale;
	}
}
