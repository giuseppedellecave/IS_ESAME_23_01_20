package is.acme.control;

import java.util.*;
import is.acme.entity.*;

public class GestoreClienti {

	private ArrayList<Cliente> listaClienti;

	public GestoreClienti() {

		this.listaClienti = new ArrayList<Cliente>();

	}


	public void creaCliente(String nomeUtente, String password, String numeroTelefono, String cartaCredito) {

		this.listaClienti.add(new Cliente(nomeUtente, password, numeroTelefono, cartaCredito));

	}

	public ArrayList<Cliente> getListaClienti() {

		return this.listaClienti;

	}

	public void effettuaSpesa(int ID, Cliente cliente, ArrayList<DettaglioProdotto> dettaglioProdotto) {

		Date data=java.util.Calendar.getInstance().getTime();
		Spesa s = new Spesa(ID, data, dettaglioProdotto);
		cliente.addListaSpese(s);
		
	}
	
	
}
