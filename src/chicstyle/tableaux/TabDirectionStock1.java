package chicstyle.tableaux;

public class TabDirectionStock1 {

	private String reference;
    private String type;
    private String besoin;
    private String dispo;
    private String diff;
 
    public TabDirectionStock1(String reference, String type, String besoin, String dispo, String diff ) {
        super();
 
        this.reference = reference;
        this.type = type;
        this.besoin = besoin;
        this.dispo = dispo;
        this.diff = diff;
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
 
    public String getBesoin() {
        return besoin;
    }
 
    public void setBesoin(String besoin) {
        this.besoin = besoin;
    }
 
    public String getDispo() {
        return dispo;
    }
 
    public void setDispo(String dispo) {
        this.dispo = dispo;
    }
    
    public String getDiff() {
    	return diff;
    }
    
    public void setDiff(String diff) {
    	this.diff = diff;
    }
 
}
