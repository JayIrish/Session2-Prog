import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GestionEmission {
	
	static final String FICHIER_EMISSIONS_TEXTE = "src/donnees/emissions.txt";
	static final String FICHIER_EMISSIONS_OBJ = "src/donnees/emissions.obj";
	static Map<Integer, Emission> tvHebdo = new HashMap<>();
	static BufferedReader tmpEmmissionsReader;
	static ObjectInputStream tmpEmmissionsReadObj;
	static ObjectOutputStream tmpEmmissionsWriteObj;
	static JTextArea sortie = new JTextArea(10, 30);
	public static String optionChoisie;
	public static String regex = "-?[0-9]+";
	public static final String[] TITRES = {"Afficher des emissions", "Afficher les films d'un realisateur", "Supprimer une émission", "Terminer"};
	public static final String[] TYPE_EMISSION = {"Tous", "Fiction", "Reportage"};

	@SuppressWarnings("unchecked")
	public static void chargerEmissions() throws IOException, FileNotFoundException
	{ 	
		try {
			File f = new File(FICHIER_EMISSIONS_OBJ);
			if (f.exists()) {
				tvHebdo = (HashMap<Integer, Emission>) Utilitaires.chargerFichierObjets(FICHIER_EMISSIONS_OBJ);
			}else {
				String ligne;
				BufferedReader fichier = new BufferedReader(new FileReader(FICHIER_EMISSIONS_TEXTE));
				
				// lit une ligne du fichier
				ligne = fichier.readLine();
				String[] elems = new String[8];
				
				while (ligne != null) 
				{	
					elems = ligne.split(";");
					String typeEmission = elems[0];
					int idEmission = Integer.parseInt(elems[1]);
					String  nomEmission = elems[2];
					int heureDeb = Integer.parseInt(elems[3]);
					int heureFin = Integer.parseInt(elems[4]);
					
					if(typeEmission.equalsIgnoreCase("F")){
						String titre = elems[5];
						int année = Integer.parseInt(elems[6]);
						String réalisateur = elems[7];
						Boolean rediffusion = Boolean.parseBoolean(elems[8]);
						tvHebdo.put(idEmission, new Fiction(idEmission, nomEmission, heureDeb, heureFin, titre, année,
								réalisateur, rediffusion ));
					} else if(typeEmission.equalsIgnoreCase("R")){
						String sujet = elems[5];
						String présentateur = elems[6];
						tvHebdo.put(idEmission, new Reportage(idEmission, nomEmission, heureDeb, heureFin, sujet, présentateur));
					}
					ligne = fichier.readLine();
				}		
				fichier.close();
				}
				}catch(Exception e) {
					System.out.println("Une erreure s'est produite lors du chargement du fichier");
				}
		
	}
	
	public static String getMenuMessage()
	{ // utilise le tableau de string TITRES pour g�n�rer un menu avec it�ration et retourne le message du menu
		String message = "                   Votre TV Hebdo\n";
		
		for (int i=0 ; i < TITRES.length-1; i++)
			{message += (i+1) + ". " + TITRES[i] + "\n";}
		message += "0. " + TITRES[3] + "\n";
		message += "                    Faites votre choix : ";
		return message;
	}
	
	public static void menu() throws FileNotFoundException, IOException
	{
		String program = "on";
		String menu = getMenuMessage(); // g�n�rer le message � afficher dans le menu
		
		chargerEmissions(); 
		
		do 
		{			
			String userInput = JOptionPane.showInputDialog(null, menu /*message generer en haut */, "TV Hebdo", JOptionPane.PLAIN_MESSAGE);
						
			switch (userInput) 
			{
				case "1" : 
					optionChoisie = TITRES[0]; //Liste des vols
					afficherEmissions(); break;
				case "2" : 
					optionChoisie = TITRES[1]; //Ajout d'un vol
					afficherRealisateur(); break;
				case "3" : 
					optionChoisie = TITRES[2]; //Retrait d'un vol
					retirerEmission(); break;
				case "0" :                     //Terminer
					optionChoisie = TITRES[3];
					terminer();
				default : 
					JOptionPane.showMessageDialog(null, "Vous devez entrer un chiffre entre 0 et 3!", "CHOIX ERRONÉ", JOptionPane.PLAIN_MESSAGE); break;
			}
		} while (program == "on");
	}
	
	public static void afficherEntete(String suiteEntete, String typeEmission) {
		sortie.setFont(new Font("monospace", Font.PLAIN, 12));
		sortie.setEditable(false);
		sortie.append("\n\n\t\t\t\t\tLISTE DES " + typeEmission +" \n\n");
		sortie.append("Identifiant\t Émission\t\t Début\t Fin\t ");
		sortie.append(suiteEntete);
	}
	
	
	public static void listerFiction() {
		Emission unEmission;
		
		afficherEntete("Titre\t\t Année\t Réalisateur\t\t Rediffusion\n\n", "FICTIONS");
		for (Integer idEmission : tvHebdo.keySet()) {
			unEmission = tvHebdo.get(idEmission);
			Fiction unFiction;
			if (unEmission instanceof Fiction) {
				unFiction = (Fiction) unEmission;
				sortie.append(unFiction.toString());
			}
		}
	}

	public static void listerReportage() {
		Emission unEmission;
		
		afficherEntete("Sujet\t Présentateur\n\n", "REPORTAGES");
		for (Integer idEmission : tvHebdo.keySet()) {
			unEmission = tvHebdo.get(idEmission);
			Reportage unReportage;
			if (unEmission instanceof Reportage) {
				unReportage = (Reportage) unEmission;
				sortie.append(unReportage.toString());
			}
		}
	}
	
	public static void afficherRealisateur() {
		sortie.setText("");
		String liste = "non";
		Emission unEmission;
		String realisateur = JOptionPane.showInputDialog(null, "Entrez le nom du réalisateur désiré: ", "TV Hebdo", JOptionPane.PLAIN_MESSAGE); 
		afficherEntete("Titre\t\t Année\t Réalisateur\t\t Rediffusion\n\n", "FILMS PAR " + realisateur.toUpperCase());
		for (Integer idEmission : tvHebdo.keySet()) {
			unEmission = tvHebdo.get(idEmission);
			Fiction uneFiction;
			if (unEmission instanceof Fiction) {
				uneFiction = (Fiction) unEmission;
				if(uneFiction.getNomRealisateur().equalsIgnoreCase(realisateur)) {
					sortie.append(uneFiction.toString());
					liste = "oui";
				}
			}
		}
		
		if(liste != "non") {
			JOptionPane.showMessageDialog(null, sortie, "TV Hebdo", JOptionPane.PLAIN_MESSAGE);
		}else {
				JOptionPane.showMessageDialog(null, "Le réalisateur entré n'existe pas.", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
			}
	}
	
	public static void listerTous() {
		listerFiction();
		listerReportage();
	}
	
	
	public static String getMenuChoixEmission()
	{ // utilise le tableau de string TITRES pour g�n�rer un menu avec it�ration et retourne le message du menu
		String message = "                   Choisissez le type de vols \n";
		
		for (int i=0 ; i < TYPE_EMISSION.length; i++)
			{message += (i+1) + ". " + TYPE_EMISSION[i] + "\n";}
		
		return message;
	}
	
	private static void afficherEmissions() 
	{ 
		String menuChoix = getMenuChoixEmission();
		menuChoix += "                    Faites votre choix : ";
		String userInput = JOptionPane.showInputDialog(null, menuChoix /*message generer en haut */, "AFFICHER UNE ÉMISSION", JOptionPane.PLAIN_MESSAGE);
		sortie.setText("");
		switch (userInput) 
		{
			case "1" : 
				listerTous();
				JOptionPane.showMessageDialog(null, sortie, "TV Hebdo", JOptionPane.PLAIN_MESSAGE);
				break;
			case "2" : 
				listerFiction();
				JOptionPane.showMessageDialog(null, sortie, "TV Hebdo", JOptionPane.PLAIN_MESSAGE);
				break;
			case "3" : 
				listerReportage();
				JOptionPane.showMessageDialog(null, sortie, "TV Hebdo", JOptionPane.PLAIN_MESSAGE);
				break;
			default : 
				JOptionPane.showMessageDialog(null, "Vous devez entrer un chiffre entre 1 et 3!", "CHOIX ERRONÉ", JOptionPane.PLAIN_MESSAGE); break;
		}
	}
	
	public static void retirerEmission() throws IOException
	{  
		String messRetrait = "Désirez-vous vraiment retirer l'émission : \n";
		int idEmissionUser,
			repUser;
		
		// Demande un noVol � un user, convertir en int, verifie s'il existe d�j� 
		idEmissionUser = verifierIdEmission();
		Boolean present = tvHebdo.containsKey(idEmissionUser);
		
		if (!present) {
			JOptionPane.showMessageDialog(null, "L'émission entré n'existe pas.", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
		}
		else			
		{ // trouve l'index de l'objet vol dans ma liste 
			messRetrait += tvHebdo.get(idEmissionUser);
			// Demande � l'user s'il veut vraiment supprimer le vol
			repUser = JOptionPane.showConfirmDialog(null, messRetrait, optionChoisie.toUpperCase(), JOptionPane.YES_NO_OPTION);
			
			if (repUser == JOptionPane.NO_OPTION)
				{JOptionPane.showMessageDialog(null, "Opération annulée", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);}
			
			else if (repUser == JOptionPane.YES_OPTION)
			{ 
				tvHebdo.remove(idEmissionUser);
				JOptionPane.showMessageDialog(null, "L'émission a été retiré", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
			}
			else // repUser == JOptionPane.CLOSED_OPTION
				{terminer();}
		 }
	}
	
	private static int verifierIdEmission()
	{
		String idEmission,
			   entry = "string";
		do 
		{
			idEmission = JOptionPane.showInputDialog(null, "Identifiant d'émission a suprimer", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
			
			if (idEmission.matches(regex)) 
				{entry = "number";}
			else 
				{JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre!",
						optionChoisie.toUpperCase(), JOptionPane.ERROR_MESSAGE);}
		} while (entry.equals("string"));	
		
		return Integer.parseInt(idEmission);
	}
	
	
	public static void terminer() throws IOException 
	{
	Utilitaires.sauvegarderFichierObjets(tvHebdo, FICHIER_EMISSIONS_OBJ); 
	JOptionPane.showMessageDialog(null, "Au revoir!", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
	System.exit(0);		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		menu();

	}

}
