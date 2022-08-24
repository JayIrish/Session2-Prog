
public class VolBasPrix extends Vol{
	private static final long serialVersionUID = -6273472430068256551L;
	
	//Attribut d'instances
	private boolean reservationSiege;
	private boolean servicePayant;
	
	// constructeur par défault
	public VolBasPrix() {
		super();
	}
	
	//contructeur paramétré
	public VolBasPrix(int noVol, String destination, Date date, int nbRes, Avion avion, 
					   boolean reservationSiege, boolean servicePayant) {
		super(noVol, destination, date, nbRes, avion);
		this.reservationSiege = reservationSiege;
		this.servicePayant = servicePayant;
	}

	
	// getters / accesseurs

	public boolean isReservationSiege() {
		return reservationSiege;
	}
	
	public boolean isServicePayant() {
		return servicePayant;
	}
	
	//setters / muttateurs
	public void setReservationSiege(int nombre) {
		if (nombre == 1)
			{this.reservationSiege = true;}
		else
			{this.reservationSiege = false;}
	}
	
	public void setServicePayant(int nombre) {
		if (nombre == 1)
			{this.servicePayant = true;}
		else
			{this.servicePayant = false;}
	}
	
	
	public void modifierVol(int indexAttribut, int entry) 
	{
		switch (indexAttribut) 
		{
		case 4 : this.setNbRes(entry); break;
		case 7 : this.setReservationSiege(entry); break;
		case 9 : this.setServicePayant(entry); break;
		}
	}
	
	public String toString() {
        String rep = "B\t ";
        rep += super.toString();
        rep += this.reservationSiege ? "Oui\t ":"Non\t ";
        rep += this.servicePayant ? "Oui\t\t \n":"Non\t\t \n";
        return rep;
    }
}
