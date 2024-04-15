package reseau_neurones;

public class NeuroneEntree extends Neurone {
    public NeuroneEntree(double[] poids, double seuil) {
        super(poids, seuil);  // Appelle correctement le constructeur de la classe de base
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0.0;
        for (int i = 0; i < entrees.length; i++) {
            somme += entrees[i] * poids[i];
        }
        return somme;
    }
}
