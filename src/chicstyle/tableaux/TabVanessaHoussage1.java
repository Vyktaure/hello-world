package chicstyle.tableaux;

public class TabVanessaHoussage1 {

	private String taille;
    private String housse;
    private String total;
    private String reste;

 
    public TabVanessaHoussage1(String taille, String housse, String total, String reste) {
        super();
 
        this.taille = taille;
        this.housse = housse;
        this.total = total;
        this.reste = reste;
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
 
    public String getTotal() {
        return total;
    }
 
    public void setTotal(String total) {
        this.total = total;
    }
 
    public String getReste() {
        return reste;
    }
 
    public void setReste(String reste) {
        this.reste = reste;
    }
}
