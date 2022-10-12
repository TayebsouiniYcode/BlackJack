public class Carte {

    private int hauteur;
    private int couleur;

    public void setHauteur ( int hauteur ) {
        this.hauteur = hauteur;
    }

    public void setCouleur ( int couleur ) {
        this.couleur = couleur;
    }

    public int getHauteur ( ) {
        return hauteur;
    }

    public int getCouleur ( ) {
        return couleur;
    }

    Carte( int hauteur, int couleur){
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "(" + this.hauteur + "  " + this.couleur + ")";
    }
}
