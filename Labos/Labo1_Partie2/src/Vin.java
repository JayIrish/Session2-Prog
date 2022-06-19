
public class Vin {


		private String nom;
		private int type;
		private String origine;
		private double prix;
		
		public static double ttlPrix;
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
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
}
