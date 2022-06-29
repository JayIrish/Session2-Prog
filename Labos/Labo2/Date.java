
public class Date {
	private int jour;
	private int mois;
	private int annee;
	
	Date(int jour, int mois, int an){
		this.setJour(jour);
		this.setMois(mois);
		this.setAnnee(an);		
	};
	
	public int getJour() {
		return this.jour;
	}
	
	public int getMois() {
		return this.mois;
	}
	
	public int getAnnee() {
		return this.annee;
	}
	
	public void setJour(int jour) {
		this.jour = jour;
	}
	
	public void setMois(int mois) {
	this.mois = mois;
	}
	
	public void setAnnee(int annee){
		this.annee = annee;
	}
	
	public String toString() {
		return this.jour +"/"+this.mois+"/"+this.annee;
	}
}

