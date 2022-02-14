package entity;

/**
 * 
 * @author jBach
 * 
 * An address class that contains full address info
 * @param gateAdresse
 * @param postNr
 * @param postSted
 * 
 *
 */
public class Adresse {
	
	String gateAdresse;
	int postNr;
	String postSted;
	
	public Adresse(String gateAdresse, int postNr, String postSted) {
		this.gateAdresse = gateAdresse;
		this.postNr = postNr;
		this.postSted = postSted;
	}

	public String getGateAdresse() {
		return gateAdresse;
	}

	public void setGateAdresse(String gateAdresse) {
		this.gateAdresse = gateAdresse;
	}

	public int getPostNr() {
		return postNr;
	}

	public void setPostNr(int postNr) {
		this.postNr = postNr;
	}

	public String getPostSted() {
		return postSted;
	}

	public void setPostSted(String postSted) {
		this.postSted = postSted;
	}

	@Override
	public String toString() {
		return "Adresse: " + gateAdresse + ", " + postNr + ", " + postSted;
	}
	
	
	
	
	
	

}
