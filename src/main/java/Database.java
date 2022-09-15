import javax.naming.directory.SearchControls;
import java.util.ArrayList;

public class Database {

    private ArrayList<SuperHero> helteDatabase = new ArrayList<>();

    public void createTestData() {
        createSuperhero("Else", "Frozen", "Is", 2013, 2, 165, true);
        createSuperhero("Robin", "Batmans bitch", "partner til rigmand", 1999, 0.5, 210, true);
    }

    public void createSuperhero(String superheltenavn, String superheltealias, String superheltekræfter, int skabelsesår, double styrkeniveau, double højde, boolean menneske) {

        SuperHero hero = new SuperHero(superheltenavn, superheltealias, superheltekræfter, skabelsesår, styrkeniveau, højde, menneske);
        helteDatabase.add(hero);

        /*for(SuperHero helt : helteDatabase) {
           System.out.println(helt);}*/

    }

    public ArrayList<SuperHero> getallhelteDatabase() {
        return helteDatabase;
    }

    public SuperHero searchFor(String searchTerm) {
        for (SuperHero helt : helteDatabase) {
            if (searchTerm.contains(helt.getAlias())) {
                return helt;
            }
            if (searchTerm.contains(helt.getNavn())){
                return helt;
            }
            if (searchTerm.equalsIgnoreCase(helt.getAlias())) {
                return helt;
            }
            if (searchTerm.equalsIgnoreCase(helt.getNavn())) {
                return helt;
            }
        }
        return null;

    }
}

