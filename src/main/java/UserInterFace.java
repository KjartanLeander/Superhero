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
            } else if (startside == 7) {
                editSuperhero();
            } else if (startside == 9) {
                lukProgrammet();
            }

        } while (true);
    }

    private void lukProgrammet() {
        System.out.println("Lukker programmet...");
        System.exit(0);
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
                System.out.println("Superhelte skabelsesår:" + superHero.getSkabelsesår());
                System.out.println("Superhelte styrkeniveau:" + superHero.getStyrkeniveau());
                System.out.println("Superhelt højde:" + superHero.getHøjde());
                System.out.println("Er superhelt menneske?:" + superHero.isMenneske());
                System.out.println("\n");
            }
        }

        ArrayList<SuperHero> superHero = database.searchFor(search);
    }

    public void listeOverhelte() {
        System.out.println("Liste over helte: " + "\n");
        for (int i = 0; i < database.getallhelteDatabase().size(); i++) {
            System.out.println(i + 1 + ": " + database.getallhelteDatabase().get(i));

        }


    }

    public void editSuperhero() {
        boolean writingError = false;
        /*System.out.println("Indtast nummer for superhelt");
        int number = scanner.nextInt();
        scanner.nextLine();*/
        {
            System.out.println("Superheroes");
            for (int i = 0; i < database.getallhelteDatabase().size(); i++) {
                System.out.println(i + 1 + ": " + database.getallhelteDatabase().get(i));
            }

            System.out.print("Indtast nummer for superhelt: ");
            int number = scanner.nextInt();
            scanner.nextLine();

            SuperHero editHero = database.getallhelteDatabase().get(number - 1);
            System.out.println("Redigere superhelt information: " + editHero);

            System.out.println("Indskriv ny data. Vil du ikke redigiere tryk Enter.");
            System.out.println("Navn: " + editHero.getNavn());
            String newNavn = scanner.nextLine();
            if (!newNavn.isEmpty())
                editHero.setNavn(newNavn);

            System.out.println("Superhelte Alias:" + editHero.getAlias());
            String newAlias = scanner.nextLine();
            if (!newAlias.isEmpty())
                editHero.setAlias(newAlias);

            System.out.println("Superkræft: " + editHero.getSuperkræft());
            String newSuperkræft = scanner.nextLine();
            if (!newSuperkræft.isEmpty())
                editHero.setSuperkræft(newSuperkræft);

            System.out.println("Skabelsesår: " + editHero.getSkabelsesår());
            do {
                String newSkabelsesår = scanner.nextLine();
                if (!newSkabelsesår.isEmpty()) {
                    try {
                        editHero.setSkabelsesår(Integer.parseInt(newSkabelsesår));
                        writingError = false;

                    } catch (NumberFormatException nfe) {
                        System.out.println("Fejl opstået");
                        System.out.println("Indtast skabelsesår i tal");
                        writingError = true;
                    }
                }
            } while (writingError == true);

            System.out.println("Styrkeniveau: " + editHero.getStyrkeniveau());
            do {
                String newstyrkeniveau = scanner.nextLine();
                if (!newstyrkeniveau.isEmpty()) {
                    try {
                        editHero.setStyrkeniveau(Double.parseDouble(newstyrkeniveau));
                        writingError = false;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Fejl opstået");
                        System.out.println("Indtast styrkeniveau i tal");
                        writingError = true;
                    }
                }
            } while (writingError == true);

            System.out.println("Højde:" + editHero.getHøjde());
            do {
                String newhøjde = scanner.nextLine();
                if (!newhøjde.isEmpty()) {
                    try{
                    editHero.setHøjde(Double.parseDouble(newhøjde));
                        writingError = false;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Fejl opstået");
                        System.out.println("Indtast højde i tal");
                        writingError = true;
                }
            }
            } while (writingError == true);

            System.out.println("Menneske: " + editHero.isMenneske());
            String newMenneske = scanner.nextLine();
            if (!newMenneske.isEmpty())
                editHero.isMenneske();
        }
    }
}

