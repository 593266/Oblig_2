package entity;

import java.util.Date;

/**
 * 
 * @author jBach
 * a class for when a customer books a car
 * @param foresporsel - the request the customer made prior to the booking
 * @param bil - the car that the customer will rent
 * @param kategori - category of the rented car
 * @param kunde - info about the customer renting the car
 * @param kmstandVedUtleie - the km of the car before rental period
 * @param kredittkort - the credit card the bill will be paid with
 * @param bilReturnert - boolean value if the car has been returned or not
 *
 */

public class Reservasjon {
	
	int id;
	Foresporsel foresporsel;
	Bil bil;
	Utleiegruppe kategori;
	Kunde kunde;
	double kmstandVedUtleie;
	int kredittkort;
	boolean bilReturnert;
	
//	int idIncrementer = 0;

	
	public Reservasjon(int id, Foresporsel foresporsel, Bil bil, Utleiegruppe kategori, Kunde kunde, double kmstandVedUtleie,
			int kredittkort, boolean bilReturnert) {
		this.id = id;;
		this.foresporsel = foresporsel;
		this.bil = bil;
		this.kategori = kategori;
		this.kunde = kunde;
		this.kmstandVedUtleie = kmstandVedUtleie;
		this.kredittkort = kredittkort;
		this.bilReturnert = false;
	}
	
	

	public int getId() {
		return id;
	}



	public Foresporsel getForesporsel() {
		return foresporsel;
	}

	public void setForesporsel(Foresporsel foresporsel) {
		this.foresporsel = foresporsel;
	}

	public Bil getBil() {
		return bil;
	}

	public void setBil(Bil bil) {
		this.bil = bil;
	}

	public Utleiegruppe getKategori() {
		return kategori;
	}

	public void setKategori(Utleiegruppe kategori) {
		this.kategori = kategori;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public double getKmstandVedUtleie() {
		return kmstandVedUtleie;
	}

	public void setKmstandVedUtleie(double kmstandVedUtleie) {
		this.kmstandVedUtleie = kmstandVedUtleie;
	}

	public int getKredittkort() {
		return kredittkort;
	}

	public void setKredittkort(int kredittkort) {
		this.kredittkort = kredittkort;
	}

	public boolean isBilReturnert() {
		return bilReturnert;
	}

	public void setBilReturnert(boolean bilReturnert) {
		this.bilReturnert = bilReturnert;
	}



	@Override
	public String toString() {
		return "Reservasjon [id=" + id + ", foresporsel=" + foresporsel + ", bil=" + bil + ", kategori=" + kategori
				+ ", kunde=" + kunde + ", kmstandVedUtleie=" + kmstandVedUtleie + ", kredittkort=" + kredittkort
				+ ", bilReturnert=" + bilReturnert + "]";
	}



	

//	@Override
//	public String toString() {
//		return "Reservasjon [bil=" + bil + ", kunde="
//				+ kunde + ", kmstandVedUtleie=" + kmstandVedUtleie + ", kredittkort=" + kredittkort + ", bilReturnert="
//				+ bilReturnert + "]";
//	}
	
	
	
	
	
	
	
	
	
	
	

}
