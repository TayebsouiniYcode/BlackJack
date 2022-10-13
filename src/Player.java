import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person{

    private double money = 5000;
    private double bet;

    public double getBet ( ) {
        return bet;
    }

    public boolean setBet ( double bet ) {
        if (this.money >= bet){
            this.money -= bet;
            this.bet = bet;
            return true;
        } else {
            System.out.println ("Dont have a money" );
            return false;
        }
    }

    public double getMoney ( ) {
        return money;
    }

    public void setMoney ( double money ) {
        this.money += money;
    }

    public void defineBet(){
        System.out.println ("Player: " + this.name + " money: " + this.money );

        int choix;

        do {
            System.out.println ("Enter your bet: <= " + this.money );
            System.out.println (" 1. 500 \n 2. 1000 \n 3. 2500 \n 4. 3000 \n 0. Annuler" );
            Scanner scan = new Scanner ( System.in );
            choix = scan.nextInt ();
            switch (choix) {
                case 1:
                    this.bet = 500;
                    this.money -= this.bet;
                    return;
                case 2:
                    this.bet = 1000;
                    this.money -= this.bet;
                    return;
                case 3:
                    this.bet = 2500;
                    this.money -= this.bet;
                    return;
                case 4:
                    this.bet = 3000;
                    this.money -= this.bet;
                    return;
                case 0:
                    return;
                default:
                    System.out.println ("Enter un choix valide : " );
            }
        } while (true);
    }

    public void showCartes() {
        System.out.println (this.cartes.toString () );
    }

    @Override
    public String toString ( ) {
        return "Player => " +
                "money=" + money +
                ", name='" + name + '\'' +
                ", cartes=" + cartes ;
    }
}
