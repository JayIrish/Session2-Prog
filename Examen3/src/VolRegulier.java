
public class VolRegulier extends Vol{
	private static final long serialVersionUID = -5394713900392177888L;
	
	//Attribut d'instances
	private boolean repas;
	private boolean reservationSiege;
	private boolean divertissement;
	
	// constructeur par défault
	public VolRegulier() {
		super();
	}
	
	//contructeur paramétré
	public VolRegulier(int noVol, String destination, Date date, int nbRes, Avion avion,
					   boolean repas, boolean reservationSiege, boolean divertissement) {
		super(noVol, destination, date, nbRes, avion);
		this.repas = repas;
		this.reservationSiege = reservationSiege;
		this.divertissement = divertissement;
	}

	
	// getters / accesseurs
	public boolean isRepas() {
		return repas;
	}

	public boolean isReservationSiege() {
		return reservationSiege;
	}

	public boolean isDivertissement() {
		return divertissement;
	}

	
	//setters / muttateurs
	public void setRepas(int nombre) {
		if (nombre == 1)
			{this.repas = true;}
		else
			{this.repas = false;}
	}

	public void setReservationSiege(int nombre) {
		if (nombre == 1)
			{this.reservationSiege = true;}
		else
			{this.reservationSiege = false;}
	}
	
	public void setDivertissement(int nombre) {
		if (nombre == 1)
			{this.divertissement = true;}
		else
			{this.divertissement = false;}
	}

	
	public void modifierVol(int indexAttribut, int entry) 
	{
		switch (indexAttribut) 
		{
		case 4 : this.setNbRes(entry); break;
		case 6 : this.setRepas(entry); break;
		case 7 : this.setReservationSiege(entry); break;
		case 8 : this.setDivertissement(entry); break;
		}
	}


	
	public String toString() {
        String rep = "R\t ";
        rep += super.toString();
        rep += this.repas?"Oui\t ":"Non\t ";
        rep += this.reservationSiege ? "Oui\t ":"Non\t ";
        rep += this.divertissement? "Oui\t\t \n":"Non\t\t \n";
        return rep;
    }
	
}
