package chicstyle.abstraction;


public class Nomenclature {

	private int qte_unit;
	private boolean fact;

	public Nomenclature(int qte_unit,  boolean fact) {
		super();
		this.qte_unit = qte_unit;
		this.fact = fact;
	}

	public int getQte_unit() {
		return qte_unit;
	}

	public void setQte_unit(int qte_unit) {
		this.qte_unit = qte_unit;
	}

	public boolean isFact() {
		return fact;
	}

	public void setFact(boolean fact) {
		this.fact = fact;
	}

	@Override
	public String toString() {

		if (this.isFact()){
			return this.getQte_unit()+", facturé";
		}
		else {
			return this.getQte_unit()+", non facturé";
		}
	}


}
