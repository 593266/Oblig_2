package controller;

import java.time.LocalDate;
import java.util.Map;

import entity.Adresse;
import entity.Bil;
import entity.Foresporsel;
import entity.Kunde;
import entity.Reservasjon;
import entity.Utleiegruppe;
import entity.Utleiekontor;
import entity.Utleieselskap;
import service.KundeService;
import service.UtleiekontorService;
import service.UtleieselskapService;

public class Main {
	
	public static void main(String[] args) {
		
		//MAIN FOR UTLEIESELSKAP
		//Etabler utleieselskap

		Utleieselskap utleieselskap = new Utleieselskap("Bach Bilutleie", 41631332, new Adresse("ABV 21", 5089, "Bergen")); //Oppretter utleieselskap
		UtleieselskapService ulService = new UtleieselskapService(utleieselskap); //kobling til utleieselskap service
		
		Map<Integer, Utleiekontor> utleiekontorOversikt = ulService.getUtleiekontorOversikt(); //Utleieselskap sine kontorer


		
		//Oppretter første utleiekontor
		ulService.opprettUtleiekontor(40494901, new Adresse("Bergen lufthavn", 5050, "Bergen"));
		
		//Oppretter andre utleiekontor
		ulService.opprettUtleiekontor(51633242, new Adresse("Stavanger lufthavn", 4020, "Stavanger"));

		
		//Printer ut alle kontorer		
		utleiekontorOversikt = ulService.getUtleiekontorOversikt();		
		utleiekontorOversikt.entrySet().forEach(entry -> {
		    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
		});
		
		
		//MAIN FOR UTLEIEKONTOR1
		
		Utleiekontor utleiekontor1 = utleiekontorOversikt.get(1); //Henter ut utleiekontor med id 1
		UtleiekontorService ukService1 = new UtleiekontorService(utleiekontor1); //oppretter koblig til utleiekontorservice for utleiekontor 1
//		System.out.println(utleiekontor1);
		
		//Oppretter 3 nye biler som har blitt kjøpt inn
		ukService1.opprettNyBilOgLeggtilIOversikt("ek3471", "Renault", "Zoe", "Sølv", Utleiegruppe.A, true, 10000.00);
		ukService1.opprettNyBilOgLeggtilIOversikt("eL6534", "Audi", "A1", "Blå", Utleiegruppe.A, true, 12000.23);
		ukService1.opprettNyBilOgLeggtilIOversikt("kb6534", "Audi", "A1", "Blå", Utleiegruppe.A, true, 12000.23);


		ukService1.opprettNyBilOgLeggtilIOversikt("uv2394", "BMW", "X5", "Sort", Utleiegruppe.C, true, 8563.23);
		Map<String,Bil> bilOversikt = ukService1.getBilOversikt();
		
		//Printer ut bilene til Utleiekontor 1
		System.out.println("Utleiekontor 1 sine biler:");
		bilOversikt.entrySet().forEach(entry -> {
		    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
		});
			
		
		//Endre status på bil med ID UV2394 til utlånt
		Bil biluv2394 = bilOversikt.get("uv2394");
		biluv2394.setLedig(false);
		//Sjekk om bilen er ledig
		System.out.println("Er bil med ID uv2394 er ledig? " + biluv2394.isLedig());


		
		
		
		//MAIN FOR KUNDE
		//Oppretter ny kunde
		Kunde kunde = new Kunde("Jonas", "Bach", new Adresse("Ole bullsvei 4", 5023, "bergen"), 92846372);
		//Oppretter kobling til Kunde sin serviceklasse
		KundeService kService = new KundeService(kunde);
		
		System.out.println(kunde);
		
		
		
		//Kunde sender en forespørsel om leie av bil ved utleiekontor 1, med retur ved samme kontor, 
		//for 2 dager fra 15-2-2022 klokken 12.45
		//Forespørselen skal returnere en oversikt over hvilke bilkategorier han kan velge mellom, inkl pris
		Map<Utleiegruppe, Integer> kategoriOversikt = 
				kService.sendForesporsel(utleiekontor1, utleiekontor1, LocalDate.of(2022, 2, 15), 12.45, 2);
		System.out.println(kategoriOversikt);
		
		
		//Oppretter forespørsel og sender reservasjon
		Foresporsel foresporsel1 = new Foresporsel(utleiekontor1, utleiekontor1, LocalDate.of(2022, 2, 15), 12.45, 2);
		kService.sendReservasjon(foresporsel1, Utleiegruppe.A, kunde, 1234);
		
		Foresporsel foresporsel2 = new Foresporsel(utleiekontor1, utleiekontor1, LocalDate.of(2022, 2, 15), 12.45, 2);
		kService.sendReservasjon(foresporsel2, Utleiegruppe.A, kunde, 4321);
		
		Map<Integer,Reservasjon> reservasjonOversikt = ukService1.getReservasjonOversikt();
		reservasjonOversikt.entrySet().forEach(entry -> {
		    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
		});
		
		Reservasjon reservasjon2 = reservasjonOversikt.get(1);
		System.out.println("Test" + reservasjon2);
		
		//Returnerer bilen og får utskrevet regning
//		long kostnadVedLeie = kService.returAvBil(reservasjonOversikt.get(1), 11000.00, LocalDate.of(2022, 2, 17), 19.46);
//		System.out.println(kostnadVedLeie);
		
		
		
		
		



	}

}
