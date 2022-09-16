
public class Fiction extends Emission {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8536320181693364604L;

	
	protected String nomFilm;
	protected int anneeRealisation;
	protected String nomRealisateur;
	protected boolean rediffusion;
	
	public Fiction() {
		super();
	}
	
	public Fiction(int idEmission, String nomEmission, int heureDeb, int heureFin, String nomFilm, int anneeRealisation, String nomRealisateur, boolean rediffusion) {
		super(idEmission, nomEmission, heureDeb, heureFin);
		this.setNomFilm(nomFilm);
		this.setAnneeRealisation(anneeRealisation);
		this.setNomRealisateur(nomRealisateur);
		this.setRediffusion(rediffusion);
	}
	
	public String getNomFilm() {
		return nomFilm;
	}
	
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	
	public int getAnneeRealisation() {
		return anneeRealisation;
	}
	
	public void setAnneeRealisation(int anneeRealisation) {
		this.anneeRealisation = anneeRealisation;
	}
	
	public String getNomRealisateur() {
		return nomRealisateur;
	}
	
	public void setNomRealisateur(String nomRealisateur) {
		this.nomRealisateur = nomRealisateur;
	}
	
	public boolean isRediffusion() {
		return rediffusion;
	}
	
	public void setRediffusion(boolean rediffusion) {
		this.rediffusion = rediffusion;
	}

		@Override
		public String toString() {
			String rediffusion;
			if(this.rediffusion) {
				 rediffusion = "Oui";
			}else {
				 rediffusion = "Non";
			}
			if(this.nomFilm.length() < 17 && (this.nomRealisateur.length() <= 12 || this.nomRealisateur.equalsIgnoreCase("Alfred Hitchcock"))) {
				return this.idEmission + "\t" + this.nomEmission + "\t"  + this.heureDeb + "\t" + this.heureFin + "\t" + this.nomFilm + "\t\t" + 
			this.anneeRealisation + "\t" + this.nomRealisateur + "\t\t"  + rediffusion + "\n";
			}
			else if(this.nomFilm.length() < 28 && this.nomRealisateur.length() <= 12) {
				return this.idEmission + "\t" + this.nomEmission + "\t"  + this.heureDeb + "\t" + this.heureFin + "\t" + this.nomFilm + "\t" + 
						this.anneeRealisation + "\t" + this.nomRealisateur + "\t\t"  + rediffusion + "\n";
			} 
			else if(this.nomFilm.length() < 17){
				return this.idEmission + "\t" + this.nomEmission + "\t"  + this.heureDeb + "\t" + this.heureFin + "\t" + this.nomFilm + "\t\t" + 
						this.anneeRealisation + "\t" + this.nomRealisateur + "\t"  + rediffusion + "\n";
			}
			else if(this.nomFilm.length() < 28) { return this.idEmission + "\t" + this.nomEmission + "\t"  + this.heureDeb + "\t" + this.heureFin + "\t" 
			+ this.nomFilm + "\t" + this.anneeRealisation+ "\t" + this.nomRealisateur + "\t"  + rediffusion + "\n" ;
			}
			else {
				return this.idEmission + "\t" + this.nomEmission + "\t"  + this.heureDeb + "\t" + this.heureFin + "\t" + this.nomFilm +	this.anneeRealisation
						+ "\t" + this.nomRealisateur + "\t"  + rediffusion + "\n" ;
			}

		}
	
}
