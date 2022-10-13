import java.util.Scanner;

public class Menu {

    public  void menuPrincipale() {
        int choix;
        do {
            System.out.println ("Weclom to BlackJack game \n \n 1. Jouer \n \n 2. Quitter" );
            Scanner scan = new Scanner (System.in);
            choix = scan.nextInt ();

            switch (choix) {
                case 1:
                    Game game = new Game();
                    game.begin ();
                    break;
            }

        } while (choix != 2);
    }
}
