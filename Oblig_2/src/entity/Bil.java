package entity;

/**
 * 
 * @author jBach
 * 
 *  Car class with necessary info
 * @param regNr -  registration number of car, used as primary key
 * @param merke - cars brand
 * @param modell - cars model
 * @param farge - cars color
 * @param utleiegruppe - Enum over categories of cars
 * @param ledig - if the car is available or not
 * @param kmstand - current odometer value in km
 *
 */

public class Bil {
	
	String regNr; //Primary key
	String merke;
	String modell;
	String farge;
	Utleiegruppe utleiegruppe; 
	boolean ledig;
	double kmstand;

	
	public Bil(String regNr, String merke, String modell, String farge, Utleiegruppe utleiegruppe, boolean ledig, double kmstand) {
		this.regNr = regNr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.utleiegruppe = utleiegruppe;
		this.ledig = ledig;
		this.kmstand = kmstand;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public Utleiegruppe getUtleiegruppe() {
		return utleiegruppe;
	}

	public void setUtleiegruppe(Utleiegruppe utleiegruppe) {
		this.utleiegruppe = utleiegruppe;
	}

	public boolean isLedig() {
		return ledig;
	}

	public void setLedig(boolean ledig) {
		this.ledig = ledig;
	}

	
	public double getKmstand() {
		return kmstand;
	}

	public void setKmstand(double kmstand) {
		this.kmstand = kmstand;
	}

	@Override
	public String toString() {
		return "Bil [regNr=" + regNr + ", merke=" + merke + ", modell=" + modell + ", farge=" + farge
				+ ", utleiegruppe=" + utleiegruppe + ", ledig=" + ledig + ", kmstand=" + kmstand + "]";
	}


	
	
	
	
	

}
