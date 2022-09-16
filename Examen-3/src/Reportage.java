
public class Reportage extends Emission {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4062945882252950195L;

	protected String sujet;
	protected String presentateur;
	
	public Reportage() {
		super();
	}

	public Reportage(int idEmission, String nomEmission, int heureDeb, int heureFin, String sujet, String presentateur) {
		super(idEmission, nomEmission, heureDeb, heureFin);
		this.setSujet(sujet);
		this.setPresentateur(presentateur);
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getPresentateur() {
		return presentateur;
	}

	public void setPresentateur(String presentateur) {
		this.presentateur = presentateur;
	}

	@Override
	public String toString() {
		return (this.nomEmission.length() < 17) ? this.idEmission + "\t" + this.nomEmission + "\t\t"  + this.heureDeb + "\t" + this.heureFin + "\t" + this.sujet + "\t"
	+ this.presentateur + "\n" : this.idEmission + "\t" + this.nomEmission + "\t"  + this.heureDeb + "\t" + this.heureFin + "\t" + this.sujet + "\t"
			+ this.presentateur + "\n" ;
	}
	
}
