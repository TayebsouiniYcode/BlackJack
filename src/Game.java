import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Dealer dealer = new Dealer();
    ArrayList<Carte> banqueCartes = new ArrayList < Carte > (  );
    Player player;

    public void startGame() {
        creerPlayer();
        creerCartes ();
        //afficherBanqueCartes();
        dealer.melangerCartes(banqueCartes);
        afficherBanqueCartes ();
        dealer.piocher(banqueCartes, this.player);

        //System.out.println ("banque: ");
        //afficherBanqueCartes ();
        //System.out.println ( );
        //System.out.println ("Player: " + player.toString ());
        //System.out.println ("Dealer: " + dealer.toString () );

        dealer.hand(banqueCartes, player);





    }

    public void creerCartes() {
        for (int i = 1; i <= 4; i++){
            for (int j = 1; j <= 13; j++){
                Carte carte = new Carte (j, i);
                banqueCartes.add ( carte );
            }
        }
    }

    public void afficherBanqueCartes() {
        for ( int i = 0; i < banqueCartes.size ()-1; i++ ){
            System.out.print (this.banqueCartes.get ( i ).toString ()  + "\t");
        }
    }

    public void creerPlayer(){
        System.out.println ("Enter your name: " );
        player = new Player ();
        Scanner scan = new Scanner ( System.in);
        player.setName(scan.nextLine ());
    }
}
