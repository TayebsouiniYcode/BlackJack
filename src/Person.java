import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    protected String name;
    protected HashMap<Integer, Integer> coins = new HashMap <> (  );
    protected ArrayList<Carte> cartes = new ArrayList <> (  );

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }
}
