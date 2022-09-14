import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Database database =new Database();
        database.createTestData();

        Scanner scanner = new Scanner(System.in);


        System.out.println("-----------------------------");
        do  {

            System.out.println("Velkommen til MySuperheroList");
            System.out.println("1. Opret Superhelte");
            System.out.println("3. Search for superhero");
            System.out.println("5. Liste over helte");
            System.out.println("9. Luk programmet");
            int startside = scanner.nextInt();
            scanner.nextLine();

            if (startside==1){
                scanner.nextLine();
                System.out.println("\n"+"Lav en superhelt: ");

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
                database.createSuperhero(superheltenavn,superheltalias,superheltekræfter,skabelsesår,styrkeniveau,højde,menneske);
                for(SuperHero helt : database.getallhelteDatabase()) {
                    System.out.println(helt);
                }
                //System.out.println("Din superhelte navn er "+superheltenavn+"\n"+"Din superheltealias er "+superheltalias+"\n"+"Din superheltkræfter er "+superheltekræfter+"\n"+"Din superhelte skabelsesår er "+skabelsesår+"\n"+"Din superhelte styrkeniveau er "+styrkeniveau+"\n"+"Din superhelts højde er "+højde+"\n"+"Din superhelt er et menneske "+menneske);



               /* System.out.println();
                for (SuperHero superhero : database.getallhelteDatabase()){
                    System.out.println("superhelte navn: "+superhero);
                }*/

            } else if (startside ==9) {
                System.out.println("Lukker programmet...");
            } else if (startside == 5) {
                System.out.println("Liste over helte: "+"\n");
                System.out.println(database.getallhelteDatabase());

            } else if (startside ==3) {
                System.out.println("Search for Superhero: "+"\n");
                String search = scanner.nextLine();

                SuperHero superHero = database.searchFor(search);
                System.out.println(superHero);
            }


        }while(true);

        /*if (startside == 9) {
            System.out.println("Lukker programmet...");
            *//*else if (startside ==5){
                System.out.println("liste over helte");
                System.out.println(database.helteDatabase);
             *//*
            }*/
        }
    }




