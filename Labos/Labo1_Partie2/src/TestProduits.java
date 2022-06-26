import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TestProduits {
	
	static void traiterLesClients(int tabNoProd[], double tabPrix[], int tabQteTotale[], int nbProd) { 
		DecimalFormat cash = new DecimalFormat("0.00 $"); 
		int numero, qte, posiProd; // position du num�ro dans le tableau tabNoProd 
		double cout; 
		char reponse;
		do { 
				numero = Integer.parseInt(JOptionPane.showInputDialog( "Entrez le numero du produit a acheter :")); 
				qte = Integer.parseInt(JOptionPane.showInputDialog( "Entrez la quantite desiree :"));
				
				posiProd = rechercher(tabNoProd, nbProd, numero);
				
				if (posiProd != -1) {
					tabQteTotale[posiProd] += qte;
					cout = tabPrix[posiProd] * qte;
					JOptionPane.showMessageDialog(null, "Le cout de cet achat est de " + cash.format(cout)); 
				} else {
					JOptionPane.showMessageDialog(null, "No de produit errone");
				}
			   reponse = JOptionPane.showInputDialog( "Avez-vous un autre client a traiter O/N ?").charAt(0); 
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
	} // fin de la methode rechercher
	
	static void afficherResultats(int tabNoProd[], int tabQteTotale[], int nbProd) {
		JTextArea sortie = new JTextArea();
		sortie.setEditable(false);
		sortie.append("\tNumero\tQuantite\n");
		sortie.append("\tproduit\ttotale\n\n");
		for(int i = 0; i < nbProd; i++) {
			sortie.append("\t"+tabNoProd[i]+"\t"+tabQteTotale[i]+"\n");
		}
		JOptionPane.showMessageDialog(null, sortie,"RESULTATS DE LA JOURNEE" , JOptionPane.PLAIN_MESSAGE);
	} // fin de la m�thode afficherResultats } // fin de la classe
	
		
	 static int batirTableaux(int tabNoProd[], double tabPrixProd[] , int tailleTableaux) throws IOException {
		 
		 final String FICHIER_PRODUITS = "src/données/produits.txt";
		 BufferedReader ficProd = new BufferedReader(new FileReader(FICHIER_PRODUITS));
		 int i = 0;
		 String ligne;
		 String elems[];
		 ligne = ficProd.readLine();
		 while(i < tailleTableaux && ligne != null) {
			 elems = ligne.split(";");
			 tabNoProd[i] = Integer.parseInt(elems[0]);
			 tabPrixProd[i] = Double.parseDouble(elems[1]);
			 ++i;//i=i+1;
			 ligne = ficProd.readLine();
		 }
		 ficProd.close();
		 return i;
	 }

	public static void main(String[] args) throws Exception {
		final int NB_PROD = 20; 
		int tabNoProd[] =  new int[NB_PROD];
		double tabPrixProd[] = new double[NB_PROD];
		int tabQteTotale[] = new int[NB_PROD];
		int nbProd;
		
		nbProd = batirTableaux(tabNoProd, tabPrixProd, NB_PROD);
		
		traiterLesClients(tabNoProd, tabPrixProd, tabQteTotale, nbProd);
		afficherResultats( tabNoProd, tabQteTotale, nbProd); 
		System.exit(0);
		
	}

}
