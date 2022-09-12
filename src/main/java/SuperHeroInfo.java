public class SuperHeroInfo {
    private String navn;
    private String alias;
    private String superkræft;
    private int skabelsesår;
    private double styrkeniveau;
    private double højde;
    private boolean menneske;

    public SuperHeroInfo (String navn, String alias, String superkræft, int skabelsesår, double styrkeniveau, double højde, boolean menneske){
        this.navn=navn;
        this.superkræft=superkræft;
        this.skabelsesår=skabelsesår;
        this.styrkeniveau=styrkeniveau;
        this.højde=højde;
        this.menneske=menneske;
        this.alias=alias;
        }
    public String getNavn(){
        return navn;
    }
    public String getSuperkræft() {
        return superkræft;
    }
    public int getSkabelsesår() {
        return skabelsesår;
    }
    public double getStyrkeniveau() {
        return styrkeniveau;
    }
    public double getHøjde() {
        return højde;
    }
    public boolean getMenneske() {
        return menneske;
    }
    public String getAlias(){
        return alias;
    }


}
