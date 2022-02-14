package entity;

import java.time.LocalDate;

/**
 * 
 * @author jBach
 * 
 * Foresporsel class for when the customer requests to view available cars for the given info
 * @param utleiested - where the car will be rented from
 * @param retursted - where the car will be returned
 * @param dato - date the customer wants to rent the car from
 * @param klokkeslett - time of day the customer wants to pick up the car
 * @param varighet - how long the customer wants to rent the car, in whole days. Return time will be the same as pick up
 *
 */

public class Foresporsel {
	
	Utleiekontor utleiested;
	Utleiekontor retursted;
	LocalDate dato;
	double klokkeslett; //I 24 timer med 2 desimaler som min: Eks 12.45
	int varighet; // i antall dager
	
	


	public Foresporsel(Utleiekontor utleiested, Utleiekontor retursted, LocalDate dato, double klokkeslett,
			int varighet) {
		this.utleiested = utleiested;
		this.retursted = retursted;
		this.dato = dato;
		this.klokkeslett = klokkeslett;
		this.varighet = varighet;
	}

	public Utleiekontor getUtleiested() {
		return utleiested;
	}



	public void setUtleiested(Utleiekontor utleiested) {
		this.utleiested = utleiested;
	}



	public Utleiekontor getRetursted() {
		return retursted;
	}



	public void setRetursted(Utleiekontor retursted) {
		this.retursted = retursted;
	}



	public LocalDate getDato() {
		return dato;
	}



	public void setDato(LocalDate dato) {
		this.dato = dato;
	}



	public double getKlokkeslett() {
		return klokkeslett;
	}



	public void setKlokkeslett(double klokkeslett) {
		this.klokkeslett = klokkeslett;
	}



	public int getVarighet() {
		return varighet;
	}



	public void setVarighet(int varighet) {
		this.varighet = varighet;
	}



	@Override
	public String toString() {
		return "Foresporsel [utleiested=" + utleiested.getAdresse().getGateAdresse() 
				+ ", retursted=" + retursted.getAdresse().getGateAdresse() + ", dato=" + dato
				+ ", klokkeslett=" + klokkeslett + ", varighet=" + varighet + " dager]";
	}

	
	
	
	
	

}
