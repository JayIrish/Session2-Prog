
public class VolCharter extends Vol{
	private static final long serialVersionUID = 1656109684797474232L;
	
	//Attribut d'instances
	private boolean bar;
	private boolean divertissement;
	
	// constructeur par défault
	public VolCharter() {
		super();
	}
	
	//contructeur paramétré
	public VolCharter(int noVol, String destination, Date date, int nbRes, Avion avion, boolean bar, boolean divertissement) {
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

	
	public void modifierVol(int indexAttribut, int entry) 
	{
		switch (indexAttribut) 
		{
		case 4 : this.setNbRes(entry); break;
		case 8 : this.setDivertissement(entry); break;
		case 10 : this.setBar(entry); break;
		}
	}
	
	
	public String toString() {
        String rep = "C\t ";
        rep += super.toString();
        rep += this.bar ? "Oui\t ":"Non\t ";
        rep += this.divertissement? "Oui\t\t \n":"Non\t\t \n";
        return rep;
    }
}
