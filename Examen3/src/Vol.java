import java.io.Serializable;

public class Vol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 594511020193888621L;

	//attribut de classe
	public static int nombreVols = 0;

	// attribut d'instance
	protected int noVol;
	protected String destination;
	protected Date date;
	protected int nbRes;
	protected String typeAvion;
	
	
	// constructeur par default
	Vol() {}
	
	
	// constructeur paraméré
	Vol(int noVol, String destination, Date date, int nbRes, Avion avion) 
		{
			this.noVol = noVol;
			this.destination = destination;
			setDate(date);
			setNbRes(nbRes);
			this.typeAvion = avion.getTypeAvion();
		}
	
	
	// accesseurs/getters
	public int getNoVol()
		{return this.noVol;}
	
	
	public String getDestination()
		{return this.destination;}
	
	
	public Date getDate()
		{return this.date;}
	
	
	public int getNbRes()
		{return this.nbRes;}
	
	public String getTypeAvion()
		{return this.typeAvion;}
	
	
	// mutateurs/setters
	public void setNoVol(int noVol)
		{
			if (noVol > 0)
				{this.noVol = noVol;}
			else
				{throw new IllegalArgumentException("Le numéro de vol doit ére supérieur é 0!");}
		}
	
	public void setDestination(String destination)
		{this.destination = destination;}
	
	public void setNbRes(int nbRes) 
		{
		if (nbRes >= 0)
			{this.nbRes = nbRes;}
		else
			{throw new IllegalArgumentException("Le nombre de réservation doit ére supérieur é 0!");}
		}
	
	
	public void setDate(Date date)
		{this.date = date;}
	
	public void setTypeAvion(Avion avion)
		{this.typeAvion = avion.getTypeAvion();}
	
	
	public void modifierVol(int indexAttribut, int entry) 
	{
		switch (indexAttribut) 
		{
		case 4 : this.setNbRes(entry); break;
		}
	}
	
	
	public String toString()
		{return this.noVol + "\t " + String.format("%-25s", this.destination) + "\t\t " + this.date + "\t " + this.nbRes + "\t " + String.format("%-20s", this.typeAvion) + "\t ";}
}
