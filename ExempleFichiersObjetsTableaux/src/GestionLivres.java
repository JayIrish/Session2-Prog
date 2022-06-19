import java.io.*;
import javax.swing.*;

public class GestionLivres {
	static final int NBLIVRES = 30;
	static final String FICHIER_LIVRES = "src/donnees/livres.txt";
	static Livre biblio[]; 
	static BufferedReader tmpLivres; 
	static JTextArea sortie;
	
	public static void chargerLivres() throws Exception {
		try {
			int i = 0;
			String ligne;
			String elems[] = new String[3];
			biblio = new Livre[NBLIVRES];
			tmpLivres = new BufferedReader(new FileReader(FICHIER_LIVRES));
			ligne = tmpLivres.readLine();//Lire la première ligne du fichier
			while (i < NBLIVRES && ligne != null) {//Si ligne == null alors ont a atteint la fin du fichier
				elems = ligne.split(";");//elems[0] contient le numéro du livre;elems[1] le titre et elems[2] les pages
				biblio[i++] = new Livre(Integer.parseInt(elems[0]), elems[1], Integer.parseInt(elems[2]));
				ligne = tmpLivres.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable. Vérifiez le chemin et nom du fichier.");
		}
		catch (IOException e) {
			System.out.println("Un problème est arrivé lors de la manipulation du fichier. Vérifiez vos données.");
		}catch (Exception e) { 
			System.out.println("Un problème est arrivé lors du chargement du fichier. Contactez l'administrateur.");
		}finally {//Exécuté si erreur ou pas
			tmpLivres.close();
		}
	}
	
	public static void afficherListeLivres() {
		sortie = new JTextArea();
		int taille = Livre.nbLivres;
		sortie.append("\tLISTE DES LIVRES\n\n");
		sortie.append("NUMÉRO\tTITRE\t\tPAGES\n");
		for(int i = 0; i < taille; i++) {
			sortie.append(biblio[i].toString());
		}
		JOptionPane.showMessageDialog(null, sortie, null, JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String[] args) throws Exception {
		chargerLivres();
		afficherListeLivres();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Livre livre1 = new Livre();
		//System.out.println(livre1);
		
		Livre livre2 = new Livre(100,"Titanic", 400);
		//System.out.println(livre2);
		
		Livre livre3 = new Livre(livre2);
		//System.out.println(livre3);
		
		biblio[0] = new Livre(200, "Le soleil vert", 350);
		biblio[1] = livre2;
		biblio[2] = biblio[0];
		
		for(Livre unLivre : biblio) {
			if(unLivre != null) {
				System.out.println(unLivre);
			}else {
				break;
			}
		}
		
		for(Livre unLivre : biblio) {
			if(unLivre != null) {
				System.out.println(unLivre.getTitre()+"\t"+unLivre.getPages());
			}else {
				break;
			}
		}
		
		System.out.println("Nombre de livres = "+Livre.nbLivres);*/
		

	}

}
