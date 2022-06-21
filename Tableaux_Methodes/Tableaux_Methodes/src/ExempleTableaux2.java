import javax.swing.*;
import java.awt.Font;
public class ExempleTableaux2 {

	public static void main(String[] args) {
		

		String nom;
		int qte,i=0, nbClientsTraites;
		double prix,total=0;
		char continuer='O';

		String tabNoms[] = new String[10];
		
		double tabMontants[] = new double[10];

		JTextArea sortie = new JTextArea(10, 30);
		
		//Lire des donn�es des ventes
		while(continuer=='O'){
			nom=JOptionPane.showInputDialog(null, "Entrer le nom",
					"�cran de saisie du nom", JOptionPane.PLAIN_MESSAGE);

			qte=Integer.parseInt(JOptionPane.showInputDialog(null, "Entrer la quantit�",
					"�cran de saisie de la quantit�", JOptionPane.PLAIN_MESSAGE));
			
			prix=Double.parseDouble(JOptionPane.showInputDialog(null, "Entrer le prix",
					"�cran de saisie du prix", JOptionPane.PLAIN_MESSAGE));
			
		    
		   tabNoms[i]=nom;

		   tabMontants[i]=qte*prix;

		   	++i;
		   	
		    continuer=JOptionPane.showInputDialog(null, "Traiter un autre client (O/N) ?",
					"�cran de continuation", JOptionPane.PLAIN_MESSAGE).toUpperCase().charAt(0);
		}
		
		nbClientsTraites=i;
		//Calculer le total des achats
		 for(i=0;i<nbClientsTraites;i++){
			 total+=tabMontants[i];
		 }

		
		//Afficher les r�sultats
		sortie.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 14));
		sortie.append("\nNOM\t\tMONTANT");
	     
	   //Placer les r�sultats dans le JTextArea sortie
		for(i=0;i<nbClientsTraites;i++){
			sortie.append("\n\n"+tabNoms[i]+"\t\t"+String.format("%.2f",tabMontants[i])+"$");
		}
		
		sortie.append("\n\nTOTAL = "+String.format("%.2f",total)+"$");
		
		//Placer le JTextArea dans le JOptionPane.showMessageDialog
        JOptionPane.showMessageDialog(null, sortie,
         "LISTE DES ACHATS", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);

	}

}
