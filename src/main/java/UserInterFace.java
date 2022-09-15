import java.util.Scanner;
import java.sql.SQLOutput;
public class UserInterFace {


    public void startProgram() {
        Database database = new Database();
        database.createTestData();

        Scanner scanner = new Scanner(System.in);


        System.out.println("-----------------------------");
        do {

            System.out.println("Velkommen til MySuperheroList");
            System.out.println("1. Opret Superhelte");
            System.out.println("3. Search for superhero");
            System.out.println("5. Liste over helte");
            System.out.println("9. Luk programmet");
            int startside = scanner.nextInt();
            //scanner.nextLine();

            if (startside == 1) {
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
                for (SuperHero helt : database.getallhelteDatabase()) {
                    System.out.println(helt);
                }

            } else if (startside == 9) {
                System.out.println("Lukker programmet...");
                System.exit(0);
            } else if (startside == 5) {
                System.out.println("Liste over helte: " + "\n");
                System.out.println(database.getallhelteDatabase());

            } else if (startside == 3) {
                System.out.println("Search for Superhero: " + "\n");
                String search = scanner.nextLine();

                SuperHero superHero = database.searchFor(search);
                System.out.println(superHero);
            }

        } while (true);

    }
}

/*public class Main {
public static void main(String[] args) {
}*/
