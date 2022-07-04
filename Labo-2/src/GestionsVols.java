import java.io.*;
import java.util.ArrayList;

import javax.swing.JTextArea;
public class GestionsVols {
	static final String FICHIER_CIEAIRRELAX = "src/donnees/Cie Air Relax.txt";
	static ArrayList<Vol> tabVols;
	static BufferedReader tmpVolRead;
	static BufferedWriter tmpVolWrite;
	static JTextArea output;
	public final int MAX_PLACES = 340;

	

	public static void chargerVols() throws Exception {
		try {
			String ligne;
			tabVols = new ArrayList<Vol>();
			tmpVolRead = new BufferedReader(new FileReader(FICHIER_CIEAIRRELAX));
			ligne = tmpVolRead.readLine();//Lire la premiére ligne du fichier
			while (ligne != null) {//Si ligne == null alors ont a atteint la fin du fichier
				int numVol = Integer.parseInt(ligne.substring(0, 5));
				String destination = ligne.substring(6, 22);
				destination = destination.trim();
				int jour = Integer.parseInt(ligne.substring(27, 29));
				int mois = Integer.parseInt(ligne.substring(30, 32));
				int annee = Integer.parseInt(ligne.substring(33, 37));
				int nbPassager = Integer.parseInt(ligne.substring(38));
				tabVols.add(new Vol(numVol, destination, new Date(jour, mois, annee), nbPassager));
				ligne = tmpVolRead.readLine();
			}//fin while
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable. Vérifiez le chemin et nom du fichier.");
		}
		catch (IOException e) {
			System.out.println("Un probléme est arrivé lors de la manipulation du fichier. V�rifiez vos données.");
		}catch (Exception e) { 
			System.out.println("Un probléme est arrivé lors du chargement du fichier. Contactez l'administrateur.");
		}finally {//Exécuté si erreur ou pas
			tmpVolRead.close();
		}
	}
	
	public static void insererVol() {
		
	}
	
	public static Vol rechercherVol(int numVol) {
		tabVols.forEach(null);
		Vol tmpVol = new Vol();
		tmpVol.setNumVol(numVol);
		
		return tmpVol;
	}
	
	public static void main(String[] args) throws Exception {
		chargerVols();
		System.out.println(tabVols);

	}

}
