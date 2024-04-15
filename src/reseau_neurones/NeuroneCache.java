package reseau_neurones;

public class NeuroneCache extends Neurone {
    public NeuroneCache(double[] poids, double seuil) {
        super(poids, seuil);
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0.0;
        for (int i = 0; i < entrees.length; i++) {
            somme += entrees[i] * poids[i];
        }
        return Math.max(0, somme - seuil);  // Fonction d'activation ReLU
    }
}