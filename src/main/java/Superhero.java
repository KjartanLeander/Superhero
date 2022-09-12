import java.util.Scanner;

public class Superhero {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Superhelt navn?");
        String superheltenavn = scanner.nextLine();
        System.out.println("Superhelt alias?");
        String superheltalias = scanner.nextLine();
        System.out.println("superheltkræfter?");
        String superheltekræfter = scanner.nextLine();
        System.out.println("skabelsesår?");
        int skabelsesår = scanner.nextInt();
        System.out.println("styrkeniveau?");
        double styrkeniveau = scanner.nextDouble();
        System.out.println("højde");
        double højde = scanner.nextDouble();
        System.out.println("menneske");
        boolean menneske = scanner.nextBoolean();


    //SuperHeroInfo hero1 = new SuperHeroInfo("Else","Frozen","Is","2013",2300,165,true);
    SuperHeroInfo hero = new SuperHeroInfo(superheltenavn,superheltalias,superheltekræfter,skabelsesår,styrkeniveau,højde,menneske);
            }

    }

