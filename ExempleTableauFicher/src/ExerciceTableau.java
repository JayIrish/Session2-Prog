import javax.swing.*; 
import java.text.*; 


public class ExerciceTableau{

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
	
	
	public static void main(String args[]) { 
	final int NB_PROD = 8; 
	int tabNoProd[] = { 234, 125, 657, 987, 213, 934, 678, 776}; 
	double tabPrixProd[] = {45.99,9.50,5.75,12.35,9.75,87.45,56.99,76.56};
	int tabQteTotale[] = new int[NB_PROD];
	
	traiterLesClients(tabNoProd,tabPrixProd,tabQteTotale,NB_PROD);
	afficherResultats(tabNoProd,tabQteTotale,NB_PROD); 
	System.exit(0); 
	} // fin de la m�thode main
}