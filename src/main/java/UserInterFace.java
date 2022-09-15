import java.awt.*;
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

        System.out.println("Menneske?");
        boolean menneske = scanner.nextBoolean();
        database.createSuperhero(superheltenavn, superheltalias, superheltekræfter, skabelsesår, styrkeniveau, højde, menneske);
        for (SuperHero helt : database.getallhelteDatabase())
            System.out.println(helt);
    }

    public void søgEfterSuperhelt3() {

        scanner.nextLine();
        System.out.println("Search for Superhero: " + "\n");
        String search = scanner.nextLine();

        SuperHero superHero = database.searchFor(search);
        System.out.println(superHero);
    }

    public void listeOverhelte() {
        System.out.println("Liste over helte: " + "\n");
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
