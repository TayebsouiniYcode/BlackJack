import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    protected String name;
    protected HashMap<Integer, Integer> coins = new HashMap <> (  );
    protected ArrayList<Carte> cartes = new ArrayList <> (  );
    protected int score = 0;

    public int getScore ( ) {
        return score;
    }

    public void setScore ( int score ) {
        this.score = score;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }
    public void resetCartes(){
        this.cartes.clear ();
    }

    public void setCarte(Carte carte){
        this.cartes.add ( carte );
    }

    public String getName ( ) {
        return name;
    }

    public int getPoints(){
        int counter = 0;
        int counterAs = 0;
        for ( Carte carte : this.cartes ) {
            if(carte.getHauteur () <= 10 && carte.getHauteur () > 1) {
                counter += carte.getHauteur ( );
            } else if (carte.getHauteur () > 10){
                counter += 10;
            } else if (carte.getHauteur () == 1){
                counterAs++;
            }
        }

        if (counterAs == 1 && counter <= 10){
            counter+= 11;
        }

        if (counterAs > 1 && counter == 0){
            counter+= 11;
            counter+= --counterAs;
        }

        if (counter > 10 && counterAs >= 1){
            counter+= counterAs;
        }

        return counter;
    }

    public void setName ( String name ) {
        this.name = name;
    }
}
