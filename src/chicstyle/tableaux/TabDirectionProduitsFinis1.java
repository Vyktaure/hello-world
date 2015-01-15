package chicstyle.tableaux;

public class TabDirectionProduitsFinis1 {

	private String taille;
    private String housse;
    private String expedie;
    private String total;
    private String diff;
 
    public TabDirectionProduitsFinis1(String taille, String housse, String expedie, String total, String diff) {
        super();
 
        this.taille = taille;
        this.housse = housse;
        this.expedie = expedie;
        this.total = total;
        this.diff = diff;
    }
 
    public String getTaille() {
        return taille;
    }
 
    public void setTaille(String taille) {
        this.taille = taille;
    }
 
    public String getHousse() {
        return housse;
    }
 
    public void setHousse(String housse) {
        this.housse = housse;
    }
 
    public String getExpedie() {
        return expedie;
    }
 
    public void setExpedie(String expedie) {
        this.expedie = expedie;
    }
 
    public String getTotal() {
        return total;
    }
 
    public void setTotal(String total) {
        this.total = total;
    }
    
    public String getDiff() {
    	return diff;
    }
    
    public void setDiff(String diff) {
    	this.diff = diff;
    }
}
