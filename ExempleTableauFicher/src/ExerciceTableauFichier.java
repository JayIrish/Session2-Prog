import javax.swing.*; 
import java.text.*; 
import java.io.*;

public class ExerciceTableauFichier{
	
	static void traiterLesClients(int tabNoProd[], double tabPrix[],
			int tabQteTotale[], int nbProd) { 
		DecimalFormat cash = new DecimalFormat("0.00 $"); 
		int numero, qte, posiProd; // position du num�ro dans le tableau tabNoProd 
		double cout; 
		char reponse;                
	do { 
		numero = Integer.parseInt(JOptionPane.showInputDialog( "Entrez le num�ro du produit � acheter :")); 
		qte = Integer.parseInt(JOptionPane.showInputDialog( "Entrez la quantit� d�sir�e :"));
		posiProd = rechercher(tabNoProd, nbProd, numero );
		
		if (posiProd != -1) { 
			tabQteTotale[posiProd] += qte;
			cout = tabPrix[posiProd] * qte;
			JOptionPane.showMessageDialog(null, "Le co�t de cet achat est de " + cash.format(cout)); 
		} else {
			JOptionPane.showMessageDialog(null, "No de produit erron�");
		}
	   reponse = JOptionPane.showInputDialog( "Avez-vous un autre client � traiter O/N ?").charAt(0); 
	   reponse = Character.toUpperCase(reponse); 
	   } while (reponse == 'O');
	} // fin de la m�thode traiterLesClients
	
	static int rechercher(int tab[], int nbEl, int valeurCherchee){
		int posi = -1;
		boolean trouve = false;
		for (int i = 0; i < nbEl && !trouve; i++) {
			if (tab[i] == valeurCherchee){
			posi = i;
			trouve = true;
			}
		}
		return posi; 
		} // fin de la m�thode rechercher
		
	static void afficherResultats(int tabNoProd[], int tabQteTotale[], int nbProd) {
		JTextArea sortie = new JTextArea();
		sortie.setEditable(false);
		sortie.append("\tNum�ro\tQuantit�\n");
		sortie.append("\tproduit\ttotale\n\n");
		for(int i = 0; i<nbProd;i++) {
			sortie.append("\t"+tabNoProd[i]+"\t"+tabQteTotale[i]+"\n");
		}
		JOptionPane.showMessageDialog(null, sortie, "R�sultats de la journ�e : ",JOptionPane.PLAIN_MESSAGE);
	} // fin de la m�thode afficherResultats } // fin de la classe
	
	static int batirTableau(int tabNoProd[],double tabPrixProd[],int tailleTableaux)throws IOException{	
		
		final String FICHIER_PRODUITS = "src/donnee/produits.txt";
		BufferedReader ficProd = new BufferedReader(new FileReader(FICHIER_PRODUITS));
		int i = 0;
		String ligne;
		String elems[];
		ligne = ficProd.readLine();
		while(i<tailleTableaux && ligne != null) {
			elems = ligne.split(";");
			tabNoProd[i] =Integer.parseInt(elems[0]);
			tabPrixProd[i] = Double.parseDouble(elems[1]);
			++i; //i = i+1;
			ligne = ficProd.readLine();
		}
		ficProd.close();
		return i;
	}
	public static void main(String args[])throws IOException { 
	final int NB_PROD = 20; 
	int tabNoProd[] = new int[NB_PROD]; // = { 234, 125, 657, 987, 213, 934, 678, 776} 
	double tabPrixProd[] = new double[NB_PROD]; // = {45.99,9.50,5.75,12.35,9.75,87.45,56.99,76.56}
	int tabQteTotale[] = new int[NB_PROD];
	int nbProd;
	
	nbProd = batirTableau(tabNoProd, tabPrixProd, NB_PROD);
	System.out.println(tabNoProd);
	System.out.println(tabPrixProd);
	traiterLesClients(tabNoProd,tabPrixProd,tabQteTotale,nbProd);
	afficherResultats(tabNoProd,tabQteTotale,nbProd);
	
	System.exit(0); 
	} // fin de la m�thode main
}