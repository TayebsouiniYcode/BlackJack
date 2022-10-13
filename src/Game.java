import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Dealer dealer = new Dealer();
    private ArrayList<Carte> banqueCartes = new ArrayList < Carte > (  );
    private ArrayList<Carte> cartesDeffausser = new ArrayList <Carte> (  );
    private Player player;
    Scanner scan = new Scanner ( System.in );

    public void begin () {
        {
            creerPlayer ();
            creerCartes ();
            this.dealer.melangerCartes ( this.banqueCartes, this.player );
        }

        int choix;
        do {
            System.out.println ("1. Enter the game" );
            System.out.println ("2. Quitter" );
            choix = scan.nextInt ();

            switch (choix) {
                case 1:
                    System.out.println ("Money : " + player.getMoney () );
                    System.out.println ("Enter a bet: " );
                    System.out.println ("1. 500 \n2. 1000\n3. 3000" );
                    int bet =  scan.nextInt ();
                    switch (bet) {
                        case 1:
                            if ( this.player.setBet ( 500 ) )
                                startGame ();
                            break;
                        case 2:
                            if (this.player.setBet ( 1000 ))
                                startGame ();
                            break;
                        case 3:
                            if ( this.player.setBet ( 3000 ) )
                                startGame ();
                            break;
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println ("Enter a valide number !!" );
            }
        } while (choix != 2);
        /*
        {
            this.player.defineBet ();
            this.dealer.piocher ( this.banqueCartes, this.player );
        }
        {
            int choix = 0;
            do {
                this.dealer.showCartes();
                this.player.showCartes();

                if(checkBlackJack ()){

                } else {
                    if (player.getPoints () > 21){
                        System.out.println ("Your lost!!" );
                        restart ();
                    }
                    if (player.getPoints () == 21){
                        dealer.dealerPiocheCarte ( this.banqueCartes );
                    }
                    System.out.println ("1. Tirer une carte" );
                    System.out.println ("2. Stand" );

                    choix = scan.nextInt ();

                    switch (choix){
                        case 1:
                            this.dealer.hand ( this.banqueCartes, this.player );
                            break;
                    }

                }

            } while (this.dealer.isGaming ());
            System.out.println ("dealer is false" );
            player.showCartes ();
            System.out.println ("point: " + player.getPoints ());
        }

*/
        //creerCartes ();
        //dealer.melangerCartes(this.banqueCartes, this.player);
        //dealer.piocher(banqueCartes, this.player);
        //gameStat ();
        //checkBlackJack ();




    }

    public void startGame() {
        dealer.piocher ( banqueCartes, player );

        int choix;
        if (checkBlackJack ()) {

        } else {
            do {
                dealer.showCartes ();
                player.showCartes ();
                System.out.println ("your points : " + player.getPoints () );
                System.out.println (  "\n\n\n\n\n");
                if (player.getPoints () < 21){
                    System.out.println ("1. Tirer une carte" );
                    System.out.println ("2. stand" );
                    choix = scan.nextInt ();

                    switch (choix ) {
                        case 1:
                            dealer.playerPiocheCarte ( banqueCartes, player );
                            break;
                    }
                } else {
                    choix = 2;
                }
            } while (choix != 2);
            if (player.getPoints () <= 21){
                dealer.dealerPiocheCarte ( banqueCartes );
                System.out.println ("dealer cartes : " + this.dealer.getCartes ().toString () );
                System.out.println ("dealer point: " + this.dealer.getPoints () );
                checkTheWinner ( player, dealer );
            }
            if (player.getPoints () > 21){
                winner(false);
            }
        }
    }

    public void winner(boolean playerIsWin){
        if (playerIsWin){
            System.out.println ("You win" );
            this.player.setMoney ( this.player.getBet ( ) * 2);
            System.out.println ("Money: " + this.player.getMoney ());
        }

        if (!playerIsWin) {
            System.out.println ("you lost" );
            this.player.setBet ( 0 );
        }
        this.player.setBet ( 0 );
        this.cartesDeffausser.addAll ( this.player.getCartes () );
        this.cartesDeffausser.addAll ( this.dealer.getCartes () );
        this.player.resetCartes();
        this.dealer.resetCartes();
    }
    public void equalGame() {
        System.out.println ("Equal" );
        this.player.setMoney ( this.player.getBet () );
        this.player.setBet ( 0 );
        this.cartesDeffausser.addAll ( this.player.getCartes () );
        this.cartesDeffausser.addAll ( this.dealer.getCartes () );
        this.player.resetCartes();
        this.dealer.resetCartes();
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
        this.player = new Player ();
        Scanner scan = new Scanner ( System.in);
        this.player.setName(scan.nextLine ());
    }

    public void gameStat() {
        System.out.println ("dealer carte : " +dealer.getCartes ().get ( 0 ).toString () );
        System.out.println (player.getName () + " cartes : " + player.getCartes () + " your Score : " +player.getPoints () );
    }

    public boolean checkBlackJack() {
        if (this.player.getPoints() == 21){
            if (this.dealer.getPoints() == 21){
                System.out.println ("Equal !!" );
                this.player.setMoney (this.player.getBet ());
                return true;
            } else {
                System.out.println ("You win" );
                this.player.setMoney ( this.player.getBet ()*2 + this.player.getBet ()*1.5 );
                return true;
            }
        } else if (this.dealer.getPoints () == 21){
            System.out.println ("You lost !!" );
            restart ();
        }
        return false;
    }

    public void checkTheWinner(Player player, Dealer dealer){
        if (dealer.getPoints () <= 21){
            if (player.getPoints () < dealer.getPoints ()){
                winner ( false );
            } else if (player.getPoints () == dealer.getPoints ()){
                equalGame();
            } else if (player.getPoints () > dealer.getPoints ()){
                winner ( true );
            }
        }
    }

    public void restart() {

    }
}
