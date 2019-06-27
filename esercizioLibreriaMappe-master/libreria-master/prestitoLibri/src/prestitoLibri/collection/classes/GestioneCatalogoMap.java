package prestitoLibri.collection.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import prestitoLibri.collection.interfaces.InterfacciaGestioneCatalogoMap;

public class GestioneCatalogoMap implements InterfacciaGestioneCatalogoMap {


	public boolean inPrestito(Date d) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataRiferimento = new Date();
		try {
			dataRiferimento = formatter.parse("01/01/1800");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d.equals(dataRiferimento);
	}
	
	
	
	
	public void daRestituire(String titoloLibro, HashMap<String,Libro> catalogoLibri, HashMap<String,Prestito> prestitiNonResi) {
		boolean flag=false;	
		for(String key : catalogoLibri.keySet()) {
			Libro libro = catalogoLibri.get(key);
			if (libro.getTitoloLibro().contains(titoloLibro)) {
				flag=true;
				if (prestitiNonResi.containsKey(libro.getIdLibro())) {
					System.out.println("Il libro " + libro.getTitoloLibro() + " è da restituire.");
				}
				else{
					System.out.println("Il libro " + libro.getTitoloLibro() + " è in biblioteca.");
				}
			}
		}
		if(!flag) {
			System.out.println("Il libro non esiste");
		}
	}
		
	
	
	
	public void libriUtente(String nomeUtente, String cognomeUtente, HashMap<String,Libro> catalogoLibri, HashMap<String,Prestito> prestitiNonResi) {
		boolean flag= false;
		for(String key : prestitiNonResi.keySet()) {
			Prestito prestito = prestitiNonResi.get(key);
			if(prestito.getNomeUtente().equals(nomeUtente) && prestito.getCognomeUtente().equals(cognomeUtente)) {
				String key2 = prestito.getIdLibro();
				Libro libro = catalogoLibri.get(key2);
				System.out.println("L'utente " + nomeUtente + " " + cognomeUtente + " ha in prestito il libro " + libro.getTitoloLibro());
				flag=true;
			}
		}
		if(!flag) {				
			System.out.println("L'utente " + nomeUtente + " " + cognomeUtente + " non ha in prestito alcun libro.");
		}
	}
	
	
	
	
	public void storicoUtente(String nomeUtente, String cognomeUtente, HashMap<String,Libro> catalogoLibri, Collection<Prestito> elencoPrestiti) {
		boolean flag = false;
		System.out.println("L'utente " + nomeUtente + " " + cognomeUtente + " ha in prestito i libri:");
		for(Prestito prestito : elencoPrestiti) {
			if(prestito.getNomeUtente().equals(nomeUtente) && prestito.getCognomeUtente().equals(cognomeUtente)) {
				String idLibro = prestito.getIdLibro();
				Libro libro = catalogoLibri.get(idLibro);
				System.out.println(libro.getTitoloLibro());
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("Nessuno");
		}
	}
	
	
	
	
	
	public void utenteInPrestito(String titoloLibro, HashMap<String,Libro> catalogoLibri, HashMap<String,Prestito> prestitiNonResi) {
		boolean flag;
		for(String key1 : catalogoLibri.keySet()) {
			flag = false;
			Libro libro = catalogoLibri.get(key1);
			if (libro.getTitoloLibro().contains(titoloLibro)) {
				if(prestitiNonResi.containsKey(key1)) {
					Prestito prestito = prestitiNonResi.get(key1);
					System.out.println("L'utente " + prestito.getNomeUtente() + " " + prestito.getCognomeUtente() + " è in possesso del libro " + libro.getTitoloLibro());
					flag = true;
				}
				if(!flag) {
					System.out.println("Il libro "+ libro.getTitoloLibro() + " NON è in prestito");
				}
			}
		}
	}
	
	
	
	
	
	public void tempoPrestitoMassimo(String titoloLibro, HashMap<String,Libro>catalogoLibri, Collection<Prestito> elencoPrestiti) {
		
		Date dataAttuale = new Date(); 
		for(String key: catalogoLibri.keySet()) {
			long massimo = 0;	
			Libro libro=catalogoLibri.get(key);
			if(libro.getIdLibro().contains(key)) {
				for(Prestito prestito : elencoPrestiti) {
					if(prestito.getIdLibro().contentEquals(key)) {
						if(inPrestito(prestito.getFinePrestito())) {
							long differenzaDate = Math.abs(dataAttuale.getTime()-prestito.getInizioPrestito().getTime());
							if(differenzaDate > massimo) {
								massimo = differenzaDate;
							}
						}
						else {
							long differenzaDate = Math.abs(prestito.getFinePrestito().getTime()-prestito.getInizioPrestito().getTime());
							if(differenzaDate > massimo) {
								massimo = differenzaDate;
							}
						}
					}	
				}
				
				if(massimo == 0) {
					System.out.println("Il libro "+ libro.getTitoloLibro() + " non è mai stato preso in prestito");
				}
				else {
					System.out.println("Il libro "+ libro.getTitoloLibro() + " è stato preso in prestito per un periodo massimo di " + massimo/(1000*60*60*24) + " giorni");
				}
			}
		}
	}
	
	
}
