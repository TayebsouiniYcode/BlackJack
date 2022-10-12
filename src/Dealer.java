import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Dealer extends Person{

    public ArrayList melangerCartes(ArrayList banqueCartes){

        ArrayList list = new ArrayList (  );
        for ( int i = 0 ; i < 52 ; i++ ) {
            list = tirerUneCarte(banqueCartes);
            banqueCartes.remove ( list.get ( 0 ) );
            banqueCartes.add ( list.get ( 0 ) );
        }

        return banqueCartes;
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

    public void hand(ArrayList banqueCartes, Player player){

    }

    @Override
    public String toString ( ) {
        return "Dealer => " +
                "name='" + name + '\'' +
                ", cartes=" + cartes ;
    }
}
