package chicstyle.tableaux;

public class TabExpedition1 {

	private String taille;
    private String quantite;
    private String reste;
    private String total;
 
    public TabExpedition1(String taille, String quantite, String reste, String total) {
        super();
 
        this.taille = taille;
        this.quantite = quantite;
        this.reste = reste;
        this.total = total;
    }
 
    public String getTaille() {
        return taille;
    }
 
    public void setTaille(String taille) {
        this.taille = taille;
    }
 
    public String getQuantite() {
        return quantite;
    }
 
    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
 
    public String getReste() {
        return reste;
    }
 
    public void setReste(String reste) {
        this.reste = reste;
    }
 
    public String getTotal() {
        return total;
    }
 
    public void setTotal(String total) {
        this.total = total;
    }
}
