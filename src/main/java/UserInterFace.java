import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLOutput;

public class UserInterFace {
    Scanner scanner = new Scanner(System.in);
    Database database = new Database();

    public void startProgram() {
        database.createTestData();

        do {
            menu();
            int startside = scanner.nextInt();
            if (startside == 1) {
                lavSuperHelt1();
            } else if (startside == 3) {
                søgEfterSuperhelt3();
            } else if (startside == 5) {
                listeOverhelte();
            }else if (startside==7){
                editSuperhero();
            } else if (startside == 9) {
                lukProgrammet();
            }

        } while (true);
    }

    public void menu() {
        System.out.println("Velkommen til MySuperheroList");
        System.out.println("1. Opret Superhelte");
        System.out.println("3. Search for superhero");
        System.out.println("5. Liste over helte");
        System.out.println("7. Redigere superhelt");
        System.out.println("9. Luk programmet");
    }

    public void lavSuperHelt1() {

        //scanner.nextLine();

        scanner.nextLine();
        System.out.println("\n" + "Lav en superhelt: ");

        System.out.println("Superhelt navn?");
        String superheltenavn = scanner.nextLine();

        System.out.println("Superhelt alias?");
        String superheltalias = scanner.nextLine();
        System.out.println("Superheltkræfter?");
        String superheltekræfter = scanner.nextLine();

        System.out.println("Skabelsesår?");
        int skabelsesår = scanner.nextInt();

        System.out.println("Styrkeniveau?");
        double styrkeniveau = scanner.nextDouble();

        System.out.println("Højde?");
        double højde = scanner.nextDouble();

        System.out.println("Menneske?(True/false");
        boolean menneske = scanner.nextBoolean();
        database.createSuperhero(superheltenavn, superheltalias, superheltekræfter, skabelsesår, styrkeniveau, højde, menneske);
        for (SuperHero helt : database.getallhelteDatabase())
            System.out.println(helt);
    }

    public void søgEfterSuperhelt3() {

        scanner.nextLine();
        System.out.println("Search for Superhero: " + "\n");
        String search = scanner.nextLine();

        ArrayList<SuperHero> searchReults = database.searchFor(search);
        if (searchReults.isEmpty()) {
            System.out.println("No superheroes matching search was found");
        } else {
            System.out.println("Mutilple superheroes was found:");
            for (SuperHero superHero : searchReults) {
                System.out.println("Superhelte Navn:" + superHero.getNavn());
                System.out.println("Superhelte Alias:" + superHero.getAlias());
                System.out.println("Superhelte skabelsesår:" +superHero.getSkabelsesår());
                System.out.println("Superhelte styrkeniveau:"+superHero.getStyrkeniveau());
                System.out.println("Superhelt højde:"+superHero.getHøjde());
                System.out.println("Er superhelt menneske?:"+superHero.isMenneske());
                System.out.println("\n");
            }
        }

        ArrayList<SuperHero> superHero = database.searchFor(search);
    }

    public void listeOverhelte() {
        System.out.println("Liste over helte: " + "\n");
        System.out.println(database.getallhelteDatabase());
        scanner.nextLine();
        String search = scanner.nextLine();

    }

    public void editSuperhero(){
        System.out.println("Vælg superhelt du vil redigere:");
        System.out.println(database.getallhelteDatabase());

    }
    public void lukProgrammet() {
        System.out.println("Lukker programmet...");
        System.exit(0);
    }
}

/*public class Main {
public static void main(String[] args) {
}*/
