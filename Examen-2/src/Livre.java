import java.io.*;

public class Livre implements Serializable, Comparable<Livre> {

	private static final long serialVersionUID = 2040890116313738088L;

	String tabCategs[] = { "Horreur", "Drame", "Comédie", "Jeunesse", "Poésie", "Biographie", "Cuisine" };

	// Attributs d'instances
	private int num;
	private String titre;
	private int auteur;
	private int annee;
	private int pages;
	private String categorie;// 0, 1, 2 ou 3

	public static int nbLivres = 0; // Attribut de classe

	// Les constructeurs
	Livre() { // Par dÃ©faut
		++nbLivres;
	}

	Livre(int num, String titre, int auteur, int annee, int pages, String categorie) { // ParamÃ©trÃ©
		this.setNum(num);
		if (titre.length() > 20) {
		this.titre = titre.substring(0,20)+ "… ";	
		}else {
			this.setTitre(titre);
		}
		this.setAuteur(auteur);
		this.setAnnee(annee);
		this.setPages(pages);
		this.setCategorie(categorie);
		++nbLivres;
	}

	// Les accesseurs (getter)
	public int getNum() {
		return this.num;
	}

	public String getTitre() {
		return this.titre;
	}
	
	public int getAuteur() {
		return this.auteur;
	}
	
	public int getAnnee() {
		return this.annee;
	}

	public int getPages() {
		return this.pages;
	}

	public String getCategorie() {
		return this.categorie;
	}
	// Les mutateurs (setter)

	public void setNum(int num) {
		if (num > 0) {
			this.num = num;
		} else {
			System.out.println("NumÃ©ro de livre invalide !");
		}
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public void setAuteur(int auteur) {
		if (auteur > 0) {
			this.auteur = auteur;
		} else {
			System.out.println("Nombre de l'auteur invalide !");
		}
	}
	
	public void setAnnee(int annee) {
		if (annee > 0) {
			this.annee = annee;
		} else {
			System.out.println("Annee invalide !");
		}
	}

	public void setPages(int pages) {
		if (pages > 0) {
			this.pages = pages;
		} else {
			System.out.println("Nombre de pages invalide !");
		}
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public boolean equals(Object obj) {
		Livre autreLivre = (Livre) obj;
		if (this.num == autreLivre.num) {
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Livre unLivre) {
		// Par num livre
		return (int) (this.num - unLivre.num);// En ordre croissant
		// return (int) (unLivre.num - this.num);//En ordre dÃ©croissant
		// Par titre
		// return this.titre.compareTo(unLivre.titre);
	}

	// Retourner le contenu d'un objet selon un format voulu
	public String toString() {
		return (this.titre.length() > 15)
				? this.num + "\t" + this.titre + "\t" + this.auteur + "\t" + this.annee + "\t" + this.pages + "\t" + getCategorie() + "\n"
				: this.num + "\t" + this.titre + "\t\t" + this.auteur + "\t" + this.annee + "\t" + this.pages + "\t" + getCategorie() + "\n";
	}
}
