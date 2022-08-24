import java.awt.Font;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GestionLivres {
	static final String FICHIER_LIVRES_TEXTE = "src/documents/livres.txt";
	static final String FICHIER_LIVRES_OBJ = "src/documents/livres.obj";
	
	static JTextArea sortieBrut;
	static int cptCategs = 0;
	static List<Livre> listeLivres = new ArrayList<Livre>();
	//static Map<Integer, Livre> biblioMap = new TreeMap<Integer, Livre>();
	static Map<Integer, Livre> biblioMap = new HashMap<Integer, Livre>();
	

	public static int menuGeneral() {
		String contenu = "1-Lister\n2-Lister par num�ro\n3-Rechercher un Livre par num�ro\n4-Recherche par auteur\n5-Supprimer un livre\n6-Terminer\n\n";
		contenu += "Entrez votre choix parmis[1-6] : ";
		return Integer
				.parseInt(JOptionPane.showInputDialog(null, contenu, "MENU GESTION LIVRES", JOptionPane.PLAIN_MESSAGE));
	}

	public static void afficherEntete() {
		sortieBrut = new JTextArea(20, 50);
		sortieBrut.setFont(new Font("monospace", Font.PLAIN, 12));
		sortieBrut.append("\t\tLISTE DES LIVRES\n\n");
		sortieBrut.append("NUM�RO\tTITRE\t\tAUTEUR\tANNEE\tPAGES\tCAT�GORIE\n");
	}

	public static void listerLivresList() {
		afficherEntete();
		listeLivres.forEach((unLivre) -> {
			sortieBrut.append(unLivre.toString());
		});
		sortieBrut.append("Nombre de livres = " + listeLivres.size());
		JOptionPane.showMessageDialog(null, sortieBrut, null, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void listerLivresListTrie() {
		afficherEntete();
		//listeLivres.sort(null);
		Collections.sort(listeLivres);
		
		listeLivres.forEach((unLivre) -> {
			sortieBrut.append(unLivre.toString());
		});
		sortieBrut.append("Nombre de livres = " + listeLivres.size());
		JOptionPane.showMessageDialog(null, sortieBrut, null, JOptionPane.PLAIN_MESSAGE);
	}

	public static void enleverUnLivreList() {
		int num = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Entrez le num�ro", "ENLEVER UN LIVRE",
						JOptionPane.PLAIN_MESSAGE));
		listeLivres.removeIf((unLivre) -> unLivre.getNum() == num);
	}

	public static void listerLivresParNumero() {
		int numero = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Entrez le num�ro du livre recherch�", "LISTER DES LIVRES PAR NUM�RO",
						JOptionPane.PLAIN_MESSAGE));
		afficherEntete();
		
		listeLivres.forEach((unLivre) -> {
			if (unLivre.getNum() == numero) {
				sortieBrut.append(unLivre.toString());
				++cptCategs;
			}
		});
		sortieBrut.append("Nombre de livres = " + cptCategs);
		JOptionPane.showMessageDialog(null, sortieBrut, null, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void listerLivresParAuteur() {
		int auteur = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Entrez le num�ro de l'auteur recherch�", "LISTER DES LIVRES PAR AUTEUR",
						JOptionPane.PLAIN_MESSAGE));
		afficherEntete();
		
		listeLivres.forEach((unLivre) -> {
			if (unLivre.getAuteur() == auteur) {
				sortieBrut.append(unLivre.toString());
				++cptCategs;
			}
		});
		sortieBrut.append("Nombre de livres = " + cptCategs);
		JOptionPane.showMessageDialog(null, sortieBrut, null, JOptionPane.PLAIN_MESSAGE);
	}


	public static Livre rechercherLivreList(int num) {
		int pos;
		Livre livreBidon = new Livre();
		livreBidon.setNum(num);
		pos = listeLivres.indexOf(livreBidon);// -1 si pas trouvé
		if (pos == -1) {
			afficherMessage("Le numéro du livre est introuvable.");
			return null;
		}
		Livre livreTrouve = listeLivres.get(pos);
		return livreTrouve;
	}
	
	@SuppressWarnings("unchecked")
	public static void chargerFichierPourUneList(){
		try{
			File f = new File(FICHIER_LIVRES_OBJ);
			
			if (f.exists()) {
				listeLivres =  (ArrayList<Livre>) Utilitaires.chargerFichierObjets(FICHIER_LIVRES_OBJ);
			}else {
				ArrayList<ArrayList<String>> listeAttributs = Utilitaires.chargerFichierTexte(FICHIER_LIVRES_TEXTE, ";");
				listeAttributs.forEach((donneesLivre) -> {
					int num;
					String titre;
					int auteur;
					int annee;
					int pages;
					String categorie;
					num = Integer.parseInt(donneesLivre.get(0));
					titre = donneesLivre.get(1);
					auteur = Integer.parseInt(donneesLivre.get(2));
					annee = Integer.parseInt(donneesLivre.get(3));
					pages = Integer.parseInt(donneesLivre.get(4));
					categorie = donneesLivre.get(5);
					listeLivres.add(new Livre(num, titre, auteur, annee, pages, categorie));
				});
			}
		} catch(Exception e){
			System.out.println("Probl�me");
		}
	}

	public static void afficherMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "MESSAGES", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void main(String[] args) throws Exception {
		int choix;
		chargerFichierPourUneList();
		do {
			choix = menuGeneral();
			switch (choix) {
				case 1:
					listerLivresList();
					//listerLivresMapTrie();
					break;
				case 2:
					listerLivresListTrie();
					break;
				case 3:
					listerLivresParNumero();
					break;
				case 4:
					listerLivresParAuteur();
					break;
				case 5:
					enleverUnLivreList();
					break;
				case 6:
					Utilitaires.sauvegarderFichierObjets(listeLivres, FICHIER_LIVRES_OBJ);
					afficherMessage("Merci d'avoir utilis� notre syst�me");
					break;
				default:
					afficherMessage("Choix invalide. Les option sont [1-6] !");
					break;
			}
		} while (choix != 6);
	}
}
