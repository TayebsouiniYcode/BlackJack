public class Player extends Person{

    private int money = 5000;


    public int getMoney ( ) {
        return money;
    }

    public void setMoney ( int money ) {
        this.money = money;
    }

    @Override
    public String toString ( ) {
        return "Player => " +
                "money=" + money +
                ", name='" + name + '\'' +
                ", cartes=" + cartes ;
    }
}
