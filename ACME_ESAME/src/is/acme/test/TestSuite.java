package is.acme.test;

import is.acme.entity.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import is.acme.control.GestoreClienti;
import is.acme.control.GestoreImpiegati;
import is.acme.entity.Carrello;
import is.acme.entity.Report;

public class TestSuite {

	@Test
	public void test1() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 4);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 5);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);



		ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(2, gClienti.getListaClienti()));

		for(Report r : report)
			System.out.println(r.toString());

		ArrayList<Report> oracolo = new ArrayList<Report>();

		assertEquals(oracolo, report); 



	}

	@Test
	public void test2() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 4);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 5);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");

		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 1); //Fazzoloetti

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());

			Carrello carrello2 = new Carrello();
			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 1); //Deodorante
			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 1); //Dentifricio

			gClienti.effettuaSpesa(2, gClienti.getListaClienti().get(0), carrello2.svuotaCarrello());

			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(2, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

			ArrayList<Report> oracolo = new ArrayList<Report>();

			oracolo.add(new Report(gClienti.getListaClienti().get(0), 2, 11.35f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test3() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 4);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 5);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");

		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 2); //Fazzoloetti

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(1, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

			ArrayList<Report> oracolo = new ArrayList<Report>();
			oracolo.add(new Report(gClienti.getListaClienti().get(0), 1, 7.96f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test4() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 4);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 5);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");

		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 2); //Fazzoloetti
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(0, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

			ArrayList <Report> oracolo = new ArrayList<Report>();

			oracolo.add(new Report(gClienti.getListaClienti().get(0), 1, 13.52f));
			oracolo.add(new Report(gClienti.getListaClienti().get(1), 0, 0.00f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test5() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 4);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 5);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");

		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 2); //Fazzoloetti
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());


			Carrello carrello2 = new Carrello();

			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante
			gClienti.effettuaSpesa(2, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(2, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

			ArrayList<Report> oracolo = new ArrayList<Report>();

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test6() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 20);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 20);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 20);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");
		gClienti.creaCliente("Ciro Abete", "C123", "2546587452", "2543-6987-6541-2502");

		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 2); //Fazzoloetti
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());

			Carrello carrello2 = new Carrello();

			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio

			gClienti.effettuaSpesa(2, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());

			Carrello carrello3 = new Carrello();

			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio
			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante

			gClienti.effettuaSpesa(3, gClienti.getListaClienti().get(0), carrello3.svuotaCarrello());

			Carrello carrello4 = new Carrello();

			carrello4.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 1); //Fazzoloetti

			gClienti.effettuaSpesa(4, gClienti.getListaClienti().get(1), carrello4.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(2, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());


			ArrayList <Report> oracolo = new ArrayList<Report>();

			oracolo.add(new Report(gClienti.getListaClienti().get(0), 2, 25.06f));
			oracolo.add(new Report(gClienti.getListaClienti().get(1), 2, 6.55f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test7() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 20);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 20);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 20);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");


		try {


			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(1), carrello1.svuotaCarrello());


			Carrello carrello2= new Carrello();

			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 2); //Fazzoloetti

			gClienti.effettuaSpesa(2, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(2, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());


			ArrayList <Report> oracolo = new ArrayList<Report>();

			oracolo.add(new Report(gClienti.getListaClienti().get(1), 2, 7.54f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test8() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 6);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 6);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");
		gClienti.creaCliente("Ciro Abete", "C123", "2546587452", "2543-6987-6541-2502");


		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 1); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 3); //Fazzoloetti

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());


			Carrello carrello2 = new Carrello();

			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 1); //Deodorante
			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 2); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());

			Carrello carrello3 = new Carrello();

			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 3); //Dentifricio
			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 4); //Fazzoletti

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(2), carrello3.svuotaCarrello());




			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(1, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

			ArrayList<Report> oracolo = new ArrayList<Report>();
			oracolo.add(new Report(gClienti.getListaClienti().get(0), 1, 5.96f));
			oracolo.add(new Report(gClienti.getListaClienti().get(1), 1, 5.77f));
			oracolo.add(new Report(gClienti.getListaClienti().get(2), 1, 8.13f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test9() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 6);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 6);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);




		ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(1, null));

		for(Report r : report)
			System.out.println(r.toString());


		ArrayList <Report> oracolo = new ArrayList<Report>();


		assertEquals(oracolo, report); 




	}

	@Test
	public void test10() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 6);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 6);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");
		gClienti.creaCliente("Ciro Abete", "C123", "2546587452", "2543-6987-6541-2502");


		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 1); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 3); //Fazzoloetti

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());


			Carrello carrello2 = new Carrello();

			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 1); //Deodorante
			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 2); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(-1, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

			ArrayList<Report> oracolo = new ArrayList<Report>();

			assertEquals(oracolo, report);

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void tes11() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 20);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 20);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 20);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");
		

		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 1); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 2); //Fazzoloetti
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 1); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());

			Carrello carrello2 = new Carrello();

			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio

			gClienti.effettuaSpesa(2, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());

			Carrello carrello3 = new Carrello();

			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio
			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante

			gClienti.effettuaSpesa(3, gClienti.getListaClienti().get(0), carrello3.svuotaCarrello());

			Carrello carrello4 = new Carrello();

			carrello4.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 1); //Fazzoloetti

			gClienti.effettuaSpesa(4, gClienti.getListaClienti().get(1), carrello4.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(2, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());


			ArrayList <Report> oracolo = new ArrayList<Report>();

			oracolo.add(new Report(gClienti.getListaClienti().get(0), 2, 17.90f));
			oracolo.add(new Report(gClienti.getListaClienti().get(1), 2, 6.55f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}
	
	@Test
	public void tes12() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 20);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 20);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 20);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");
		

		try {
			Carrello carrello1 = new Carrello();

			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 1); //Deodorante
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 2); //Fazzoloetti
			carrello1.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 1); //Dentifricio

			gClienti.effettuaSpesa(1, gClienti.getListaClienti().get(0), carrello1.svuotaCarrello());

			Carrello carrello2 = new Carrello();

			carrello2.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio

			gClienti.effettuaSpesa(2, gClienti.getListaClienti().get(1), carrello2.svuotaCarrello());

			Carrello carrello3 = new Carrello();

			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(1), 4); //Dentifricio
			carrello3.aggiungiProdotto(gImpiegati.getListaProdotti().get(0), 2); //Deodorante

			gClienti.effettuaSpesa(3, gClienti.getListaClienti().get(0), carrello3.svuotaCarrello());

			Carrello carrello4 = new Carrello();

			carrello4.aggiungiProdotto(gImpiegati.getListaProdotti().get(2), 1); //Fazzoloetti

			gClienti.effettuaSpesa(4, gClienti.getListaClienti().get(1), carrello4.svuotaCarrello());


			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(1, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());


			ArrayList <Report> oracolo = new ArrayList<Report>();

			oracolo.add(new Report(gClienti.getListaClienti().get(0), 2, 17.90f));
			oracolo.add(new Report(gClienti.getListaClienti().get(1), 2, 6.55f));

			assertEquals(oracolo, report); 

		} catch (ACME_Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void test13() {

		GestoreClienti gClienti = new GestoreClienti();
		GestoreImpiegati gImpiegati = new GestoreImpiegati();

		gImpiegati.creaProdotto(1, "Deodorante", "Elimina il sudore!" , 2.99f , 4);
		gImpiegati.creaProdotto(2, "Dentifricio", "Sbianca i denti!" , 1.39f, 5);
		gImpiegati.creaProdotto(3, "Fazzoletti" , "Salute! Grazie!" , 0.99f, 10);

		gClienti.creaCliente("Mario Rossi" , "M123" , "3254658758", "1024-5875-4875-4784");
		gClienti.creaCliente("Luigi Albero", "L123", "2541785478", "2546-5874-5896-5421");

		
			ArrayList<Report> report = new ArrayList<Report>(gImpiegati.generaReport(1, gClienti.getListaClienti()));

			for(Report r : report)
				System.out.println(r.toString());

			ArrayList<Report> oracolo = new ArrayList<Report>();

			assertEquals(oracolo, report); 


	}
	
}
