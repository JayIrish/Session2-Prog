import java.io.Serializable;

public class Emission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5920190670428722424L;

	protected int idEmission;
	protected String nomEmission;  
	protected int heureDeb;
	protected int heureFin;
	
	protected int nmbEmissions;

	Emission(){
		++nmbEmissions;
	}
	
	Emission(int idEmission, String nomEmission, int heureDeb, int heureFin){
		this.setIdEmission(idEmission);
		this.setNomEmission(nomEmission);
		this.setHeureDeb(heureDeb);
		this.setHeureFin(heureFin);
		++nmbEmissions;
	}

	public int getIdEmission() {
		return idEmission;
	}

	public void setIdEmission(int idEmission) {
		this.idEmission = idEmission;
	}

	public String getNomEmission() {
		return nomEmission;
	}

	public void setNomEmission(String nomEmission) {
		this.nomEmission = nomEmission;
	}

	public int getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(int heureDeb) {
		this.heureDeb = heureDeb;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	public int getNmbEmissions() {
		return nmbEmissions;
	}

	@Override
	public String toString() {
		return this.idEmission + "\t" + this.nomEmission + "\t"  + this.heureDeb + "\t" + this.heureFin + "\t"  + this.nmbEmissions + "\n";
	}
	
	
}

