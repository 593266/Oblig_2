package entity;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author jBach
 * A single rental office under the company
 * @param id - primary key used to identify each rental office
 * @param telefon - phone number of the office
 * @param adresse - full address of the office
 * @param bilOversikt - A map over all the car that are either available, or will be returned to the rental office
 *
 */

public class Utleiekontor {
	
	
	int id; //Primary key
	int telefon;
	Adresse adresse;
	Map<String, Bil> bilOversikt;
	Map<Integer, Reservasjon> reservasjonOversikt;

	


	public Utleiekontor(int id, int telefon, Adresse adresse) {
		this.id = id;
		this.telefon = telefon;
		this.adresse = adresse;
		this.bilOversikt = new HashMap<String,Bil>();
		this.reservasjonOversikt = new HashMap<Integer, Reservasjon>();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	

	public Map<String, Bil> getBilOversikt() {
		return bilOversikt;
	}

	public void setBilOversikt(Map<String, Bil> bilOversikt) {
		this.bilOversikt = bilOversikt;
	}
	
	

	public Map<Integer, Reservasjon> getReservasjonOversikt() {
		return reservasjonOversikt;
	}

	public void setReservasjonOversikt(Map<Integer, Reservasjon> reservasjonOversikt) {
		this.reservasjonOversikt = reservasjonOversikt;
	}

	@Override
	public String toString() {
		return "Utleiekontor [id=" + id + ", telefon=" + telefon + ", " + adresse + ", BilOversikt="
				+ bilOversikt + "]";
	}


	
	
	
	

}
