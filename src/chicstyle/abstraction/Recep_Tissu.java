package chicstyle.abstraction;


public class Recep_Tissu {

	private double laize;
	private double longueur_rouleau;
	
	public Recep_Tissu(String ref, double laize, double longueur_rouleau) {
		super();
		this.laize = laize;
		this.longueur_rouleau = longueur_rouleau;
	}

	public double getLaize() {
		return this.laize;
	}
	public void setLaize(double laize) {
		this.laize = laize;
	}
	public double getLongueur_rouleau() {
		return this.longueur_rouleau;
	}
	public void setLongueur_rouleau(double longueur_rouleau) {
		this.longueur_rouleau = longueur_rouleau;
	}
	public String toString() {
		return this.getLaize() + ", " + this.getLongueur_rouleau();
	}

}
