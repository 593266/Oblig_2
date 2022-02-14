package entity;

/**
 * 
 * @author jBach
 * a customer class with necessary info about the customer
 * @param fornavn - first name
 * @param etternavn - last name
 * @param adresse - full address of customer
 * @param telefon - customers phone number
 *
 */
public class Kunde {
	
	String fornavn;
	String etternavn;
	Adresse adresse;
	int telefon;
	
	public Kunde(String fornavn, String etternavn, Adresse adresse, int telefon) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefon = telefon;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Kunde [fornavn=" + fornavn + ", etternavn=" + etternavn + ", " + adresse + ", telefon="
				+ telefon + "]";
	}
	
	
	
	

}
