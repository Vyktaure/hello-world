package chicstyle.tableaux;

public class TabBoite1 {
	

	private String reference;
    private String type;
    private String qte;
    private String stock;
 
    public TabBoite1(String reference, String type,String qte, String stock) {
        super();
 
        this.reference = reference;
        this.type = type;
        this.qte = qte;
        this.stock = stock;
    }
 
    public String getReference() {
        return reference;
    }
 
    public void setReference(String reference) {
        this.reference = reference;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public String getqte() {
        return qte;
    }
 
    public void setqte(String qte) {
        this.qte = qte;
    }

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
    

 

}
