package chicstyle.abstraction;



public class Expedier {

	private int qte;

	public Expedier(int qte) {
		super();
		this.qte = qte;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	public String toString(){
		return "" + this.getQte();
	}
	
}
