
public class Produit {
	
	private int numProd;
	private double prixProd;

	
	
	Produit(int numProd, double prixProd){
		setNumProd(numProd);
		setPrixProd(prixProd);
	}
	
	public String afficher(){
		return "Numéro de produit: "+ this.numProd + " Prix du produit: " + this.prixProd;
	}
	
	public int getNumProd() {
		return this.numProd;
	}
	
	public double getPrixProd() {
		return this.prixProd;
	}
	
	public void setPrixProd(double prix) {
		this.prixProd = prix;
	}
	
	public void setNumProd(int num) {
		this.numProd = num;
	}
	
	public String toString(){
		return this.numProd +";"+ this.prixProd;
	}
	
	
	
}
