package service;

import java.util.HashMap;
import java.util.Map;

import entity.Bil;
import entity.Foresporsel;
import entity.Kunde;
import entity.Reservasjon;
import entity.Utleiegruppe;
import entity.Utleiekontor;

/**
 * 
 * @author jBach
 * a class that handles all the actions made by the rental office
 *
 */

public class UtleiekontorService {
	Map<String, Bil> bilOversikt;
	Map<Integer, Reservasjon> reservasjonOversikt;
	Utleiekontor utleiekontor;
	
	
	
	public UtleiekontorService(Utleiekontor utleiekontor) {
		this.bilOversikt = new HashMap<String, Bil>();
		this.reservasjonOversikt = new HashMap<Integer, Reservasjon>();
		this.utleiekontor = utleiekontor;
	}

	//Oppretter reservasjon og legger til i oversikt
	public Reservasjon opprettReservasjon(int id, Foresporsel foresporsel, Bil bil, Utleiegruppe kategori, Kunde kunde, double kmstandVedUtleie,
			int kredittkort, boolean bilReturnert) {
		Reservasjon nyReservasjon = new Reservasjon(id,foresporsel, bil, kategori, kunde, kmstandVedUtleie, kredittkort, bilReturnert);
		reservasjonOversikt = utleiekontor.getReservasjonOversikt();
		reservasjonOversikt.put(nyReservasjon.getId(), nyReservasjon);
		
		return nyReservasjon;
	}


	//Oppretter ny bil og legger til i utleiekontoret sin bilOversikt
	public void opprettNyBilOgLeggtilIOversikt(String regNr, String merke, String modell, String farge, 
			entity.Utleiegruppe utleiegruppe, boolean ledig, double kmstand) {
		Bil nyBil = new Bil(regNr, merke, modell, farge, utleiegruppe, ledig, kmstand);
		
		leggtilEksisterendeBilIOversikt(nyBil);
		
	}

	
	
	
	//Legger til eksisterende bil i utleiekontoret sin bilOversikt
	public void leggtilEksisterendeBilIOversikt(Bil bil) {

		
		bilOversikt = utleiekontor.getBilOversikt();
		bilOversikt.put(bil.getRegNr(), bil);
			
	}




	public Map<String, Bil> getBilOversikt() {
		return bilOversikt;
	}

	public Map<Integer, Reservasjon> getReservasjonOversikt() {
		return reservasjonOversikt;
	}
	
	





	
	
	

}
