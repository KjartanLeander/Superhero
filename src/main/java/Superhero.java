public class SuperHero {
    private String navn;
    private String alias;
    private String superkræft;
    private int skabelsesår;
    private double styrkeniveau;
    private double højde;
    private boolean menneske;

    public SuperHero (String navn, String alias, String superkræft, int skabelsesår, double styrkeniveau, double højde, boolean menneske){
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
    public boolean isMenneske() {
        return menneske;
    }
    public String getAlias(){
        return alias;
    }
    @Override
    public String toString() {
        return "\n"+"Superheltenavn: " + navn + "\n"+ "Superheltealias: " + alias + "\n" + "Superkræfter: " + superkræft + "\n" + "Skabelsesår: "+skabelsesår + "\n" + "Styrkeniveau: "+styrkeniveau + "\n" + "Højde: "+højde + "\n" + "Menneske: "+menneske+"\n";
     }

    }


