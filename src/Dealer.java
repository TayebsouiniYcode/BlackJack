import java.lang.reflect.Array;
import java.util.*;

public class Dealer extends Person{
    private boolean gaming = true;

    public boolean isGaming ( ) {
        return gaming;
    }

    public void setGaming ( boolean gaming ) {
        this.gaming = gaming;
    }

    public void showCartes() {
        if(this.gaming){
            System.out.println (this.cartes.get ( 0 ) );
        } else {
            System.out.println (this.cartes.toString () );
        }
    }

    public void melangerCartes( ArrayList banqueCartes, Player player){

        ArrayList list = new ArrayList (  );
        for ( int i = 0 ; i < 52 ; i++ ) {
            list = tirerUneCarte(banqueCartes);
            banqueCartes.remove ( list.get ( 0 ) );
            banqueCartes.add ( list.get ( 0 ) );
        }
    }

    public ArrayList tirerUneCarte(ArrayList banqueCartes){
        Random random = new Random ( );
        int n = random.nextInt (52);
        return extraireUneCarte(banqueCartes, n);
    }

    public ArrayList extraireUneCarte(ArrayList banqueCartes, int n){
        ArrayList list = new ArrayList (  );

        list.add ( banqueCartes.get ( n ) );
        list.add ( banqueCartes );

        return list;
    }

    public void piocher(ArrayList banqueCartes, Player player){
        this.cartes.add ( (Carte) banqueCartes.get ( 0 ) );
        banqueCartes.remove ( 0 );
        player.cartes.add ( (Carte) banqueCartes.get ( 0 ) );
        banqueCartes.remove ( 0 );
        player.cartes.add ( (Carte) banqueCartes.get ( 0 ) );
        banqueCartes.remove ( 0 );
        this.cartes.add ( (Carte) banqueCartes.get ( 0 ) );
        banqueCartes.remove ( 0 );
    }

    public void piocherAvecBlackJack(ArrayList banqueCartes, Player player){
        this.cartes.add ( new Carte ( 1 ,1 ) );
        player.cartes.add ( new Carte ( 1, 1 ) );
        player.cartes.add ( new Carte ( 10, 1 ) );
        this.cartes.add ( new Carte ( 2 ,1 ) );
    }

    public void hand(ArrayList banqueCartes, Player player){
        playerPiocheCarte(banqueCartes, player);
    }
    public void dealerPiocheCarte(ArrayList banqueCartes){
        while (getPoints () < 17){
            this.cartes.add ( (Carte) banqueCartes.get ( 0 ) );
            banqueCartes.remove ( 0 );
        }
        this.gaming = false;
    }

    public void deffausserCartes(Player player, Dealer dealer, ArrayList cartesDeffausser){
        for ( Carte carte : player.getCartes ( ) ) {
            cartesDeffausser.add ( carte );
        }
        for ( Carte carte : dealer.getCartes ( ) ) {
            cartesDeffausser.add ( carte );
        }
    }

    public void deffausser(ArrayList banqueCartes, ArrayList cartesDeffaussees, Player player){
        banqueCartes.addAll ( cartesDeffaussees );
        melangerCartes ( banqueCartes, player );
    }
    public void playerPiocheCarte(ArrayList<Carte> banqueCartes, Player player){
        Carte carte = new Carte ( banqueCartes.get ( 0 ).getHauteur (), banqueCartes.get ( 0 ).getCouleur () );
        banqueCartes.remove ( 0 );
        if (carte.getHauteur () == 0 && carte.getCouleur () == 0){
            Carte carte1 = new Carte ( banqueCartes.get ( 0 ).getHauteur (), banqueCartes.get ( 0 ).getCouleur () );
            banqueCartes.remove ( 0 );
            player.setCarte ( carte1 );
            Game.redIsActive = !Game.redIsActive;
        } else {
            player.setCarte(carte);

        }
    }

    @Override
    public String toString ( ) {
        return "Dealer => " +
                "name='" + name + '\'' +
                ", cartes=" + cartes ;
    }
}
