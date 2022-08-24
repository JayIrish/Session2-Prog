import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;

public class TestVol {

	static final String FICHIER_VOL_TEXTE = "src/CieAirRelax.txt";
	static final String FICHIER_VOL_OBJ = "src/CieAirRelax.obj";
	static String ligne="";
	public static final int MAX_PLACES = 340;
	public static final String CIE = "Cie Air Relax";
	public static final String[] TITRES = {"Liste des vols", "Ajout d'un vol", "Retrait d'un vol", "Modification de la date de départ", "Réservation d'un vol", 
										   "Terminer"};
	public static final String[] TYPE_VOL = {"Régulier", "À Bas Prix", "Charter", "Privé"};
	public static HashMap<Integer, Vol> listeVol = new HashMap<>();
	public static String optionChoisie;
	public static JTextArea sortie = new JTextArea(10, 30);
	public static String regex = "-?[0-9]+";
	
/*-------------------------------------------------------------- FONCTION DE DéPART -----------------------------------------------------------------------------*/
	
	@SuppressWarnings("unchecked")
	public static void chargerVols() throws IOException, FileNotFoundException
	{ 	
		try {
			File f = new File(FICHIER_VOL_OBJ);
			if (f.exists()) {
				listeVol = (HashMap<Integer, Vol>) Utilitaires.chargerFichierObjets(FICHIER_VOL_OBJ);
			}else {
				String ligne;
				BufferedReader fichier = new BufferedReader(new FileReader(FICHIER_VOL_TEXTE));
				
				// lit une ligne du fichier
				ligne = fichier.readLine();
				String[] elems = new String[15];
				
				while (ligne != null) 
				{	
					elems = ligne.split(";");
					String typeVol = elems[0];
					int noVol = Integer.parseInt(elems[1]);
					Date date = new Date(Integer.parseInt(elems[3]),Integer.parseInt(elems[4]),Integer.parseInt(elems[5]));
					Avion avion = new Avion(elems[7], Integer.parseInt(elems[8]), elems[9], elems[10]);
					
					if(typeVol.equalsIgnoreCase("R")){
						listeVol.put(noVol, new VolRegulier(noVol, elems[2], date, Integer.parseInt(elems[6]), avion, Boolean.parseBoolean(elems[11]),
								Boolean.parseBoolean(elems[12]), Boolean.parseBoolean(elems[13])));
					} else if(typeVol.equalsIgnoreCase("B")){
						listeVol.put(noVol, new VolBasPrix(noVol, elems[2], date, Integer.parseInt(elems[6]), avion, Boolean.parseBoolean(elems[11]),
								Boolean.parseBoolean(elems[12])));
					}else if(typeVol.equalsIgnoreCase("C")){
						listeVol.put(noVol, new VolCharter(noVol, elems[2], date, Integer.parseInt(elems[6]), avion, Boolean.parseBoolean(elems[11]),
								Boolean.parseBoolean(elems[12])));
					}else if(typeVol.equalsIgnoreCase("P")){
						listeVol.put(noVol, new VolPrivee(noVol, elems[2], date, Integer.parseInt(elems[6]), avion, Boolean.parseBoolean(elems[11]),
								Boolean.parseBoolean(elems[12]), Boolean.parseBoolean(elems[13]), Boolean.parseBoolean(elems[14])));
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
	{ // utilise le tableau de string TITRES pour générer un menu avec itération et retourne le message du menu
		String message = "                   GESTION DES VOLS\n";
		
		for (int i=0 ; i < TITRES.length-1; i++)
			{message += (i+1) + ". " + TITRES[i] + "\n";}
		
		message += "0. " + TITRES[5] + "\n";
		message += "                    Faites votre choix : ";
		return message;
	}
	
		
/*--------------------------------------------------------------------------- MENU -------------------------------------------------------------------------------*/
	
	
	public static void menu() throws FileNotFoundException, IOException
	{
		String program = "on";
		String menu = getMenuMessage(); // générer le message à afficher dans le menu
		
		chargerVols(); // charger la liste de vol é partir du fichier texte
		
		do 
		{			
			String userInput = JOptionPane.showInputDialog(null, menu /*message generer en haut */, "CIE AIR RELAX", JOptionPane.PLAIN_MESSAGE);
						
			switch (userInput) 
			{
				case "1" : 
					optionChoisie = TITRES[0]; //Liste des vols
					afficherVols(); break;
				case "2" : 
					optionChoisie = TITRES[1]; //Ajout d'un vol
					insererVols(); break;
				case "3" : 
					optionChoisie = TITRES[2]; //Retrait d'un vol
					retirerVol(); break;
				case "4" : 
					optionChoisie = TITRES[3]; //Modification de la date de depart
					modifierDate(); break;
				case "5" : 
					optionChoisie = TITRES[4]; //Reservation d'un vol
					reserverVol(); break;
				case "0" :                     //Terminer
					optionChoisie = TITRES[5];
					terminer();
				default : 
					JOptionPane.showMessageDialog(null, "Vous devez entrer un chiffre entre 0 et 5!", "CHOIX ERRONé", JOptionPane.PLAIN_MESSAGE); break;
			}
		} while (program == "on");
	}
	
	/*---------------------------------------------------------- MéTHODE MENU---------------------------------------------------------------------------------*/
	
	
	/*OPTION 1 --------------------------------*/
	
		public static int nbVols;
	
		public static void afficherEntete(String suiteEntete, String typeVol) {
			sortie.setFont(new Font("monospace", Font.PLAIN, 12));
			sortie.setEditable(false);
			sortie.append("\n\n\t\t\t\t\tLISTE DES VOLS " + typeVol +" \n\n");
			sortie.append("Type\t Numéro\t Destination\t\t\t Date\t Réservation\t Type Avion\t ");
			sortie.append(suiteEntete);
		}
	
	
		public static void listerVolRegulier() {
			nbVols=0;
			Vol unVol;
			
			afficherEntete("Repas\t Rés. Siège\t Divertissement \n\n", "RÉGULIERS");
			for (Integer numVol : listeVol.keySet()) {
				unVol = listeVol.get(numVol);
				VolRegulier unVolRegulier;
				if (unVol instanceof VolRegulier) {
					unVolRegulier = (VolRegulier) unVol;
					sortie.append(unVolRegulier.toString());
					nbVols++;
				}
			}
			sortie.append("\nNombre de vols = " + nbVols + "\n\n");
		}
	
		public static void listerVolBasPrix() {
			nbVols=0;
			Vol unVol;
			
			afficherEntete("Rés. Siège\t Services Payants \n\n", "À BAS PRIS");
			for (Integer numVol : listeVol.keySet()) {
				unVol = listeVol.get(numVol);
				VolBasPrix unVolBasPrix;
				if (unVol instanceof VolBasPrix) {
					unVolBasPrix = (VolBasPrix) unVol;
					sortie.append(unVolBasPrix.toString());
					nbVols++;
				}
			}
			sortie.append("\nNombre de vols = " + nbVols + "\n\n");
		}
		
		public static void listerVolCharter() {
			nbVols=0;
			Vol unVol;
			afficherEntete("Bar\t Divertissement \n\n", "CHARTERS");
			for (Integer numVol : listeVol.keySet()) {
				unVol = listeVol.get(numVol);
				VolCharter unVolCharter;
				if (unVol instanceof VolCharter) {
					unVolCharter = (VolCharter) unVol;
					sortie.append(unVolCharter.toString());
					nbVols++;
				}
			}
			sortie.append("\nNombre de vols = " + nbVols + "\n\n");
		}
		
		public static void listerVolPrivee() {
			nbVols=0;
			Vol unVol;
			afficherEntete("Repas\t Bar\t Divertissement\t\t Wifi \n\n", "PRIVÉS");
			for (Integer numVol : listeVol.keySet()) {
				unVol = listeVol.get(numVol);
				VolPrivee unVolPrivee;
				if (unVol instanceof VolPrivee) {
					unVolPrivee = (VolPrivee) unVol;
					sortie.append(unVolPrivee.toString());
					nbVols++;
				}
			}
			sortie.append("\nNombre de vols = " + nbVols + "\n\n");
		}
	
		public static void afficherTous() {
			listerVolRegulier();
			listerVolBasPrix();
			listerVolCharter();
			listerVolPrivee();
		}
		
		public static String getMenuChoixVol()
		{ // utilise le tableau de string TITRES pour générer un menu avec itération et retourne le message du menu
			String message = "                   Choisissez le type de vols \n";
			
			for (int i=0 ; i < TYPE_VOL.length; i++)
				{message += (i+1) + ". " + TYPE_VOL[i] + "\n";}
			
			return message;
		}
	
	private static void afficherVols() 
	{ 
		String menuChoix = getMenuChoixVol();
		menuChoix += "5. Tous\n";
		menuChoix += "                    Faites votre choix : ";
		String userInput = JOptionPane.showInputDialog(null, menuChoix /*message generer en haut */, "AFFICHER UN VOL", JOptionPane.PLAIN_MESSAGE);
		sortie.setText("");
		switch (userInput) 
		{
			case "1" : 
				listerVolRegulier();
				JOptionPane.showMessageDialog(null, sortie, CIE, JOptionPane.PLAIN_MESSAGE);
				break;
			case "2" : 
				listerVolBasPrix();
				JOptionPane.showMessageDialog(null, sortie, CIE, JOptionPane.PLAIN_MESSAGE);
				break;
			case "3" : 
				listerVolCharter();
				JOptionPane.showMessageDialog(null, sortie, CIE, JOptionPane.PLAIN_MESSAGE);
				break;
			case "4" : 
				listerVolPrivee();
				JOptionPane.showMessageDialog(null, sortie, CIE, JOptionPane.PLAIN_MESSAGE);
				break;
			case "5" :
				afficherTous(); 
				JOptionPane.showMessageDialog(null, sortie, CIE, JOptionPane.PLAIN_MESSAGE);
				break;
			default : 
				JOptionPane.showMessageDialog(null, "Vous devez entrer un chiffre entre 1 et 5!", "CHOIX ERRONé", JOptionPane.PLAIN_MESSAGE); break;
		}
	}
	
	
	/*OPTION 2 ---------------------------------*/
	
	public static void insererVols() {
		String[] listeAttribut = {"Destination", "Jour", "Mois", "Année", "Nb res", "Type Avion", "Repas : 1-OUI, 2- NON", "Réservation de siège : 1-OUI, 2- NON" ,
								  "Divertissement : 1-OUI, 2- NON ","Services payants : 1-OUI, 2- NON ", "bar : 1-OUI, 2- NON", "Wifi : 1-OUI, 2- NON"};
		int[] indexR= {0,1,2,3,4,5,6,7,8};
		int[] indexB= {0,1,2,3,4,5,7,9};
		int[] indexC= {0,1,2,3,4,5,8,10};
		int[] indexP= {0,1,2,3,4,5,6,8,10,11};
		
		// créer un objet vol et date par défault sans aucune valeurs au niveau des attribut
		Date date = new Date();
		Avion avion = new Avion();
		
		String menuChoix = getMenuChoixVol();
		String userInput = JOptionPane.showInputDialog(null, menuChoix /*message generer en haut */, "AFFICHER UN VOL", JOptionPane.PLAIN_MESSAGE);
		
		switch (userInput) {
			case "1" : 
				VolRegulier volR = new VolRegulier(); 
				configurerVol(listeAttribut, volR, date, avion, indexR);
				break;
			case "2" : 
				VolBasPrix volB = new VolBasPrix(); 
				configurerVol(listeAttribut, volB, date, avion, indexB);
				break;
			case "3" : 
				VolCharter volC = new VolCharter(); 
				configurerVol(listeAttribut, volC, date,avion, indexC);
				break;
			case "4" : 
				VolPrivee volP = new VolPrivee(); 
				configurerVol(listeAttribut, volP, date, avion, indexP);
				break;
			default : JOptionPane.showMessageDialog(null, "Vous devez entrer un chiffre entre 1 et 4!", "CHOIX ERRONé", JOptionPane.PLAIN_MESSAGE); break;
		}
		
	}
	
	
	private static void configurerVol(String[] attributs, Vol vol, Date date, Avion avion, int[] index) 
	{ 
			
		int noVol = verifierNoVol();
		Boolean present = listeVol.containsKey(noVol);
		
		if (present) {
			JOptionPane.showMessageDialog(null, "Le numéro de vol entré existe déjà .", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			vol.setNoVol(noVol);
			
			for (int i = 0; i < index.length; i++) {
				int a = index[i];
				
				String input = "need_Convert";
				
				do  // demande à l'utilisateur d'entrer une valeur, au besoin convertir en int puis passe au prochain attribut (next)
				{
					if (attributs[a].equals("Destination"))// configure la destination de mon vol, next
						{vol.setDestination(JOptionPane.showInputDialog(null, attributs[a], optionChoisie.toUpperCase(), 
								JOptionPane.PLAIN_MESSAGE));
						input = "NO_need_Convert";}
					
					else if (attributs[a].equals("Type Avion"))// configure la destination de mon vol, next
						{avion.setTypeAvion((JOptionPane.showInputDialog(null, attributs[a], optionChoisie.toUpperCase(), 
								JOptionPane.PLAIN_MESSAGE)));
						input = "NO_need_Convert";}
					
					else	// Tous les attribut devant étre convertit en Int
					{
						try  
						{
							//essaie de convertir l'entrée utilisateur et lance une exception si impossible de convertir
							int userInput = Integer.parseInt(JOptionPane.showInputDialog(null, attributs[a], optionChoisie.toUpperCase(), 
									JOptionPane.PLAIN_MESSAGE));
							//trouve de quel attribut il s'agit avec l'index de la liste
							// refere a une méthode dans la classe vol et date qui indique quel attribut modifier en fonction de l'index 
							vol.modifierVol(a, userInput); 
							date.modifierDate(a, userInput);
							input = "is_Convert";
						} catch (IllegalArgumentException s ) {
								String message = s.getMessage();
								JOptionPane.showMessageDialog(null, message, optionChoisie.toUpperCase(), 
										JOptionPane.ERROR_MESSAGE);
						} catch (Exception e) 	
							{JOptionPane.showMessageDialog(null, "Erreur de traitement", 
									optionChoisie.toUpperCase(), JOptionPane.ERROR_MESSAGE);
						}
					}
				} while (input == "need_Convert"); 
			}
			
		}
		vol.setDate(date);
		vol.setTypeAvion(avion);
		listeVol.put(noVol, vol);
	}
	
	
	
	/*OPTION 3 ---------------------------------*/
	
	public static void retirerVol() throws IOException
	{  
		String messRetrait = "Désirez-vous vraiment retirer ce vol : \n";
		int noVolUser,
			repUser;
		
		// Demande un noVol à un user, convertir en int, verifie s'il existe déjà 
		noVolUser = verifierNoVol();
		Boolean present = listeVol.containsKey(noVolUser);
		
		if (!present) {
			JOptionPane.showMessageDialog(null, "Le numéro de vol entré n'existe pas.", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
		}
		else			
		{ // trouve l'index de l'objet vol dans ma liste 
			messRetrait += listeVol.get(noVolUser);
			// Demande é l'user s'il veut vraiment supprimer le vol
			repUser = JOptionPane.showConfirmDialog(null, messRetrait, optionChoisie.toUpperCase(), JOptionPane.YES_NO_OPTION);
			
			if (repUser == JOptionPane.NO_OPTION)
				{JOptionPane.showMessageDialog(null, "Opération annulée", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);}
			
			else if (repUser == JOptionPane.YES_OPTION)
			{ 
				listeVol.remove(noVolUser);
				JOptionPane.showMessageDialog(null, "Le numéro de vol a été retiré", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
			}
			else // repUser == JOptionPane.CLOSED_OPTION
				{terminer();}
		 }
	}
	
	
	/*OPTION 4 ---------------------------------*/
	
	public static void modifierDate() throws IOException 
	{
		String messRetrait = "Désirez-vous vraiment modifier la date du vol suivant : \n",
			   dateUser;
		String[] partie;
		int noVolUser,
			repUser;
		Date date;
		
		// Demande un noVol é un user, convertir en int, verifie s'il existe déjé
		noVolUser = verifierNoVol();
		Boolean present = listeVol.containsKey(noVolUser);
		
		if (!present) {
			JOptionPane.showMessageDialog(null, "Le numéro de vol entré n'existe pas.", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
		}
		else		
		{ // trouve l'index de l'objet vol dans ma liste
			messRetrait += listeVol.get(noVolUser);
			System.out.println(messRetrait);
			// Demande é l'user s'il veut vraiment modifier la date
			repUser = JOptionPane.showConfirmDialog(null, messRetrait, optionChoisie.toUpperCase(), JOptionPane.YES_NO_OPTION);
			
			if (repUser == JOptionPane.YES_OPTION)
			{	// demande au user la nouvelle date
				dateUser = JOptionPane.showInputDialog(null, "Entrez la nouvelle date sous cette forme JJ/MM/AAAA", 
						optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
				
				// split le string pour garder seulement les nombres
				partie = dateUser.split("/");
				
				//convertir les nombre en int et crée un nouvel objet date
				date = new Date(Integer.parseInt(partie[0]), Integer.parseInt(partie[1]), Integer.parseInt(partie[2]));
				
				// modifier la date du vol choisi
				listeVol.get(noVolUser).setDate(date);
				JOptionPane.showMessageDialog(null, "La date a été modifiée", 
						optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
			}
			else if (repUser == JOptionPane.NO_OPTION)
				{JOptionPane.showMessageDialog(null, "Opération annulée", 
						optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);}
			else
				{terminer();}
		}
	}
	
	
	/*OPTION 5 ---------------------------------*/	
	
	public static void reserverVol()
	{		
		// Demande un noVol é un user, convertir en int, verifie s'il existe déjé
		int noVolUser = verifierNoVol();
		Boolean present = listeVol.containsKey(noVolUser);
		
		if (present) 
			{verifierPlacesRestantes(noVolUser);}
		else // noVol n'existe pas
			{JOptionPane.showMessageDialog(null, "Le numéro de vol entré n'existe pas.", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);}
	}
	
	
	private static void verifierPlacesRestantes(int noVol) 
	{
		// trouve l'index du vol avec le noVol en paramétre
		String message = "";
		
		// si vol déja complet
		if (listeVol.get(noVol).getNbRes() >= MAX_PLACES)
			{JOptionPane.showMessageDialog(null, "Ce vol est complet", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);}
		else // si pas complet, indique le nb de places restantes et demande combien il en veut
		{ 	 
			 int placeRestantes = (MAX_PLACES - listeVol.get(noVol).getNbRes());
			 
			 message += listeVol.get(noVol).getDestination() + "   " + listeVol.get(noVol).getDate() + 
					 "\nNombre de places restantes : " + placeRestantes +
					 "\n\nCombien de places désirez-vous réserver : ";
			 int resUser = Integer.parseInt(JOptionPane.showInputDialog(null, message, optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE));
			 if (resUser > placeRestantes)
			 	{JOptionPane.showMessageDialog(null, "Vous ne pouvez pas réserver un nombre de place supérieure "
			 								  + "au nombre de places restantes", optionChoisie.toUpperCase(), 
			 								  JOptionPane.PLAIN_MESSAGE);}
			 else {
			 listeVol.get(noVol).setNbRes(listeVol.get(noVol).getNbRes() + resUser);
			 JOptionPane.showMessageDialog(null, "Réservation effectuée", optionChoisie.toUpperCase(), 
					  JOptionPane.PLAIN_MESSAGE);}
		}
	}
	
	
	/*OPTION 0 ---------------------------------*/	
		
	public static void terminer() throws IOException 
	{
	Utilitaires.sauvegarderFichierObjets(listeVol, FICHIER_VOL_OBJ); 
	JOptionPane.showMessageDialog(null, "Au revoir!", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
	System.exit(0);		
	}
	
	
	/*----------------------------------------FONCTIONS UTILITAIRES----------------------------------------------------------*/
	

	private static int verifierNoVol()
	{
		String noVol,
			   entry = "string";
		do 
		{
			noVol = JOptionPane.showInputDialog(null, "Numéro de vol", optionChoisie.toUpperCase(), JOptionPane.PLAIN_MESSAGE);
			
			if (noVol.matches(regex)) 
				{entry = "number";}
			else 
				{JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre!",
						optionChoisie.toUpperCase(), JOptionPane.ERROR_MESSAGE);}
		} while (entry.equals("string"));	
		
		return Integer.parseInt(noVol);
	}
	
	
	/*----------------------------------------------- MAIN -------------------------------------------------------------*/
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		menu();
	

	
	
			
	}

}
