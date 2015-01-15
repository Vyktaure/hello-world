package chicstyle.abstraction;



public class Housser {

	private int qte;

	public Housser(int qte) {
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
