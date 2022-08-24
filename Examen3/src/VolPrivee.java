
public class VolPrivee extends Vol{
	private static final long serialVersionUID = 1333426284309588056L;
	
	//Attribut d'instances
	private boolean repas;
	private boolean bar;
	private boolean divertissement;
	private boolean wifi;
	
	// constructeur par défault
	public VolPrivee() {
		super();
	}
	
	//contructeur paramétré
	public VolPrivee(int noVol, String destination, Date date, int nbRes, Avion avion,
					 boolean repas, boolean bar, boolean divertissement, boolean wifi) {
		super(noVol, destination, date, nbRes, avion);
		this.bar = bar;
		this.divertissement = divertissement;
	}

	
	// getters / accesseurs
	public boolean isBar() {
		return bar;
	}

	public boolean isDivertissement() {
		return divertissement;
	}
	
	public boolean isRepas() {
		return repas;
	}

	public boolean isWifi() {
		return wifi;
	}


	//setters / muttateurs
	public void setBar(int nombre) {
		if (nombre == 1)
			{this.bar = true;}
		else
			{this.bar = false;}
	}

	public void setDivertissement(int nombre) {
		if (nombre == 1)
			{this.divertissement = true;}
		else
			{this.divertissement = false;}
	}
	
	public void setRepas(int nombre) {
		if (nombre == 1)
			{this.repas = true;}
		else
			{this.repas = false;}
	}

	public void setWifi(int nombre) {
		if (nombre == 1)
			{this.wifi = true;}
		else
			{this.wifi = false;}
	}
	
	
	public void modifierVol(int indexAttribut, int entry) 
	{
		switch (indexAttribut) 
		{
		case 4 : this.setNbRes(entry); break;
		case 6 : this.setRepas(entry); break;
		case 8 : this.setDivertissement(entry); break;
		case 10 : this.setBar(entry); break;
		case 11 : this.setWifi(entry); break;
		}
	}
	
	public String toString() {
        String rep = "P\t ";
        rep += super.toString();
        rep += this.repas ? "Oui\t ":"Non\t ";
        rep += this.bar ? "Oui\t ":"Non\t ";
        rep += this.divertissement? "Oui\t\t ":"Non\t\t ";
        rep += this.wifi ? "Oui\t\t \n":"Non\t\t \n";
        return rep;
    }

}
