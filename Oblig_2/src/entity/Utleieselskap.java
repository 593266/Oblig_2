package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author jBach
 * 
 * A single company that can have multiple rental locations
 * @param navn - the name of the company
 * @param telefon - phone number for the company
 * @param adresse - full address for the company
 * @param utleiekontorOversikt - a Map of all the rental places that are owned by the company
 *
 */
public class Utleieselskap {
	
	String navn;
	int telefon;
	Adresse adresse;
	Map<Integer, Utleiekontor> utleiekontorOversikt;
	




	public Utleieselskap(String navn, int telefon, Adresse adresse) {
		this.navn = navn;
		this.telefon = telefon;
		this.adresse = adresse;
		this.utleiekontorOversikt = new HashMap<Integer, Utleiekontor>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Map<Integer, Utleiekontor> getUtleiekontorOversikt() {
		return utleiekontorOversikt;
	}

	public void setUtleiekontorOversikt(Map<Integer, Utleiekontor> utleiekontorOversikt) {
		this.utleiekontorOversikt = utleiekontorOversikt;
	}


	
	
	
	

}
