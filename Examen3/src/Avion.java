import java.io.Serializable;

public class Avion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8790726731638816580L;
	//attribut d'instance
	private String typeAvion;
	private int nbPlaces;
	private String rayonAction;
	private String classe;
	
	
	// constructeur par default
	public Avion() {
	}


	// constructeur param�tr�
	public Avion(String typeAvion, int nbPlaces, String rayonAction, String classe) {
		this.typeAvion = typeAvion;
		this.nbPlaces = nbPlaces;
		this.rayonAction = rayonAction;
		this.classe = classe;
	}


	//getters/accesseurs
	public String getTypeAvion() {
		return typeAvion;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public String getRayonAction() {
		return rayonAction;
	}

	public String getClasse() {
		return classe;
	}

	
	//setters/mutateurs
	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public void setRayonAction(String rayonAction) {
		this.rayonAction = rayonAction;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	@Override
	public String toString() {
		return typeAvion + "\t" + nbPlaces + "\t\t" + rayonAction + "\t" + classe + "\t\t";
	}


	

	
	
	
}

