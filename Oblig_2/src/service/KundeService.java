package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import entity.Bil;
import entity.Foresporsel;
import entity.Kunde;
import entity.Reservasjon;
import entity.Utleiegruppe;
import entity.Utleiekontor;

/**
 * 
 * @author jBach
 * the class that handles all actions made by the customer
 *
 */

public class KundeService {
	Kunde kunde;
	Foresporsel foresporsel;
	Map<Utleiegruppe, Integer> kategoriOversikt;
	Utleiekontor utleiested;
	Utleiekontor retursted;
	LocalDate dato;
	double klokkeslett; //I 24 timer med 2 desimaler som min: Eks 12.45
	int varighet; // i antall dager
	Bil reservertBil;
	Reservasjon reservasjon;
//	UtleiekontorService ukService;
	
	private static int idCount = 0;

		
	public KundeService(Kunde kunde) {
		this.kunde = kunde;
	}
	
	public Map<Utleiegruppe, Integer> sendForesporsel(Utleiekontor utleiested, Utleiekontor retursted, LocalDate dato, 
			double klokkeslett, int varighet) {
		foresporsel = new Foresporsel(utleiested, retursted, dato, klokkeslett, varighet);
		
		kategoriOversikt = opprettKategoriOversiktForForesporsel(foresporsel);
		
		return kategoriOversikt;
		
		
	}

	private Map<Utleiegruppe, Integer> opprettKategoriOversiktForForesporsel(Foresporsel foresporsel) {
	
		kategoriOversikt = new HashMap<Utleiegruppe,Integer>();
		
		Utleiekontor utleiested = foresporsel.getUtleiested();
		
		Map<String, Bil> bilOversikt = new HashMap<String, Bil>();
		bilOversikt = utleiested.getBilOversikt();
		
		bilOversikt.entrySet().forEach(entry -> {
			if (entry.getValue().getUtleiegruppe() == Utleiegruppe.A) {
				kategoriOversikt.put(Utleiegruppe.A, 1000);
			} 
			if (entry.getValue().getUtleiegruppe() == Utleiegruppe.B) {
				kategoriOversikt.put(Utleiegruppe.B, 1500);
			} 
			if (entry.getValue().getUtleiegruppe() == Utleiegruppe.C) {
				kategoriOversikt.put(Utleiegruppe.C, 2000);
			}
			if (entry.getValue().getUtleiegruppe() == Utleiegruppe.D) {
				kategoriOversikt.put(Utleiegruppe.D, 1800);
			}
		});
		
		return kategoriOversikt;
		
	}
	
	
	
	public void sendReservasjon(Foresporsel foresporsel, Utleiegruppe kategori, Kunde kunde, int kredittkort) {
		int id = ++idCount;
		//Henter første bil som er i Mappen over valgt utleiegruppe
		Map<String, Bil> bilOversikt = new HashMap<String, Bil>();
		bilOversikt = foresporsel.getUtleiested().getBilOversikt();
//		Map<Integer,Reservasjon> reservasjonOversikt = foresporsel.getUtleiested().getReservasjonOversikt();
		UtleiekontorService ukService = new UtleiekontorService(foresporsel.getUtleiested());
		
		for (Entry<String, Bil> entry : bilOversikt.entrySet()) {
			if (entry.getValue().getUtleiegruppe() == kategori) {
				reservertBil = bilOversikt.get(entry.getKey());
				if (reservertBil.isLedig() == true) {
					Reservasjon reservasjon = ukService.opprettReservasjon(id, foresporsel, reservertBil, kategori, kunde, 
							reservertBil.getKmstand(), kredittkort, false);
//					Reservasjon reservasjon = new Reservasjon(id,foresporsel, reservertBil, kategori, kunde, 
//							reservertBil.getKmstand(), kredittkort, false);
					
//					reservasjonOversikt.put(reservasjon.getId(), reservasjon);
				reservertBil.setLedig(false);
				
				bilOversikt.remove(reservertBil.getRegNr());
				System.out.println(reservasjon);

				} else 
					System.out.println("Ingen ledige biler ved valgt kategori");
		        break;
			}
		}

		
	}
	
	public long returAvBil(Reservasjon reservasjon, double kmstandVedRetur, LocalDate faktiskReturDato, 
			double faktiskReturKlokkeslett) {
		String regNr = reservasjon.getBil().getRegNr();
		LocalDate utleiedato = reservasjon.getForesporsel().getDato();
		long dagerUtleid = ChronoUnit.DAYS.between(utleiedato, faktiskReturDato);
		Utleiegruppe kategori = reservasjon.getKategori();
		int dognPris = 0;
		if (kategori == Utleiegruppe.A) {
			dognPris = 1000;
		} else if (kategori == Utleiegruppe.B) {
			dognPris = 1500;
		} else if (kategori == Utleiegruppe.C) {
			dognPris = 1800;
		} else if (kategori == Utleiegruppe.D) {
			dognPris = 2000;
		}
		
		if (faktiskReturKlokkeslett > reservasjon.getForesporsel().getKlokkeslett()) {
			dagerUtleid++;
		}
		
		long leieKostnad = dognPris * dagerUtleid;
		
		Bil utleidBil = reservasjon.getBil();
			utleidBil.setLedig(true);
			
			System.out.println("Bil med regNr " + regNr + ", utleid i " + dagerUtleid + "dager, har en regning på "
					+ leieKostnad + " Kroner");
			System.out.println("Bilen hadde en kmstand på " + reservasjon.getKmstandVedUtleie() + " ved utleie"
					+ " og " + kmstandVedRetur + " ved retur");
			System.out.println("Kredittkortet " + reservasjon.getKredittkort() + " blir belastet med " + leieKostnad + " kroner");
		return leieKostnad;
	}
	
	
	

	public Foresporsel getForesporsel() {
		return foresporsel;
	}

	public void setForesporsel(Foresporsel foresporsel) {
		this.foresporsel = foresporsel;
	}

	public Map<Utleiegruppe, Integer> getKategoriOversikt() {
		return kategoriOversikt;
	}

	public void setKategoriOversikt(Map<Utleiegruppe, Integer> kategoriOversikt) {
		this.kategoriOversikt = kategoriOversikt;
	}

	public Reservasjon getReservasjon() {
		return reservasjon;
	}

	public void setReservasjon(Reservasjon reservasjon) {
		this.reservasjon = reservasjon;
	}
	
	
	
	
	
	

}
