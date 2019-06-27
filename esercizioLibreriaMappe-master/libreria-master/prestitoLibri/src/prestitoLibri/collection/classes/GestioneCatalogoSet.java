package prestitoLibri.collection.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import prestitoLibri.collection.interfaces.InterfacciaGestioneCatalogo;

public class GestioneCatalogoSet implements InterfacciaGestioneCatalogo {


//	Implementare tutti i metodi utilizzando l'HashSet
	
	public boolean inPrestito(Date d);
	public void daRestituire(String titoloLibro, , );
	public void libriUtente(String nomeUtente, String cognomeUtente, , );
	public void storicoUtente(String nomeUtente, String cognomeUtente, , Collection<Prestito> elencoPrestiti);
	public void utenteInPrestito(String titoloLibro, , );
	public void tempoPrestitoMassimo(String titoloLibro, , Collection<Prestito> elencoPrestiti);

	
}
