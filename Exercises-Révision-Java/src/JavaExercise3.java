import javax.swing.*;
public class JavaExercise3 {

	public static void main(String[] args) {
		final int TEMPT_MAX = 25;
		JTextArea resultats = new JTextArea();
		int tempt, conteur = 0;
		
		resultats.append("Les donn�es re�u sont: ");
		tempt = Integer.parseInt(JOptionPane.showInputDialog("Entrez la temp�rature (< 25) : " ));
		while (tempt < TEMPT_MAX){
			resultats.append("\n"+tempt);
			conteur++;
			tempt = Integer.parseInt(JOptionPane.showInputDialog("Entrez la temp�rature: " ));
		}
		
		resultats.append("\nnombre de donn�es recus: "+conteur);
		
		JOptionPane.showMessageDialog(null, resultats, "R�SULTATS",
				JOptionPane.PLAIN_MESSAGE);

	}

}
