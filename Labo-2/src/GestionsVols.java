import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class GestionsVols {
	static final String FICHIER_CIEAIRRELAX = "src/donnees/Cie Air Relax.txt";
	static ArrayList<Vol> tabVols;
	static BufferedReader tmpVolRead;
	static BufferedWriter tmpVolWrite;
	static JTextArea output;
	public final static int MAX_PLACES = 340;

	public static void afficherMessage(String msg){
		JOptionPane.showMessageDialog(null, msg, "MESSAGES", JOptionPane.PLAIN_MESSAGE);
	}

	public static void chargerVols() throws Exception {
		try {
			String ligne;
			tabVols = new ArrayList<Vol>();
			tmpVolRead = new BufferedReader(new FileReader(FICHIER_CIEAIRRELAX));
			ligne = tmpVolRead.readLine();//Lire la premiÃ©re ligne du fichier
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
			System.out.println("Fichier introuvable. VÃ©rifiez le chemin et nom du fichier.");
		}
		catch (IOException e) {
			System.out.println("Un problÃ©me est arrivÃ© lors de la manipulation du fichier. Vï¿½rifiez vos donnÃ©es.");
		}catch (Exception e) { 
			System.out.println("Un problÃ©me est arrivÃ© lors du chargement du fichier. Contactez l'administrateur.");
		}finally {//ExÃ©cutÃ© si erreur ou pas
			tmpVolRead.close();
		}
	}
	
	public static void insererVol() {
		int numVol = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Entrez le numéro du vol", "Saisie du numéro de vol", JOptionPane.PLAIN_MESSAGE));
		tabVols.forEach((vol ->{
		if(numVol == vol.getNumVol()) {
			if(vol.getNbPassager() >= MAX_PLACES) {
				output.append("Ce vol est malheureusement ");
			}
		}else {
		String destination = JOptionPane.showInputDialog(null, "Entrez la destination", "Saisie de destination",JOptionPane.PLAIN_MESSAGE);
		int jour = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Entrez le numéro du vol", "Saisie du jour de depart", JOptionPane.PLAIN_MESSAGE));
		int mois = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Entrez le numéro du vol", "Saisie du mois de depart", JOptionPane.PLAIN_MESSAGE));
		int annee = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Entrez le numéro du vol", "Saisie de l'année de depart", JOptionPane.PLAIN_MESSAGE));
		int nbClient = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre de personnes pour qui vous reservez", "Saisie du nombre de clients", JOptionPane.PLAIN_MESSAGE));
		int nbPassager = vol.getNbPassager() +nbClient;
		Vol newVol = new Vol();
		tabVols.ensureCapacity(tabVols.size() +1);
		}
		}));
	}
	
	public static Vol rechercherVol(int numVol) {
		Vol tmpVol = new Vol();
		tmpVol.setNumVol(numVol);
		tabVols.forEach( (vol) ->{
			tmpVol.setNumVol(numVol);
			if(tmpVol.getNumVol() == tmpVol.getNumVol()) {
					int pos = tabVols.indexOf(vol);// -1 si pas trouvï¿½
					if (pos == -1){
						afficherMessage("La radio est introuvable.");
					}else {
					//TODO
				}
			}
		});
		
		
		
		return tmpVol;
	}
	
	/* 
	I am trying to get 3 %s's(%1$s, %2$s, %3$s) where length of %1$s is equal to %3$s - %2$s. 
	Inspired by: 
	"System.out.printf("Hello, %s!", "reader");" found @ (https://stackabuse.com/how-to-format-a-string-in-java-with-examples/)
	*/
	public void formatLine() {
		String line = tabVols.get(1).getDestination();
	String.format("%1$s%2$s%3$s", "(MAX_SPACE - line.length)",line,"MAX_SPACE"); 
	}
	public static void main(String[] args) throws Exception {
		chargerVols();
		rechercherVol(14567);
		System.out.println(tabVols);

	}

}
