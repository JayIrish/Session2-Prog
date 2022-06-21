
public class Vin {
		private String nom;
		private int type;
		private String origine;
		private double prix;
		private static double ttlPrix;
		private static int nbVin;
		
		final int ROUGE = 1;
		final int BLANC = 2;
		final int ROSE = 3;
		
		
         

	Vin(String nom, int type, String origine, double prix){
		this.setNom(nom);
		this.setType(type);
		this.setOrigine(origine);
		this.setPrix(prix);
		ttlPrix += this.prix;
		nbVin++;
		}
	
	Vin(String nom, String origine, double prix){
		this.setNom(nom);
		this.setType(type);
		this.setOrigine(origine);
		this.setPrix(prix);
		ttlPrix += this.prix;
		nbVin++;
	}
	
	public static int getNbVin() {
		return Vin.nbVin;
	}
	public static double getTtlPrix() {
		return Vin.ttlPrix;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getType() {
		return this.type;
	}
	
	public String getOrigine() {
		return this.origine;
	}
	
	public double getPrix() {
		return this.prix;
	}
	public static void setTtlPrix(double newTtl) {
		Vin.ttlPrix = newTtl;
	}
	public void setNom(String newNom) {
		this.nom = newNom;
	}
	
	public void setType(int newType) {
		this.type = newType;
	}
	
	public void setOrigine(String newOrigine) {
		this.origine = newOrigine;
	}
	
	public void setPrix(double newPrix) {
		
		this.prix = newPrix;
	}
	
	private String couleur() {
		if(this.type == ROUGE) {
			return "rouge";
		}else if(this.type == BLANC) {
			return "blanc";
	}else if(this.type == ROSE) {
		return "rose";
	}else {
		return "Une erreure s'est produite sur la couleur du Vin\n";
	}
	}
	public String toString() {
		return this.nom +" est un vin"+ couleur() +" de "+ this.origine +" au prix de "+ this.prix+"$\n";
	
	}
}

