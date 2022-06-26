import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Produit {
	final static String PROD_DATA = "src/données/produits.txt";
	private int numProd;
	private double prixProd;
	static ArrayList<Produit> tabProduits;
	static BufferedReader tmpProduitRead;
	static BufferedWriter tmpProduitWrite;
	static JTextArea output;
	
	
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
	
	public static void chargerProduits() throws Exception {
		try {
			String ligne;
			String elems[] = new String[8];
			tabProduits = new ArrayList<Produit>();
			tmpProduitRead = new BufferedReader(new FileReader(PROD_DATA));
			ligne = tmpProduitRead.readLine();//Lire la premiére ligne du fichier
			while (ligne != null) {//Si ligne == null alors ont a atteint la fin du fichier
				elems = ligne.split(";");//elems[0] contient le numero du produit et elems[1] le prix
				tabProduits.add(new Produit(Integer.parseInt(elems[0]), Integer.parseInt(elems[1])));
				ligne = tmpProduitRead.readLine();
			}//fin while
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable. Vérifiez le chemin et nom du fichier.");
		}
		catch (IOException e) {
			System.out.println("Un probléme est arrivé lors de la manipulation du fichier. V�rifiez vos données.");
		}catch (Exception e) { 
			System.out.println("Un probléme est arrivé lors du chargement du fichier. Contactez l'administrateur.");
		}finally {//Exécuté si erreur ou pas
			tmpProduitRead.close();
		}
	}

	
}
