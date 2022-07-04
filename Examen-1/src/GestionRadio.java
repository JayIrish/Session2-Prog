/*Tes fonction, lorsque tu veuc comparer des String tu ne peux pas utiliser ==, les String sont des objets et avec == 
 * il compare les adresses et non pas le contenu. Faudra utiliser par exemple dans ton Oprion B : 
 * if(radio.getMake().tuUpperCase().equals(make.upperCase())

Donc utiliser la méthode equals de la classe String, dont celle-ci est dans un pdf dans LEA. T'aurais pu utiliser aussi sans passer 
par une conversion de case :
if(radio.getMake().equalsIgnoreCase(make)

Pour l'Option E il fallait écrire à la ligne 119 listeRadios.get(pos) et non pas set(pos). Tu veux obtenir l'objet à la position pos,
 donc get et modifier cet objet par le setMp3.

}else {
listeRadios.set(pos).setMp3(1);
}
 */

import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class GestionRadio {
	static final String FICHIER_RADIO = "src/donnees/Radio.txt";
	static ArrayList<Radio> listeRadios;
	static BufferedReader tmpRadioRead;
	static BufferedWriter tmpRadioWrite;
	static JTextArea output;
	static JTextArea outputMarque;
	
	public static int menuTop(){
		String contenu="1-Afficher inventaire\n2-Afficher par marque\n3-Modifier Prix\n4-Ajout inventaire\n5-Nouveau Sony\n6-Terminer\n\n";
		contenu+="Entrez votre choix parmis[1-6] : ";
		return Integer.parseInt(JOptionPane.showInputDialog(null, contenu, "MENU GESTION RADIO",JOptionPane.PLAIN_MESSAGE));
	}
	
	public static void showHeader(){
		output = new JTextArea();
		output.setFont(new Font("monospace", Font.PLAIN, 12));
		output.append("\t\tLISTE DES RADIOS\n\n");
		output.append("MARQUE\tMOD�LE\t CD   CASSETTE   MP3 \tPRIX\n");
	}
	
	public static void showHeaderMarque(){
		outputMarque = new JTextArea();
		outputMarque.setFont(new Font("monospace", Font.PLAIN, 12));
		outputMarque.append("\t\tLISTE DES RADIOS\n\n");
		outputMarque.append("MARQUE\tMOD�LE\t CD   CASSETTE   MP3 \tPRIX\n");
	}
	
	// A)
	public static void listerRadio() {
		showHeader();
		listeRadios.forEach((radio) -> {
			output.append(radio.toString());
		});
		JOptionPane.showMessageDialog(null, output, null, JOptionPane.PLAIN_MESSAGE);
	}
	
	// B)
	public static void listerRadiosParMarque() {
		outputMarque = new JTextArea();
		String make = (JOptionPane.showInputDialog(null, "Entrez la marque", "LISTER DES RADIOS PAR MARQUE", JOptionPane.PLAIN_MESSAGE));
		listeRadios.forEach((radio) -> {
			if(radio.getMake().equalsIgnoreCase(make)) {
			outputMarque.append(radio.toString());
			}else {;}
		});
		showHeaderMarque();
		JOptionPane.showMessageDialog(null, outputMarque, null, JOptionPane.PLAIN_MESSAGE);
		}
	
		/*
		
		
		listeRadios.forEach((radio) -> {
			if(radio.getMake() == make){
				outputMarque.append(radio.toString());
			}
		});	
		showHeader();
		JOptionPane.showMessageDialog(null, outputMarque, null, JOptionPane.PLAIN_MESSAGE);
	
	*/
		
		
	// C)
	public static void modifierPrixRadio() {
		
		listeRadios.forEach((radio) ->{
			double ogPrice = radio.getPrice();
			if(radio.getMake().equalsIgnoreCase("Sony")) {
				double newPrice = ogPrice*1.15;
				radio.setPrice(newPrice);
			}else if(radio.getMake().equalsIgnoreCase("Koss")){
				double newPrice = ogPrice + (ogPrice*-0.07);
				radio.setPrice(newPrice);
			}
		});
		listerRadio();
	}
	
	// D)
	public static void afficherMessage(String msg){
		JOptionPane.showMessageDialog(null, msg, "MESSAGES", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void ajouterRadio(){
		String make = JOptionPane.showInputDialog(null, "Entrez la marque", "AJOUTER UNE RADIO", JOptionPane.PLAIN_MESSAGE);
		String model = JOptionPane.showInputDialog(null, "Entrez le mod�le", "AJOUTER UNE RADIO", JOptionPane.PLAIN_MESSAGE);
		int cd = Integer.parseInt(JOptionPane.showInputDialog
				(null, "Entrez '1' si il y a fonctionalit� CD, sinon entrez '0'.", "AJOUTER UNE RADIO", JOptionPane.PLAIN_MESSAGE));
		int cassette = Integer.parseInt(JOptionPane.showInputDialog
				(null, "Entrez '1' si il y a fonctionalit� cassette, sinon entrez '0'.", "AJOUTER UNE RADIO", JOptionPane.PLAIN_MESSAGE));
		int mp3 = Integer.parseInt(JOptionPane.showInputDialog
				(null, "Entrez '1' si il y a fonctionalit�  MP3, sinon entrez '0'.", "AJOUTER UNE RADIO", JOptionPane.PLAIN_MESSAGE));
		double prix = Double.parseDouble(JOptionPane.showInputDialog
				(null, "Entrez le prix", "AJOUTER UNE RADIO", JOptionPane.PLAIN_MESSAGE));
		
		listeRadios.add(new Radio(make, model, cd, cassette, mp3, prix));
		listerRadio();
	}
	
	// E)
	public static Object chercherRadio() {
		int pos;
		Radio radioTmp = new Radio();
		radioTmp.setMake("Sony");
		radioTmp.setModel("WM823");
		pos = listeRadios.indexOf(radioTmp);// -1 si pas trouv�
		if (pos == -1){
			afficherMessage("La radio est introuvable.");
			return null;
		}else {
			listeRadios.get(pos).setMp3(1);
		}
		
		Radio radioTrouve = listeRadios.get(pos);
		return radioTrouve;
	}
	
		
	
	public static void chargerRadios() throws Exception {
		try {
			String ligne;
			String elems[] = new String[4];
			listeRadios = new ArrayList<Radio>();
			tmpRadioRead = new BufferedReader(new FileReader(FICHIER_RADIO));
			ligne = tmpRadioRead.readLine();
			while (ligne != null) {
				elems = ligne.split(";");
				listeRadios.add(new Radio(elems[0], elems[1], Integer.parseInt(elems[2]), Integer.parseInt(elems[3]), Integer.parseInt(elems[4]), Double.parseDouble(elems[5])));
				ligne = tmpRadioRead.readLine();
				}
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable. V�rifiez le chemin et nom du fichier.");
		}
		catch (IOException e) {
			System.out.println("Un probl�me est arriv� lors de la manipulation du fichier. V�rifiez vos donn�es.");
		}catch (Exception e) { 
			System.out.println("Un probl�me est arriv� lors du chargement du fichier. Contactez l'administrateur.");
		}finally {
			tmpRadioRead.close();
		}
	}
	

	public static void main(String[] args) throws Exception {
		int choix;
		chargerRadios();
		do {
			choix = menuTop();
			switch(choix){
				case 1 : 
					listerRadio();
					break;
				case 2 : 
					listerRadiosParMarque();
					break;
				case 3 : 
					modifierPrixRadio();
					break;
				case 4 : 
					ajouterRadio();
					break;
				case 5 : 
					chercherRadio();
					break;
				case 6 :
					afficherMessage("Merci d'avoir utilisé notre syst�me");
					break;
				default :
					afficherMessage("Choix invalide. Les option sont [1-6] !");
					break;
			}
		} while(choix != 6);
		

	}

}
