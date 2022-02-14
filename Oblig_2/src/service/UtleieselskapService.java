package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Adresse;
import entity.Utleiekontor;
import entity.Utleieselskap;

/**
 * 
 * @author jBach
 * a class that handles all the actions by the rental company
 */
public class UtleieselskapService {
	
	Map<Integer, Utleiekontor> utleiekontorOversikt;
	Utleieselskap utleieselskap;
	
	private static int idCount = 0;
	
	
	
	public UtleieselskapService(Utleieselskap utleieselskap) {
		this.utleiekontorOversikt = new HashMap<Integer, Utleiekontor>();
		this.utleieselskap = utleieselskap;
	}

	//Opprett nytt utleiekontor
	public void opprettUtleiekontor(int telefon, Adresse adresse) {
		int id = ++idCount;
		Utleiekontor utleiekontor = new Utleiekontor(id, telefon, adresse);
		leggTilUtleiekontorIListe(utleiekontor);
	}
	
	//Legg til utleiekontor i listen over selskapets utleiesteder
	private void leggTilUtleiekontorIListe(Utleiekontor utleiekontor) {
		utleiekontorOversikt = utleieselskap.getUtleiekontorOversikt();
		
		utleiekontorOversikt.put(utleiekontor.getId(), utleiekontor);
		
	}

	public Map<Integer, Utleiekontor> getUtleiekontorOversikt() {
		return utleiekontorOversikt;
	}

	
	
	

	

}
