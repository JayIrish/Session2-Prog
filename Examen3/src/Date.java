import java.io.Serializable;

public class Date implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1714514411026909142L;
	// attribut d'instance
	private int day;
	private int month;
	private int year;
	
	
	// constructeur par d�fault
	public Date() {}
	
	// constructeur param�tr�
	public Date(int day, int month, int year)
	{
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	
	public void modifierDate(int indexAttribut, int entry)
	{
		switch (indexAttribut) 
		{
		case 1 : this.setDay(entry); break;
		case 2 : this.setMonth(entry); break;
		case 3 : this.setYear(entry); break;
		}
	}
	
	// accesseurs/getters
	public int getDay() {return this.day;}
	public int getMonth() {return this.month;}	
	public int getYear() {return this.year;}
	
	//setters
	public void setDay(int day) 
		{
			if (day > 0 && day <= 31)
				{this.day = day;}
			else
				{throw new IllegalArgumentException("Le jour doit �tre entre 1 et 31!");}
		}
	
	
	public void setMonth(int month) 
		{
			if (month > 0 && month <= 12)
				{this.month = month;}
			else
				{throw new IllegalArgumentException("Le mois doit �tre entre 1 et 12!");}
		}
		
		
	public void setYear(int year) {this.year = year;}
	
	
	public String toString()
		{return String.format("%-12s", this.day + "/" + this.month + "/" + String.format("%-4s",this.year));}
}
