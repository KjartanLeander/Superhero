import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    Scanner scan = new Scanner(System.in);
    private ArrayList<SuperHero> helteDatabase = new ArrayList<>();

    public void createTestData() {
        createSuperhero("Elseman", "Frozen", "Is", 2013, 2, 165, true);
        createSuperhero("Robinman", "Batmans sidekick", "partner til rigmand", 1999, 0.5, 210, true);
    }

    public void createSuperhero(String superheltenavn, String superheltealias, String superheltekræfter, int skabelsesår, double styrkeniveau, double højde, boolean menneske) {

        SuperHero hero = new SuperHero(superheltenavn, superheltealias, superheltekræfter, skabelsesår, styrkeniveau, højde, menneske);
        helteDatabase.add(hero);

    }

    public ArrayList<SuperHero> getallhelteDatabase() {
        return helteDatabase;
    }

    public ArrayList<SuperHero> searchFor(String searchTerm) {
            ArrayList<SuperHero>searchResults = new ArrayList<>();
            for(SuperHero superHero:helteDatabase){
                String name = superHero.getNavn().toLowerCase();
                if (name.contains(searchTerm.toLowerCase())) {
                    searchResults.add(superHero);
                }
            }
       return searchResults;
    }

    }


