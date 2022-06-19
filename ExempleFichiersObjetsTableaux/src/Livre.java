public class Livre {
	//Attributs d'instances
	private int num;
	private String titre;
	private int pages;
	
	public static int nbLivres = 0; //Attribut de classe
	
	//Les constructeurs
	Livre(){ //Par défaut
		++nbLivres;
	}
	
	Livre(int num, String titre, int pages){ //Paramètré
		this.num = num;
		this.titre = titre;
		this.pages = pages;
		++nbLivres;
	}
	
	Livre(Livre unLivre){ //De copie
		this.num = unLivre.num;
		this.titre = unLivre.titre;
		this.pages = unLivre.pages;
		++nbLivres;
	}

	//Les accesseurs (getter)
	public int getNum() {
		return this.num;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public int getPages() {
		return this.pages;
	}
	
	//Les mutateurs (setter)
	
	public void setNum(int num) {
		if(num > 0) {
			this.num = num;
		} else {
			System.out.println("Numéro de livre invalide !");
		}
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public void setPages(int pages) {
		if(pages > 0) {
			this.pages = pages;
		} else {
			System.out.println("Nombre de pages valide !");
		}
	}
	
	//Retourner le contenu d'un objet selon un format voulu
	public String toString() {
		
		//CAS 1
				return (this.titre.length() > 17) ? this.num+"\t"+this.titre+"\t"+this.pages+"\n" : this.num+"\t"+this.titre+"\t\t"+this.pages+"\n";
				
		//CAS 2
		//String rep = (this.titre.length() > 17) ? this.num+"\t"+this.titre+"\t"+this.pages+"\n" : this.num+"\t"+this.titre+"\t\t"+this.pages+"\n";
		//return rep;
		//CAS 3
		/*if(this.titre.length() > 17) {
			return this.num+"\t"+this.titre+"\t"+this.pages+"\n";
		}else {
			return this.num+"\t"+this.titre+"\t\t"+this.pages+"\n";
		}*/
		
	}
	
}
