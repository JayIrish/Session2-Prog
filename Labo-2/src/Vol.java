
public class Vol {
	private int numVol;
	private String destination;
	private Date date;
	private int nbPassager;
	private static int nombreVol;
	
	Vol(int numVol, String destination, Date date, int nbPassager){
		this.setNumVol(numVol);
		this.setDestination(destination);
		this.setDate(date);
		this.setNbPassager(nbPassager);
		setTtlVol(nombreVol);
	};

	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setNbPassager(int nbPassager) {
		this.nbPassager = nbPassager;
	}
	
	public void setTtlVol(int nombreVol) {
		Vol.nombreVol = nombreVol++;
	}
	
	public int getNumVol() {
		return this.numVol;	}
	
	public String getDestination() {
		return this.destination;	}
	
	public Date getDate() {
		return this.date;	
	}
	
	public int getNbPassager() {
		return this.nbPassager;	}
	
	public static int getNombreVol() {
		return Vol.nombreVol;	}
	
	public String toString() {
		return this.getNumVol()+"\t"+this.getDestination()+"\t"+this.getDate()+"\t"+this.getNbPassager();
	}
	
}


