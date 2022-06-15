import java.io.*;
import java.util.*;

public class StringTokenizerExercise {
	
	static String personne = "Marie Curie;Scientifique#73;France!aa";
	static String DelimiteurToken = ";#";
	static String DelimiteurSplit = ";|#|!";
	
	public static void AvecStringTokenizer() {
		StringTokenizer str = new StringTokenizer(personne, DelimiteurToken);
		
		/*while(str.hasMoreTokens()) {
			System.out.println(str.nextToken());
		}*/
		System.out.println("NOM = "+str.nextToken());
		System.out.println("PROFFESSION = "+str.nextToken());
		System.out.println("AGE = "+str.nextToken());
		System.out.println("PAYS = "+str.nextToken());
		
	}
	public static void AvecSplit() {
		String[] tab;
		tab = personne.split(DelimiteurSplit);
		/*for(String attribut : tab) {
			System.out.println(attribut);
		}*/
		System.out.println("NOM = "+tab[0]);
		System.out.println("PROFFESSION = "+tab[1]);
		System.out.println("AGE = "+tab[2]);
		System.out.println("PAYS = "+tab[3]);
		System.out.println("INUTILE = "+tab[4]);
	}
	public static void main(String[] args) {
		//AvecStringTokenizer();
		AvecSplit();
		
	}
}
