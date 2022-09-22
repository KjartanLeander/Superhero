import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.SQLOutput;

public class UserInterFace {
    Scanner scanner = new Scanner(System.in);
    Database database = new Database();

    public void startProgram() {
        database.createTestData();
        boolean writingError;
        do {
            do {

                startside();
                try {
                    int menu = scanner.nextInt();
                    scanner.nextLine();
                    if (menu == 1) {
                        lavSuperHelt1();
                    } else if (menu == 3) {
                        søgEfterSuperhelt3();
                    } else if (menu == 4) {
                        deleteSuperhero();
                    } else if (menu == 5) {
                        listeOverhelte();
                    } else if (menu == 7) {
                        editSuperhero();
                    } else if (menu == 9) {
                        lukProgrammet();
                    }
                    writingError = false;

                } catch (InputMismatchException ime) {
                    System.out.println("Fejl opstået");
                    System.out.println("Indtast tal");
                    scanner.nextLine();
                    writingError = true;
                }

            } while (writingError == true);
        } while (true);
    }

    private void lukProgrammet() {
        System.out.println("Lukker programmet...");
        System.exit(0);
    }

    public void startside() {
        System.out.println("Velkommen til MySuperheroList");
        System.out.println("1. Opret Superhelte");
        System.out.println("3. Search for superhero");
        System.out.println("4. Slet superhelt");
        System.out.println("5. Liste over helte");
        System.out.println("7. Redigere superhelt");
        System.out.println("9. Luk programmet");
    }

    public void lavSuperHelt1() {
        boolean writingError;
        System.out.println("\n" + "Lav en superhelt: ");
        System.out.println("Superhelt navn?");
        String superheltenavn = scanner.nextLine();
        System.out.println("Superhelt alias?");
        String superheltalias = scanner.nextLine();
        System.out.println("Superheltkræfter?");
        String superheltekræfter = scanner.nextLine();
        System.out.println("Skabelsesår?");

        int skabelsesår = 0;
        do {
            try {
                skabelsesår = scanner.nextInt();
                scanner.nextLine();
                writingError = false;

            } catch (InputMismatchException ime) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast skabelsesår i tal");
                scanner.nextLine();
                writingError = true;
            }
        } while (writingError == true);

        //lav try catch
        System.out.println("Styrkeniveau?");
        double styrkeniveau = 0;
        do {
            try {
                styrkeniveau = scanner.nextDouble();
                scanner.nextLine();
                writingError = false;
            } catch (InputMismatchException ime) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast Styrkeniveau i tal");
                scanner.nextLine();
                writingError = true;
            }
        } while (writingError == true);

        System.out.println("Højde?");
        double højde = 0;
        do {
            try {
                højde = scanner.nextDouble();
                scanner.nextLine();
                writingError = false;
            } catch (InputMismatchException ime) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast højde i tal");
                scanner.nextLine();
                writingError = true;
            }
        } while (writingError == true);

        //lav try catch
        System.out.println("Menneske?(True/false");
        boolean menneske;
        do {
            try {
                menneske = scanner.nextBoolean();
                database.createSuperhero(superheltenavn, superheltalias, superheltekræfter, skabelsesår, styrkeniveau, højde, menneske);
                for (SuperHero helt : database.getallhelteDatabase())
                    System.out.println(helt);
                scanner.nextLine();
                writingError = false;
            } catch (InputMismatchException ime) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast true eller false");
                scanner.nextLine();
                writingError = true;
            }

        } while (writingError == true);
    }

    public void søgEfterSuperhelt3() {

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
        boolean writingError;

        System.out.println("Superheroes");
        for (int i = 0; i < database.getallhelteDatabase().size(); i++) {
            System.out.println(i + 1 + ": " + database.getallhelteDatabase().get(i));
        }

        System.out.print("Indtast nummer for superhelt: ");
        int number = 0;
        SuperHero editHero = null;
        do {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                writingError = false;
                editHero = database.getallhelteDatabase().get(number - 1);
            } catch (InputMismatchException ime) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast tal");
                scanner.nextLine();
                writingError = true;
            } catch (IndexOutOfBoundsException ibe) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast gyldigt tal");
                writingError = true;
            }

        } while (writingError == true);


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
                try {
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
        do {
            String newMenneske = scanner.nextLine();
            if (!newMenneske.isEmpty()) {
                try {
                    editHero.setMenneske(Boolean.parseBoolean(newMenneske));
                    writingError = false;
                } catch (NumberFormatException nfe) {
                    System.out.println("Fejl opstået");
                    System.out.println("Indtast true eller false");
                    writingError = true;
                }
            }
        } while (writingError == true);
    }

    public void deleteSuperhero() {
        String searchTerm = scanner.nextLine();
        ArrayList<SuperHero> searchresults = database.searchFor(searchTerm);
        boolean writingError = false;
        do {
            try {
                if (searchresults.isEmpty()) {
                    System.out.println("Ingen resultater fundet med søgeterm: " + searchTerm);
                } else {
                    System.out.println("Vælg den superhelt du vil slette:(skriv tal udefra superhelt) ");
                    int index = 1;
                    for (SuperHero searchResults : searchresults) {
                        System.out.println(index++ + ") " + searchResults.getNavn());
                    }
                }
            }catch (NumberFormatException nfe) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast tal for superhelt");
                writingError = true;
            }
        } while (writingError == true);

        int superheroPick = 1;
        superheroPick = Integer.parseInt(scanner.nextLine());
        SuperHero deleteSuperhero = searchresults.get(superheroPick - 1);
        database.deleteSuperhero(deleteSuperhero);
        System.out.println(deleteSuperhero.getNavn() + " er nu slettet fra databasen");
    }
}

