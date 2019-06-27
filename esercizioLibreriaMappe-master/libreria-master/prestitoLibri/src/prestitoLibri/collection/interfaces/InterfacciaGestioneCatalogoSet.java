package prestitoLibri.collection.interfaces;

import java.util.Collection;
import java.util.Date;

import prestitoLibri.collection.classes.Libro;
import prestitoLibri.collection.classes.Prestito;

public interface InterfacciaGestioneCatalogoSet extends InterfacciaGestioneCatalogo {

//	Modificare tutti gli input dei metodi da HashsMap a HashSet
	
	public void daRestituire(String titoloLibro, HashMap<String,Libro> catalogoLibri, HashMap<String,Prestito> prestitiNonResi);
	public void libriUtente(String nomeUtente, String cognomeUtente, HashMap<String,Libro> catalogoLibri, HashMap<String,Prestito> prestitiNonResi);
	public void storicoUtente(String nomeUtente, String cognomeUtente, HashMap<String,Libro> catalogoLibri, Collection<Prestito> elencoPrestiti);
	public void utenteInPrestito(String titoloLibro, HashMap<String,Libro> catalogoLibri, HashMap<String,Prestito> prestitiNonResi);
	public void tempoPrestitoMassimo(String titoloLibro, HashMap<String,Libro>catalogoLibri, Collection<Prestito> elencoPrestiti);

}
