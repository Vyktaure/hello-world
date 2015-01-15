package chicstyle.abstraction;



public class Patron {
	
	private double laize;
	private double longueur;
	
	
	public Patron(double laize, double longueur) {
		super();
		this.laize = laize;
		this.longueur = longueur;
	}


	public double getLaize() {
		return laize;
	}


	public void setLaize(double laize) {
		this.laize = laize;
	}


	public double getLongueur() {
		return longueur;
	}


	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
		

}
