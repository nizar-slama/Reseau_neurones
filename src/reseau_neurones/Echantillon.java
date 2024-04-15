package reseau_neurones;

public class Echantillon {
    private int[] entrees;
    private int resultatAttendu;

    public Echantillon(int[] entrees, int resultatAttendu) {
        this.entrees = entrees;
        this.resultatAttendu = resultatAttendu;
    }

    public int[] getEntrees() {
        return entrees;
    }

    public int getResultatAttendu() {
        return resultatAttendu;
    }
}
