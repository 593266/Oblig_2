package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Adresse;
import entity.Bil;
import entity.Foresporsel;
import entity.Kunde;
import entity.Utleiegruppe;
import entity.Utleiekontor;
import entity.Utleieselskap;
import service.KundeService;
import service.UtleiekontorService;
import service.UtleieselskapService;

/**
 * 
 * @author jBach
 *
 */
class UtleieselskapTest {
	private Kunde kunde;
	private KundeService kService;
	private Utleieselskap utleieselskap;
	private UtleieselskapService ulService;
	private Map<Integer, Utleiekontor> utleiekontorOversikt;
	private Utleiekontor utleiekontor1;
	private UtleiekontorService ukService1;
	private Map<String, Bil> bilOversikt;

	@Before
	public void init() throws Exception {
		

	}

	@Test
	// Tester at første og andre reservasjon får henholdsvis id nr 1 og 2
	void testReservasjonId() throws Exception {
		// Opprett kunde og kobling
				kunde = new Kunde("Jonas", "Bach", new Adresse("Ole bullsvei 4", 5023, "bergen"), 92846372);
				kService = new KundeService(kunde);
				// Opprett utleiesselskap og kobling
				utleieselskap = new Utleieselskap("Bach Bilutleie", 41631332, new Adresse("ABV 21", 5089, "Bergen")); // Oppretter
																														// utleieselskap
				ulService = new UtleieselskapService(utleieselskap);
				// Opprett utleiekontor og hent oversikt
				ulService.opprettUtleiekontor(40494901, new Adresse("Bergen lufthavn", 5050, "Bergen"));
				utleiekontorOversikt = ulService.getUtleiekontorOversikt();

				// Kobling til utleiekontor
				utleiekontor1 = utleiekontorOversikt.get(1);
				ukService1 = new UtleiekontorService(utleiekontor1); // oppretter koblig til utleiekontorservice for
																		// utleiekontor 1
				// Opprett bil
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3471", "Renault", "Zoe", "Sølv", Utleiegruppe.A, true, 10000.00);
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3472", "Renault", "Zoe", "Sølv", Utleiegruppe.B, true, 10000.00);
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3473", "Renault", "Zoe", "Sølv", Utleiegruppe.C, true, 10000.00);
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3474", "Renault", "Zoe", "Sølv", Utleiegruppe.D, true, 10000.00);
				bilOversikt = ukService1.getBilOversikt();
				
				
				
	}

	@Test
	public void kostnadVedUtleie() throws Exception {
		// Opprett kunde og kobling
				kunde = new Kunde("Jonas", "Bach", new Adresse("Ole bullsvei 4", 5023, "bergen"), 92846372);
				kService = new KundeService(kunde);
				// Opprett utleiesselskap og kobling
				utleieselskap = new Utleieselskap("Bach Bilutleie", 41631332, new Adresse("ABV 21", 5089, "Bergen")); // Oppretter
																														// utleieselskap
				ulService = new UtleieselskapService(utleieselskap);
				// Opprett utleiekontor og hent oversikt
				ulService.opprettUtleiekontor(40494901, new Adresse("Bergen lufthavn", 5050, "Bergen"));
				utleiekontorOversikt = ulService.getUtleiekontorOversikt();

				// Kobling til utleiekontor
				utleiekontor1 = utleiekontorOversikt.get(1);
				ukService1 = new UtleiekontorService(utleiekontor1); // oppretter koblig til utleiekontorservice for
																		// utleiekontor 1
				// Opprett bil
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3471", "Renault", "Zoe", "Sølv", Utleiegruppe.A, true, 10000.00);
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3472", "Renault", "Zoe", "Sølv", Utleiegruppe.B, true, 10000.00);
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3473", "Renault", "Zoe", "Sølv", Utleiegruppe.C, true, 10000.00);
				ukService1.opprettNyBilOgLeggtilIOversikt("ek3474", "Renault", "Zoe", "Sølv", Utleiegruppe.D, true, 10000.00);
				bilOversikt = ukService1.getBilOversikt();

		Foresporsel foresporsel1 = new Foresporsel(utleiekontor1, utleiekontor1, LocalDate.of(2022, 2, 15), 12.45, 2);
		Foresporsel foresporsel2 = new Foresporsel(utleiekontor1, utleiekontor1, LocalDate.of(2022, 2, 15), 12.45, 2);
		Foresporsel foresporsel3 = new Foresporsel(utleiekontor1, utleiekontor1, LocalDate.of(2022, 2, 15), 12.45, 2);
		Foresporsel foresporsel4 = new Foresporsel(utleiekontor1, utleiekontor1, LocalDate.of(2022, 2, 15), 12.45, 2);

		// Opprett foresporsel for kunde og send reservasjon
		kService.sendReservasjon(foresporsel1, Utleiegruppe.A, kunde, 1234);
		kService.sendReservasjon(foresporsel2, Utleiegruppe.B, kunde, 1234);
		kService.sendReservasjon(foresporsel3, Utleiegruppe.C, kunde, 1234);
		kService.sendReservasjon(foresporsel4, Utleiegruppe.D, kunde, 1234);

		// Tester at leiekostnaden blir riktig for 3 døgn ved de 4 kategoriene
		long kostnadVedLeie = kService.returAvBil(kService.getReservasjon(), 11000.00, LocalDate.of(2022, 2, 17),
				19.46);
		assertEquals(3000, kostnadVedLeie);
	}

}
