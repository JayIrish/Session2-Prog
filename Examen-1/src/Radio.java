

public class Radio {
	
	private String make;
	private String model;
	private int cd;
	private int cassette;
	private int mp3;
	private double price;
	
	
	Radio(){
		
	}
	
	Radio(String make, String model, int cd, int cassette, int mp3, double price){
		this.setMake(make);
		this.setModel(model);
		this.setCD(cd);
		this.setCassette(cassette);
		this.setMp3(mp3);
		this.setPrice(price);
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getCd() {
		return this.cd;
	}
	
	public int getCassette() {
		return this.cassette;
	}
	
	public int getMp3() {
		return this.mp3;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setMake(String make){
		this.make = make;
	}	
	
	public void setModel(String model){
		this.model = model;
	}
	
	public void setCD(int cd){
		this.cd = cd;
	}
	
	public void setCassette(int cassette){
		this.cassette = cassette;
	}
		
	public void setMp3(int mp3){
		this.mp3 = mp3;
	}
		
		
	
	
	public void setPrice(double price){
		this.price = price;
	}
	
	private String hasCd(){
		if(this.getCd() == 1) {
			return "Oui";
		}else {
			return "Non";
		}
	}
	
	private String hasCassette(){
		if(this.getCassette() == 1) {
			return "Oui";
		}else {
			return "Non";
		}
	}
	
	private String hasMp3(){
		if(this.getMp3() == 1) {
			return "Oui";
		}else {
			return "Non";
		}
	}
	
	public boolean isSame(Object obj) {
		Radio comparer = (Radio) obj;
		if( this.make == comparer.make && this.model == comparer.model) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return this.make +"\t"+ this.model +"\t"+ hasCd()+ "      "+ hasCassette()+ "\t    " + hasMp3() +"\t"+ this.price + "\n";	}
	
}

