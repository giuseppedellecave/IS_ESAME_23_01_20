package is.acme.entity;

import java.util.*;

public class Cliente {

	private String nomeUtente;
	private String password;
	private String numeroTelefono;
	private String cartaCredito;
	private ArrayList<Spesa> listaSpese;
	
	public Cliente(String nomeUtente, String password, String numeroTelefono, String cartaCredito) {
		
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.numeroTelefono = numeroTelefono;
		this.cartaCredito = cartaCredito;
		this.listaSpese = new ArrayList<Spesa>();
		
	}
	
	public boolean equals(Object o) {
		Cliente c = (Cliente) o;
		if(c.getNomeUtente().equals(this.nomeUtente) && 
				c.getPassword().equals(this.password) && 
				c.getNumeroTelefono().equals(this.numeroTelefono) && 
				c.getCartaCredito().equals(this.cartaCredito) && 
				c.getListaSpese().equals(this.listaSpese))
			return true;
		else
			return false;
	}
	
	public float getCostoComplessivoSpese() {
		float costoComplessivo = 0;
		for(Spesa s : listaSpese) {
			costoComplessivo += s.getCostoTotale();
		}
		return costoComplessivo;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getCartaCredito() {
		return cartaCredito;
	}

	public void setCartaCredito(String cartaCredito) {
		this.cartaCredito = cartaCredito;
	}

	public ArrayList<Spesa> getListaSpese() {
		return listaSpese;
	}

	public void addListaSpese(Spesa spesa) {
		this.listaSpese.add(spesa);
	}

}