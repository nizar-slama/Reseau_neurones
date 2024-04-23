package reseau_neurones;

public class Echantillon {
    private double[] entrees; // Entrées de l'échantillon
    private double resultatAttendu; // Résultat attendu pour ces entrées

    public Echantillon(double[] entrees, double resultatAttendu) {
        this.entrees = entrees;
        this.resultatAttendu = resultatAttendu;
    }

    // Getters
    public double[] getEntrees() {
        return entrees;
    }

    public double getResultatAttendu() {
        return resultatAttendu;
    }
}

