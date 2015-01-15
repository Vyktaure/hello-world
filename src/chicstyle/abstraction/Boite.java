package chicstyle.abstraction;

public class Boite {

private boolean ok;
	
	public Boite(boolean ok) {
		super();
		this.ok = ok;
	}

	public boolean isOk() {
		return this.ok;
	}

	public void setDefinitive(boolean ok) {
		this.ok = ok;
	}
	public String toString() {
		return "" + this.isOk();
	}
	
}
