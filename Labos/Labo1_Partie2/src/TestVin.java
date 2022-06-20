import javax.swing.*;


public class TestVin {
	static JTextArea result;
	static Vin vin1 = new Vin( "Venoum", "France", 19.99);
	static Vin vin2 = new Vin( "Decadent", 2, "Allemagne", 39.99);
	static Vin vin3 = new Vin( "Mysnommer", 3,"Italy", 49.99);
		
	public static void step1() {
		double prix = vin1.getPrix();
		prix += 2;
		Vin.setTtlPrix(Vin.getTtlPrix() +2);
		vin1.setPrix(prix);
	}
	
	public static void step2() {
		vin2.setPrix(200.00);
		Vin.setTtlPrix(Vin.getTtlPrix() -39.99 + 200);
		vin2.setOrigine("Vietnam");
	}
	
	public static void step3() {
		vin3.setNom("Mentia Maron");
		vin3.setType(2);
	}
	
	public static void step4() {
		vin3.setOrigine(vin1.getOrigine());
	}
	
	public static void run() {
				result = new JTextArea();
				result.append("Voici les "+ Vin.nbVin +" vins\n");
				result.append("Le prix total des vins est de "+ Vin.getTtlPrix() +"$\n");
				result.append("\t" + vin1.toString());
				result.append("\t" + vin2.toString());
				result.append("\t" + vin3.toString());
				result.append("\n");
				step1();
				step2();
				step3();
				step4();
				Vin vin4 = new Vin("Venoum", "France", 19.99);
				result.append("Voici les "+ Vin.nbVin +" vins\n");
				result.append("Le prix total des vins est de "+ Vin.getTtlPrix() +"$\n");
				result.append("\t" + vin1.toString());
				result.append("\t" + vin2.toString());
				result.append("\t" + vin3.toString());
				result.append("\t" + vin4.toString());
				JOptionPane.showMessageDialog(null ,result, "Résultas obtenu", JOptionPane.PLAIN_MESSAGE);
			}
		
	public static void main(String[] args) {
		run();
		
	}
 
}
