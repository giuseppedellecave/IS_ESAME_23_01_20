package is.acme.main;

import is.acme.control.*;
import is.acme.entity.*;
import java.util.*;

public class Main {

	public static void main(String [] args) {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		//
		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 4);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 5);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);
		gImpiegati.creaProdotto(4, "Maschera Anti-Age" , "Via le rughe!" , 7.99f, 10);
		//

		//
		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");
		gClienti.creaCliente("Ciro Abete", "C123", "2546587452", "2543-6987-6541-2502");
		//


		try {
			Carrello carrello1 = new Carrello();
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 3);
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 2);
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(3), 4);
			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());


			Carrello carrello2 = new Carrello();
			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 1);
			gClienti.effettuaSpesa(2, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());

			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(1, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

		}

		catch(ACME_Exception e) {
			e.printStackTrace();
		}
	}

}
