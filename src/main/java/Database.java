import java.util.ArrayList;

public class Database {


    private ArrayList<SuperHero> helteDatabase = new ArrayList<>();


    public void createSuperhero (String superheltenavn, String superheltealias, String superheltekræfter, int skabelsesår, double styrkeniveau, double højde, boolean menneske){

        SuperHero hero = new SuperHero(superheltenavn,superheltealias,superheltekræfter,skabelsesår,styrkeniveau,højde,menneske);
        helteDatabase.add(hero);
        //System.out.println(hero);

        for(SuperHero helt : helteDatabase) {
            System.out.println(helt);
        }

    }
    public ArrayList<SuperHero> getallhelteDatabase(){
        return helteDatabase;
    }

}
