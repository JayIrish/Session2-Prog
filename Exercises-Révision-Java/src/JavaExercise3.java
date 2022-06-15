import javax.swing.*;
public class JavaExercise3 {

	public static void main(String[] args) {
		final int TEMPT_MAX = 25;
		JTextArea resultats = new JTextArea();
		int tempt, conteur = 0;
		
		resultats.append("Les données reçu sont: ");
		tempt = Integer.parseInt(JOptionPane.showInputDialog("Entrez la température (< 25) : " ));
		while (tempt < TEMPT_MAX){
			resultats.append("\n"+tempt);
			conteur++;
			tempt = Integer.parseInt(JOptionPane.showInputDialog("Entrez la température: " ));
		}
		
		resultats.append("\nnombre de données recus: "+conteur);
		
		JOptionPane.showMessageDialog(null, resultats, "RÉSULTATS",
				JOptionPane.PLAIN_MESSAGE);

	}

}
