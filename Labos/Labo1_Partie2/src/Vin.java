
public class Vin {
		private String nom;
		private int type;
		private String origine;
		private double prix;
		private static double ttlPrix;
		public static int nbVin;
         

	Vin(String nom, int type, String origine, double prix){
		this.nom = nom;
		this.type = type;
		this.origine = origine;
		this.prix = prix;
		ttlPrix += this.prix;
		nbVin++;
		}
	
	Vin(String nom, String origine, double prix){
		this.nom = nom;
		this.type = 1;
		this.origine = origine;
		this.prix = prix;
		ttlPrix += this.prix;
		nbVin++;
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
	
	public String toString() {
		if(this.type == 1) {
			return this.nom +" est un vin"+ " rouge" +" de "+ this.origine +" au prix de "+ this.prix+"$\n";
		}else if(this.type == 2) {
			return this.nom +" est un vin"+ " blanc" +" de "+ this.origine +" au prix de "+ this.prix+"$\n";
	}else if(this.type == 3) {
		return this.nom +" est un vin"+ " rosé" +" de "+ this.origine +" au prix de "+ this.prix+"$\n";
	}else {
		return "Une erreure s'est produite sur la couleur du Vin\n";
	}
	
	}
}

