import java.io.*;
import java.util.ArrayList;

import javax.swing.JTextArea;
public class GestionsVols {
	static final String FICHIER_CIEAIRRELAX = "src/donnees/Cie Air Ralex.txt";
	
	static ArrayList<Vol> listeVols;
	static BufferedReader tmpVolRead;
	static BufferedWriter tmpVolWrite;
	static JTextArea output;

	

	public static void genererVols() throws FileNotFoundException {
		
		try {
			tmpVolRead = new BufferedReader(new FileReader(FICHIER_CIEAIRRELAX));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 int i = 0;
		 String ligne;
		 String elems[];
		 ligne = tmpVolRead.readLine();
		 while(i < tailleTableaux && ligne != null) {
			 elems = ligne.split(";");
			 tabNoProd[i] = Integer.parseInt(elems[0]);
			 tabPrixProd[i] = Double.parseDouble(elems[1]);
			 ++i;//i=i+1;
			 ligne = tmpVolRead.readLine();
		 }
		 tmpVolRead.close();
		 return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
